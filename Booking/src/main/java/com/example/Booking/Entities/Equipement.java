package com.example.Booking.Entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Equipement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_equipement;
	private String nom_equipement;
	private String description_equipemnt;
	
	@ManyToMany(mappedBy = "equipements")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Hotel> hotels;

	public Equipement(String nom_equipement, String description_equipemnt, List<Hotel> hotels) {
		super();
		this.nom_equipement = nom_equipement;
		this.description_equipemnt = description_equipemnt;
		this.hotels = hotels;
	}
	
	
	
	

}
