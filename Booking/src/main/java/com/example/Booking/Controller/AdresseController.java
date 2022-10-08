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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Booking.Dao.IadresseDao;
import com.example.Booking.Entities.Adresse;

@RestController
@CrossOrigin("*")
@RequestMapping("/Adresse")
public class AdresseController {
	
	 @Autowired
	 private IadresseDao iadresseDao;
	 
	 @GetMapping("/ListAdresses")
	 public ResponseEntity<List<Adresse>> ListADrs(){
		 
		List<Adresse> adrs =  iadresseDao.listadrs();
		return new ResponseEntity<>(adrs,HttpStatus.OK);		
	 }
	 @PostMapping("/Ajouter")
	 public ResponseEntity<Adresse> AjouterAdrs(@RequestBody Adresse a){
		 Adresse adr = iadresseDao.AjouterAdresse(a);
		 return new ResponseEntity<>(adr,HttpStatus.CREATED);
	 }
	 @PutMapping("/Modifier")
	 public ResponseEntity<Adresse> ModifierAdrs(@RequestBody Adresse a){
		 Adresse adr = iadresseDao.ModifierAdresse(a);
		 return new ResponseEntity<>(adr,HttpStatus.OK);
	 }
	 @DeleteMapping("/Supprimer/{id}")
	 public ResponseEntity<?> SupprimerAdrs(@PathVariable Long id){
		 
		 iadresseDao.SupprimerAdresse(id);
		 System.out.println("++++++++++++");
		 return new ResponseEntity<>(HttpStatus.OK);
	 }
	 
	 @GetMapping("/AdresseByVille/{ville}")
	 public ResponseEntity<List<Adresse>> AdrsByVille(@PathVariable("ville") String ville){
		
		 List<Adresse> adrs = iadresseDao.findByVille(ville);
		 return new ResponseEntity<>(adrs,HttpStatus.OK);
	 }

}
