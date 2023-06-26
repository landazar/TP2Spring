package com.inti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.inti.model.Role;
import com.inti.model.Salarie;
import com.inti.repository.IRoleRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	ISalarieService iss;
	
	@Autowired
	IRoleRepository irr;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Salarie s = iss.findByLoginAndMdp(username, username);
		
		if(s == null) {
			throw new UsernameNotFoundException("Salarie " + username + " n'est pas dans la bdd");
			
		}
		
		String nomRoles = "";
		int taille = 0;
		
		for(Role role : irr.findAllByIdSalarie(s.getId()))	{
			 nomRoles += role.getNomRole();
			 taille++;
		}
		
		if(taille < irr.findAllByIdSalarie(s.getId()).size()) {
			nomRoles += ",";
		}
		
		UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(s.getLogin())
								.password(s.getMdp())
								.roles(nomRoles)
								.build();
		return userDetails;
				
	}
	
	

}
