package com.example.Booking.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Booking.Entities.Adresse;
import com.example.Booking.Entities.Hotel;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {

	Hotel findByVille(String v);

	@Transactional
    @Modifying
    @Query("UPDATE Adresse a " +
            "SET a.region = ?1, a.ville = ?2," +
			"a.cartier = ?3, a.id_hotel = ?4" +
			 "WHERE a.id_adresse = ?5")
    Adresse updateAdress(String region,String ville,
	String cartier,Long idHotel,
	Long idAdresse);
}
