package com.example.Booking.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Booking.Entities.Chambre;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {


    @Transactional
    @Modifying
    @Query("UPDATE Chambre c " +
            "SET c.nbr_lit = ?1, c.capacity = ?2," +
			"c.prix = ?3, c.typeChamber = ?4," +
			 "c.numChamber = ?5 WHERE c.id_chambre = ?6")
    Chambre updateChambre(int NombreLits,int capacity,
	int prix,String typeChamber, int numChamber,
	Long idChambre);

}
