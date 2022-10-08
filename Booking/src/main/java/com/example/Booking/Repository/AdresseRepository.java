package com.example.Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Booking.Entities.Adresse;
import com.example.Booking.Entities.Hotel;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {

	Hotel findByVille(String v);
}
