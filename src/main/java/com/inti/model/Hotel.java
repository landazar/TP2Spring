package com.inti.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString.Exclude;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	@Column(nullable = false)
	private String tel;
	@NonNull
	@Column(unique = true, nullable = false)
	private String adresse;
	
	@OneToMany(mappedBy = "hotel")
	@Exclude
	private List<Salarie> listeS;
	
	@OneToMany(mappedBy = "hotel")
	@Exclude
	private List<Chambre> listeC;

}
