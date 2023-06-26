package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Role;
import com.inti.model.Salarie;
import com.inti.repository.ISalarieRepository;

@Controller
public class SalarieController {
	
	@Autowired
	ISalarieRepository isr;
	
//	@Autowired
//	IRoleRepository irr;
	
	  
	@GetMapping("creerSalarie")
	public String creerSalarie() {
		return "creerSalarie";
	}

	// 
	@PostMapping("creerSalarie")   
	public String creerSalarie(@ModelAttribute("salarie") Salarie s) {
		
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		s.setMdp(b.encode(s.getMdp()));
		

//		List<Role> listeR = List.of(isr.getById(4));
//		u.setListRoles(listeR);

		isr.save(s);
		return "redirect:creerSalarie";
	}
	
	

	
	
	
	
	
	
	

	
	@GetMapping("connexionSalarie")
	public String connexionSalarie() {
		return "connexionSalarie";
	}
	
	@PostMapping("connexionSalarie")
	public String recupererSalarie(@ModelAttribute ("salarie") Salarie s, Model m) {
		Salarie s1 = isr.findByLoginAndMdp(s.getLogin(), s.getMdp());
		m.addAttribute("salarie", s1);
		if(s1 == null)
		{
			m.addAttribute("erreur", true);
			return "connexionSalarie";
		}
		return "redirect:/";
	}
	
	
}
