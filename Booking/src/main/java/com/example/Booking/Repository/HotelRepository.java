package com.example.Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Booking.Entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
