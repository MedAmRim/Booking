package com.example.Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Booking.Entities.Equipement;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {
	

}
