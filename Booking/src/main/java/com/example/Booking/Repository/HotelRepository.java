package com.example.Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Booking.Entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

	
}
