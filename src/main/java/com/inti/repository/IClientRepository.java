package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer>{

	Object getReferenceById(int id);

}