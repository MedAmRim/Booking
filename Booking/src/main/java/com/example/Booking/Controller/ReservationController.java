package com.example.Booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Booking.Dao.IreservationDao;
import com.example.Booking.Entities.Chambre;
import com.example.Booking.Entities.Reservation;
import com.example.Booking.Entities.Visiteur;

@RestController
@RequestMapping("/reservations")
@CrossOrigin("*")
public class ReservationController {
	@Autowired
	private IreservationDao ireservationDao;
	
	@PostMapping("/AjouterReservation")
	public ResponseEntity<Reservation> AjouterReservation(@RequestBody Reservation c)
	{
		Reservation r = ireservationDao.ajouterReservation(c);
		return new ResponseEntity<>(r,HttpStatus.CREATED);
	}
	@GetMapping("/ChercherReservation")
	public ResponseEntity<Reservation> ChercherReservation(@RequestParam Long id){
		Reservation ch = ireservationDao.chercherReservation(id);
		return new ResponseEntity<>(ch,HttpStatus.OK);
	}
	
	@GetMapping("/tarif")
	public ResponseEntity<Float> tarifs(@RequestParam Long id){
		float tarif = ireservationDao.tarifs(id);
		return new ResponseEntity<>(tarif,HttpStatus.OK);
	}
	@PostMapping("/addVisiteur")
	public ResponseEntity<Reservation> addVisiteur(@RequestBody Visiteur v , @RequestBody Reservation r){
		
		Reservation reservation = ireservationDao.addVisiteur(r, v);
		return new ResponseEntity<>(reservation,HttpStatus.OK);
	}
	@PostMapping("/addchamberstoR/{id}")
	public ResponseEntity<Reservation> addChambersToReservation(@RequestBody List<Chambre> chambres, @PathVariable Long id)
	{
		Reservation r = ireservationDao.addChambersToReservation(chambres, id);
		return new ResponseEntity<>(r,HttpStatus.OK);
	}

}
