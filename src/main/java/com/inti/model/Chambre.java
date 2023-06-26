package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Chambre {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int numero;
	private double superficie;
	private int etage;
	@NonNull
	private boolean disponibilite;
	private double prix;
	
	@ManyToOne
	@JoinColumn(name="id_hotel")
	private Hotel hotel;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

}