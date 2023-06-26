package com.inti.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Hotel;
import com.inti.repository.IHotelRepository;



@Controller
@RequestMapping("hotel")
public class HotelController {
	
	@Autowired
	IHotelRepository ihr;
	
	@GetMapping("ajoutHotel")
	public String ajoutHotel()
	{
		return "ajoutHotel";
	}
	
	@PostMapping("ajoutHotel")
	public String ajoutHotel(@ModelAttribute("hotel") Hotel h)
	{
		ihr.save(h);
		return "redirect:listeHotel";
	}
	
	@GetMapping("listeHotel")
	public String listeHotel(Model m)
	{
		
		m.addAttribute("listeH", ihr.findAll());
		return "listeHotel";
	}
	
	@GetMapping("deleteHotel/{id}")
	public String deleteHotel(@PathVariable("id") int id)
	{
		Hotel h = ihr.getById(id);
		ihr.delete(h);
		return "redirect:listeHotel";
	}
	
	@GetMapping("modifierHotel/{id}")
	public String modifierHotel(@PathVariable("id") int id, Model m)
	{
		m.addAttribute("h1", ihr.getById(id));
		
		return "modifierHotel";
	}
	
	@PostMapping("modifierHotel/{id}")
	public String updateHotel(@PathVariable("id") int id, @ModelAttribute("hotel") Hotel h)
	{
		ihr.save(h);
		
		return "redirect:listeHotel";
	}

}
