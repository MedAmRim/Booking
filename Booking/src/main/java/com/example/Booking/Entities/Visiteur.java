package com.example.Booking.Entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor
@NoArgsConstructor
public class Visiteur {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id_visiteur;
	private String nom_visiteur;
	private String prenom_visiteur;
	private String telephone;
	
	@OneToMany(mappedBy = "visiteur")
	@JsonProperty(access = Access.WRITE_ONLY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Reservation> reservations;
	
	public Visiteur(String nom, String prenom , String tel , List<Reservation> reservations)
	{
		super();
		this.nom_visiteur = nom;
		this.prenom_visiteur = prenom;
		this.telephone = tel;
		this.reservations =reservations;
	}
	

}
