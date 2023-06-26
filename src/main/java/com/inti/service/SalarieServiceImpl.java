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
	public Salarie findByLoginAndMdp(String login, String mdp) {
		// TODO Auto-generated method stub
		return isr.findByLoginAndMdp(login, mdp);
	}

	@Override
	public void saveSalarie(Salarie salarie) {
		isr.save(salarie);
		
	}

}
