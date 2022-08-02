package com.example.Booking.Entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
public class Reservation implements Serializable{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id_reservation;
	private LocalDate date_depart;
	private LocalDate date_arrivee;
	private int nbrAdults;
	private int nbrEnfants;
	private String destination;
	
	@ManyToMany @JoinTable( name = "reservation_chambers", 
		     joinColumns = @JoinColumn( name = "id_reservation" ),
		     inverseJoinColumns = @JoinColumn( name = "id_chambre"))
			@JsonProperty(access = Access.WRITE_ONLY)
			@LazyCollection(LazyCollectionOption.FALSE)
	private List<Chambre> chambres = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "id_visiteur")
	private Visiteur visiteur;

	public Reservation(LocalDate date_depart, LocalDate date_arrivee, int nbrAdults, int nbrEnfants, String destination,
			List<Chambre> chambres, Visiteur visiteur) {
		super();
		this.date_depart = date_depart;
		this.date_arrivee = date_arrivee;
		this.nbrAdults = nbrAdults;
		this.nbrEnfants = nbrEnfants;
		this.destination = destination;
		this.chambres = chambres;
		this.visiteur = visiteur;
	}
	

}
