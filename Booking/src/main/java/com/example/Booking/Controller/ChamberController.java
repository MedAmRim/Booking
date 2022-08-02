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

import com.example.Booking.Dao.IchambreDao;
import com.example.Booking.Entities.Chambre;
@RestController
@RequestMapping("/chambers")
public class ChamberController {
	
	@Autowired
	private IchambreDao ichambreDao;
	
	@GetMapping("/listechambers")
	public ResponseEntity<List<Chambre>> listChambers(){
		List<Chambre> chambres = ichambreDao.listchambres();
		return new ResponseEntity<>(chambres,HttpStatus.OK);
	}
	
	@PostMapping("/AjouterChamber")
	public ResponseEntity<Chambre> AjouterChamber(@RequestBody Chambre c)
	{
	Chambre ch = 	ichambreDao.ajouterChambre(c);
		return new ResponseEntity<>(ch,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/SupprimerChamber/{id}")
	public ResponseEntity<?> supprimerchamber(@PathVariable("id") Long id){
		ichambreDao.supprimerChambre(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping("/ModifierCha")
	public ResponseEntity<Chambre> ModifierChamber(@RequestBody Chambre c)
	{
		Chambre ch = ichambreDao.modifierChambre(c);
		return new ResponseEntity<>(ch,HttpStatus.OK);
	}

	@GetMapping("/ChercherChamber")
	public ResponseEntity<Chambre> chercherchamber(@RequestParam Long id){
		Chambre ch = ichambreDao.charcherChambre(id);
		return new ResponseEntity<>(ch,HttpStatus.OK);
	}
}
