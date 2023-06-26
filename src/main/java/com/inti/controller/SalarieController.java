package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Role;
import com.inti.model.Salarie;

import com.inti.repository.IRoleRepository;
import com.inti.repository.ISalarieRepository;

@Controller
@RequestMapping("/salarie")
public class SalarieController {
	
	@Autowired
	ISalarieRepository isr;
	
	@Autowired
	IRoleRepository irr;
	
	  
	@GetMapping("creerSalarie")
	public String creerSalarie() {
		return "creerSalarie";
	}

	// j'ai mis le role 1 par defaut pour l'instant.
	
	@PostMapping("creerSalarie")   
	public String creerSalarie(@ModelAttribute("salarie") Salarie s) {
		System.out.println("555555555555555");
		
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		s.setMdp(b.encode(s.getMdp()));
		
		List<Role> listeR = List.of(irr.getById(1));
		s.setListeR(listeR);

		isr.save(s);
		return "redirect:/salarie/creerSalarie";
	}
	
	
	@GetMapping("salaries")
	public String getProduits(Model m) {
		m.addAttribute("listeS", isr.findAll().toArray());
		
		return "salaries";
	}
	
	@GetMapping("deleteSalarie/{id}")
	public String deleteSalarie(@PathVariable("id") int id)
	{
		isr.deleteById(id);
		
		return "redirect:/salarie/salaries";
	}
	
	
	@GetMapping("modifierSalarie/{id}")
	public String modifierSalarie(Model m, @PathVariable("id") int id)
	{
		m.addAttribute("p1", isr.getById(id));
		
		return "modifierSalarie";
	}
	
	
	
	@PostMapping("modifierSalarie/{id}")
	public String modifierSalarie(@ModelAttribute("salarie") Salarie s)
	{
		// Salarie s = isr.getById(id);
		System.out.println("5555555555555");
		isr.save(s);
		
		return "redirect:/salarie/salaries";
	}
	

	

	
	
}
