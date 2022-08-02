package com.example.Booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Booking.Dao.IhotelDao;
import com.example.Booking.Entities.Equipement;
import com.example.Booking.Entities.Hotel;

@RestController
@RequestMapping("/Hotels")
public class HotelController {
	
	@Autowired
	private IhotelDao ihotelDao;
	

	@GetMapping("/listehotels")
	public ResponseEntity<List<Hotel>> listehotels(){
		List<Hotel> hotels = ihotelDao.listhotels();
		return new ResponseEntity<>(hotels,HttpStatus.OK);
	}
	@PostMapping("/AjouterHotel")
	public ResponseEntity<Hotel> AjouterHotel(@RequestBody Hotel h)
	{
		Hotel ho =  ihotelDao.ajouterHotel(h);
		return new ResponseEntity<>(ho,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/SupprimerHotel/{id}")
	public ResponseEntity<?> SupprimerHotel(@PathVariable("id") Long id){
		ihotelDao.supprimerHotel(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping("/ModifierHotel")
	public ResponseEntity<Hotel> ModifierHotel(@RequestBody Hotel h)
	{
		Hotel ho = ihotelDao.modifierrHotel(h);
		return new ResponseEntity<>(ho,HttpStatus.OK);
	}

	@GetMapping("/ChercherHotel")
	public ResponseEntity<Hotel> ChercherHotel(@RequestParam Long id){
		Hotel ch = ihotelDao.chercherHotel(id);
		return new ResponseEntity<>(ch,HttpStatus.OK);
	}
	@GetMapping("/listequihotel")
	public ResponseEntity<List<Equipement>> listeequipemntshotel(@RequestParam Long id){
		List<Equipement> equipements = ihotelDao.listequipsHotel(id);
		return new ResponseEntity<>(equipements,HttpStatus.OK);
	}
	
	@GetMapping("/findHotelByVille")
	public ResponseEntity<List<Hotel>> findHotelByVille(@RequestParam String ville){
		List<Hotel> hotels = ihotelDao.findHotelByVille(ville);
		return new ResponseEntity<>(hotels,HttpStatus.OK);
	}
	@PostMapping("/AffecterEquitohotel")
	public ResponseEntity<?> AffecterEquitohotel(@RequestParam Long idh , @RequestParam Long ide){
		ihotelDao.affecterEquiptoHotel(ide, idh);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	
	
}
