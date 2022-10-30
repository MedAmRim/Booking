package com.example.Booking.Dao;


import java.util.List;

import com.example.Booking.Entities.Chambre;
import com.example.Booking.Entities.Reservation;
import com.example.Booking.Entities.Visiteur;

public interface IreservationDao {
	
	public Reservation ajouterReservation(Reservation r);
	public float tarifs(Long id);
	public Reservation chercherReservation(Long id);
	public Reservation addVisiteur(Reservation r, Visiteur v);	
	public Reservation addChambersToReservation(List<Chambre> chambers , Long idr);	
	public Reservation updateReservation(Reservation r);
}
