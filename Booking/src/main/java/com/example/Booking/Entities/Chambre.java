package com.example.Booking.Entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor 
public class Chambre {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id_chambre;
	private int nbr_lit;
	private int capacity;
	private int prix;
	private String typeChamber;
	private int numChamber;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "id_hotel")
	private Hotel hotel;
	
	@ManyToMany(mappedBy = "chambres")
	@LazyCollection(LazyCollectionOption.FALSE) //we won't load the list of reservations immediately.
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Reservation> reservations;

	public Chambre(int nbr_lit, int capacity, int prix, String typeChamber, int numChamber, Hotel hotel,
			List<Reservation> reservations) {
		super();
		this.nbr_lit = nbr_lit;
		this.capacity = capacity;
		this.prix = prix;
		this.typeChamber = typeChamber;
		this.numChamber = numChamber;
		this.hotel = hotel;
		this.reservations = reservations;
	}
	
}
