package com.example.Booking.Dao;


import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Booking.Entities.Adresse;
import com.example.Booking.Repository.AdresseRepository;

@Service 
@Transactional
public class AdresseDaoImpl implements IadresseDao {
	@Autowired
	private AdresseRepository adresseRepository;
	@Override
	public Adresse AjouterAdresse(Adresse a) {
		
		return adresseRepository.save(a);
		
	}
	
	@Override
	public Adresse ModifierAdresse(Adresse a) {
		
		return adresseRepository.updateAdress(a.getRegion(),
		a.getVille(), a.getCartier(), a.getHotel().getId_hotel(),
		 a.getId_adresse());
	}

	@Override
	public void SupprimerAdresse(Long id) {
		adresseRepository.deleteById(id);
		
	}
	@Override
	public List<Adresse> findByVille(String Ville) {
		
		List<Adresse> adrs = listadrs();
		
		
		List<Adresse>  tmp = adrs.stream().filter(adresse->adresse.getVille().equals(Ville))
		.collect(Collectors.toList());
		
		return tmp;
	}
	@Override
	public List<Adresse> listadrs() {
		
		return adresseRepository.findAll();
	}

}
