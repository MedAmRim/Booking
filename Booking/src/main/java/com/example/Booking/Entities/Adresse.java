package com.example.Booking.Entities;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Adresse {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id_adresse;
	private String region;
	private String ville;
	private String cartier;
	@OneToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "id_hotel")
	private Hotel hotel;
	public Adresse(String region, String ville, String cartier, Hotel hotel) {
		super();
		this.region = region;
		this.ville = ville;
		this.cartier = cartier;
		this.hotel = hotel;
	}
	
	

}
