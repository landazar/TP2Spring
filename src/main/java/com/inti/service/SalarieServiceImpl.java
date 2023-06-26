package com.inti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.Salarie;
import com.inti.repository.ISalarieRepository;

@Service
public class SalarieServiceImpl implements ISalarieService {
	
	@Autowired
	ISalarieRepository isr;

	@Override
	public Salarie findByLogin(String login) {
		// TODO Auto-generated method stub
		return isr.findByLogin(login);
	}

	@Override
	public void saveSalarie(Salarie salarie) {
		isr.save(salarie);
		
	}

}
