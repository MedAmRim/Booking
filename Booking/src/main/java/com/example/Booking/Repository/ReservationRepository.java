package com.example.Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Booking.Entities.Reservation;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
