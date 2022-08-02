package com.example.Booking.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Booking.Entities.Chambre;
import com.example.Booking.Repository.ChambreRepository;

@Service
@Transactional
public class ChambreDaoImpl implements  IchambreDao{
	@Autowired
	private ChambreRepository chambreRepository;
	@Override
	public Chambre ajouterChambre(Chambre c) {
		
		return chambreRepository.save(c);
	}
	@Override
	public Chambre charcherChambre(Long id) {
		
		return chambreRepository.findById(id).orElse(null);
	}
	@Override
	public List<Chambre> listchambres() {
		
		return chambreRepository.findAll();
	}
	@Override
	public Chambre modifierChambre(Chambre c) {
	
		return chambreRepository.save(c);
	}
	@Override
	public void supprimerChambre(Long id) {
		chambreRepository.deleteById(id);
		
	}

}
