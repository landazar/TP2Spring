package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Client;
import com.inti.repository.IClientRepository;

@Controller
public class ClientController {
		
		@Autowired
		IClientRepository cr;
		
    @GetMapping("/client")
	public String client() {
		return "client";
	}

//Create
		@GetMapping("creerClient")
		public String creerClient(Model model)
		{
			model.addAttribute("client", new Client());
			return "creerClient";
		}
		
		@PostMapping("creerClient")
		public String creerClient(@ModelAttribute Client c)
		{
			cr.save(c);
			return "redirect:/listeClient";
		}
		
//Read
		@GetMapping("/listeClient")
		public String afficherListeClient(Model model) {
			model.addAttribute("client", cr.findAll());
			return "listeClient";
		}
		
		
//Update
		@GetMapping("/modifierClient/{id}")
		public String formulaireModification(@PathVariable("id") int id, Model model) {
			model.addAttribute("c", cr.getReferenceById(id));
			return "modifierClient";
		}

		@PostMapping("/modifierClient/{id}")
		public String modifierClient(@PathVariable("id") int id, @ModelAttribute Client c) {
			cr.save(c);
			return "redirect:/listeClient";
		}

//Delete		
		@GetMapping("supprimerClient/{id}")
		public String supprimerClient(@PathVariable("id") int id)
		{
			cr.delete(cr.getById(id));
			return "redirect:/listeClient";
		}

}
