package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Role;
import com.inti.repository.IRoleRepository;

@Controller
public class AdminController {
	
	@Autowired
	IRoleRepository irr;
	
	@GetMapping("creerRole")
	public String creerRole()
	{
		return "creerRole";
	}
	
	@PostMapping("creerRole")
	public String creerRole(@ModelAttribute("role") Role r)
	{
		irr.save(r);
		
		return "creerRole";
	}

}
