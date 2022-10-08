package com.example.Booking.Dao;

import java.util.List;

import com.example.Booking.Entities.Chambre;

public interface IchambreDao {
	
	public Chambre ajouterChambre(Chambre c);
	public Chambre modifierChambre(Chambre c);
	public void supprimerChambre(Long id);
	public List<Chambre> listchambres();
	public Chambre charcherChambre(Long id);
	
	public List<Chambre> getChamberbyHotel(Long id);
}
