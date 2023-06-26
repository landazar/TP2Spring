package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Salarie;
import java.util.List;


@Repository
public interface ISalarieRepository extends JpaRepository<Salarie, Integer> {
	
	
//	Salarie findByLoginAndMdp(String login, String mdp);
	
	Salarie findByLogin(String login);

}
