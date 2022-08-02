package com.example.Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Booking.Entities.Visiteur;

public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {

}
