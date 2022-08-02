package com.example.Booking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Booking.Dao.IvisiteurDao;
import com.example.Booking.Entities.Visiteur;
@RestController
@RequestMapping("/visiteurs")
public class VisiteurController {

	
	@Autowired
	private IvisiteurDao ivisiteurDao;
	
	@PostMapping("/AjouterV")
	public ResponseEntity<Visiteur> AjouterVisiteur(@RequestBody Visiteur c)
	{
		Visiteur v= ivisiteurDao.ajouterVisiteur(c);
		return new ResponseEntity<>(v,HttpStatus.CREATED);
	}
}
