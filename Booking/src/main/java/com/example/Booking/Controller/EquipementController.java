package com.example.Booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Booking.Dao.IequipementDao;
import com.example.Booking.Entities.Equipement;

@RestController
@RequestMapping("Equipements")
@CrossOrigin("*")
public class EquipementController {
	
	@Autowired
	private IequipementDao iequipementDao;
	
	@GetMapping("/listequipemnts")
	public ResponseEntity<List<Equipement>> listEquipemnts(){
		List<Equipement> equipements = iequipementDao.listequips();
		return new ResponseEntity<>(equipements,HttpStatus.OK);
	}
	@PostMapping("/AjouterEqui")
	public ResponseEntity<Equipement> AjouterEqui(@RequestBody Equipement e)
	{
		Equipement eq =  iequipementDao.ajouterEquip(e);
		return new ResponseEntity<>(eq,HttpStatus.CREATED);
	}
	@PostMapping("/ModifierEqui")
	public ResponseEntity<Equipement> ModifierEqui(@RequestBody Equipement e)
	{
		Equipement eq = iequipementDao.modifierEquip(e);
		return new ResponseEntity<>(eq,HttpStatus.OK);
	}
	@DeleteMapping("/SupprimerEqui/{id}")
	public ResponseEntity<?> SupprimerEqui(@PathVariable("id") Long id){
		iequipementDao.supprimerEquip(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/ChercherEqui")
	public ResponseEntity<Equipement> ChercherEqui(@RequestParam Long id){
		Equipement e = iequipementDao.charcherEquipement(id);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
	

}
