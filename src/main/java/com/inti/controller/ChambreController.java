package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Chambre;
import com.inti.repository.IChambreRepository;


@Controller
@RequestMapping("chambre")
public class ChambreController {
	
	@Autowired
	IChambreRepository ichr;
	
	@GetMapping("formChambre")
	public String formChambre() {
		return "formChambre";
	}
	@PostMapping("saveChambre")
	public String saveChambre(@ModelAttribute("chambre") Chambre ch) {
		ichr.save(ch);
		return "redirect:/listeChambre";
	}
	
	@GetMapping("listeChambre")
	public String listeChambre(Model m) {
		m.addAttribute("listeC", ichr.findAll().toArray());
		return "listeChambre";
	}
	
	@GetMapping("deleteChambre/{id}")
	public String deleteChambre(@PathVariable("id") int id) {
		ichr.deleteById(id);

		return "redirect:/chambre/listeChambre";
		
	}
	
	@GetMapping("modifierChambre/{id}")
	public String modifierChambre(@PathVariable("id") int id, Model m) {
		m.addAttribute("chambre", ichr.getById(id));

		return "modifierChambre";
	}
	
	@PostMapping("modifierChambre/updateChambre")
	public String updateChambre(@ModelAttribute("chambre") Chambre c)
	{
		ichr.save(c);
		return "redirect:/chambre/listeChambre";
	}
	

	
	
	
	

	
	
	
}
