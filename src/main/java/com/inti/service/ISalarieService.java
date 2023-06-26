package com.inti.service;

import com.inti.model.Salarie;

public interface ISalarieService {
	
	Salarie findByLogin(String login);
	void saveSalarie(Salarie salarie);

}
