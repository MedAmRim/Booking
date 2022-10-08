package com.example.Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Booking.Entities.Equipement;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {
	

}
