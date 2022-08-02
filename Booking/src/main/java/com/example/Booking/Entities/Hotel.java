package com.example.Booking.Entities;

import static javax.persistence.GenerationType.IDENTITY;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Hotel  {
	@Id 
	@GeneratedValue(strategy = IDENTITY)
	private Long id_hotel;
	
	private String nom;
	private String description;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_adresse")
	private Adresse adresse;
	
	@ManyToMany
	 @JoinTable( name = "Equipements_hotel",
     joinColumns = @JoinColumn( name = "id_hotel" ),
     inverseJoinColumns = @JoinColumn( name = "id_equipement"))
	@JsonProperty(access = Access.WRITE_ONLY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Equipement> equipements = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.EAGER,  mappedBy = "hotel" , cascade = CascadeType.PERSIST)
	private List<Chambre> chambres;

	public Hotel(String nom, String description, Adresse adresse, List<Equipement> equipements,
			List<Chambre> chambres) {
		super();
		this.nom = nom;
		this.description = description;
		this.adresse = adresse;
		this.equipements = equipements;
		this.chambres = chambres;
	}
	public void addChambers(Chambre c) {
		if(getChambres() == null)
		{
			List<Chambre> chambres = new ArrayList<Chambre>();
			chambres.add(c);
			this.setChambres(chambres);
		}
		else 
			getChambres().add(c);	
		
		c.setHotel(this);
	}
	
	
	

}
