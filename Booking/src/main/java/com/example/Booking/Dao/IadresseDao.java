package com.example.Booking.Dao;

import java.util.List;

import com.example.Booking.Entities.Adresse;

public interface IadresseDao {
	
	public Adresse AjouterAdresse(Adresse a);
	public Adresse ModifierAdresse(Adresse a);
	public void SupprimerAdresse(Long id);
	public List<Adresse> findByVille(String Ville);
	public List<Adresse> listadrs();


}
