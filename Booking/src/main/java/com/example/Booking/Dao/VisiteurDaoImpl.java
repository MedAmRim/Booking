package com.example.Booking.Dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Booking.Entities.Visiteur;
import com.example.Booking.Repository.VisiteurRepository;
@Service
@Transactional
public class VisiteurDaoImpl implements IvisiteurDao {
	@Autowired
	private VisiteurRepository visiteurRepository;
	@Override
	public Visiteur ajouterVisiteur(Visiteur v) {
		
		return visiteurRepository.save(v);
	}
	
}
