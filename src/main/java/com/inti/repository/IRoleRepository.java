package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
	
	@Query(value = "select r.* from role r, salarie s, salarie_role sr " + 
	"where s.id=sr.id_salarie and r.id=sr.id_role and s.id = :id", nativeQuery = true)
	List<Role> findAllByIdSalarie(@Param("id") int idSalarie);


}



	



















>>>>>>> branch 'master' of https://github.com/landazar/TP2Spring.git
