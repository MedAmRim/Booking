package com.example.Booking.Dao;

import java.util.List;

import com.example.Booking.Entities.Equipement;

public interface IequipementDao {
	
	public Equipement ajouterEquip(Equipement e);
	public Equipement modifierEquip(Equipement e);
	public void supprimerEquip(Long id);
	public List<Equipement> listequips();
	public Equipement charcherEquipement(Long id);
	
	

}
