package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		return "redirect:/listeChambres";
	}
	@GetMapping("listeChambres")
	public String listeChambres() {
		return "listeChambres";
	}
	
	

	
	
	
	

	
	
	
}
