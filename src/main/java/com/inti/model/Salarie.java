package com.inti.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString.Exclude;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class Salarie {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	@Column(unique = true, length = 50, nullable = false)
	@NonNull
	private String login;
	
	@Column(nullable = false)
	@NonNull
	private String mdp;
	
	
	@Column
	@NonNull
	private String type;
	
	@Column
	@NonNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateNaissance;
	
	@Column
	@NonNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateEmbauche;

	

	@Exclude
	@ManyToMany
	@JoinTable(name = "salarie_role",
				joinColumns = @JoinColumn(name = "idSalarie"),
				inverseJoinColumns = @JoinColumn(name = "idRole"))
	private List<Role> listeR;

	
	@Exclude
	@ManyToOne
	@JoinColumn(name="idHotel")
	private Hotel hotel;
	
	
	
}



















