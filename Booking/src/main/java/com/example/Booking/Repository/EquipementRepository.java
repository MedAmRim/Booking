package com.example.Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Booking.Entities.Equipement;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {
	

}
