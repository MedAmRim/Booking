package com.example.Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Booking.Entities.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

}
