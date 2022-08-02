package com.example.Booking.Dao;

import java.util.List;

import com.example.Booking.Entities.Chambre;
import com.example.Booking.Entities.Equipement;
import com.example.Booking.Entities.Hotel;

public interface IhotelDao {
	
	
	public Hotel ajouterHotel(Hotel h);
	public Hotel modifierrHotel(Hotel h);
	public void supprimerHotel(Long id);
	public List<Hotel> listhotels();
	public void affecterEquiptoHotel(Long ide , Long idh);
	public List<Hotel> findHotelByVille(String ville);
	public List<Equipement> listequipsHotel(Long id);
	public Hotel chercherHotel(Long id);
	public Hotel AddChamberToHot(Hotel h , Chambre c);
	
	
	

}
