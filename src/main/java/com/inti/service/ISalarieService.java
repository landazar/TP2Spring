package com.inti.service;

import com.inti.model.Salarie;

public interface ISalarieService {
	
	Salarie findByLoginAndMdp(String login, String mdp);
	void saveSalarie(Salarie salarie);

}
