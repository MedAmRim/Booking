package com.example.Booking.Dao;

import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Booking.Entities.Chambre;
import com.example.Booking.Entities.Reservation;
import com.example.Booking.Entities.Visiteur;
import com.example.Booking.Repository.ReservationRepository;
@Service
@Transactional
public class ReservationDaoImpl implements IreservationDao{
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private IvisiteurDao visiteurRepository;
	@Override
	public Reservation ajouterReservation(Reservation r) {
		
		return reservationRepository.save(r);
		
	}
	@Override
	public float tarifs(Long id) {
		Reservation reservation = chercherReservation(id);
		List<Chambre> lists = reservation.getChambres();
		double totalprix =  lists.parallelStream().mapToDouble(prix->prix.getPrix()).sum();
		
		long differenceInDays = ChronoUnit.DAYS.between(reservation.getDate_arrivee(),reservation.getDate_depart() );
		
		return (float) (totalprix*differenceInDays);
	}
	@Override
	public Reservation chercherReservation(Long id) {
		
		return reservationRepository.findById(id).orElse(null);
	}
	@Override
	public Reservation addVisiteur(Reservation r, Visiteur v) {
		r.setVisiteur(v);
		visiteurRepository.ajouterVisiteur(v);
		return reservationRepository.save(r);
	}
	
	@Override
	public Reservation addChambersToReservation(List<Chambre> chambers , Long idr) {
		Reservation r = chercherReservation(idr); 
		
		List<Chambre> tmp = r.getChambres();

	chambers.forEach(tmp::add);
	r.setChambres(tmp);
	
		return r;
	}

}
