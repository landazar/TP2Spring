package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Role;
import com.inti.model.Salarie;
import com.inti.repository.IRoleRepository;
import com.inti.service.ISalarieService;

@Controller
public class MainController {
	
	@Autowired
	ISalarieService iss;
	
	@Autowired
	IRoleRepository irr;
	
	@GetMapping("login")
	public String login() {
		return "login";
	}

	
	@GetMapping("creerSalarieConnexion")
	public String creerSalarie() {
		return "creerSalarieConnexion";
	}
	@PostMapping("creerSalarieConnexion")
	public String creerSalarie(@ModelAttribute("salarie") Salarie salarie) {
		
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		String mdpCrypte = b.encode(salarie.getMdp());
		salarie.setMdp(mdpCrypte);
		
		List<Role> listeRole = List.of(irr.getById(1));
		salarie.setListeR(listeRole);
		iss.saveSalarie(salarie);
		
		return "redirect:/login";
	
	}
}
