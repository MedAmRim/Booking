package com.example.Booking.Repository;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Booking.Entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Reservation r " +
            "SET r.date_depart = ?1, r.date_arrivee = ?2," +
			"r.nbrAdults = ?3, r.nbrEnfants = ?4," +
			 "r.destination = ?5 WHERE c.id_reservation = ?6")
    Reservation updateReservation(LocalDate date_depart,
    LocalDate date_arrivee,
	int nbrAdults,
    int nbrEnfants,
    String destination,
	Long idReservation);
}
