package com.example.Booking.Dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Booking.Entities.Chambre;
import com.example.Booking.Entities.Equipement;
import com.example.Booking.Entities.Hotel;
import com.example.Booking.Repository.ChambreRepository;
import com.example.Booking.Repository.HotelRepository;
@Service
@Transactional
public class HotelDaoImpl implements IhotelDao{
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private IequipementDao equipementRepository;
	@Autowired
	private ChambreRepository ichambreDaoRe;
	
	@Override
	public void affecterEquiptoHotel(Long ide, Long idh) {
		
		Hotel h = (Hotel) chercherHotel(idh);
		Equipement e = equipementRepository.charcherEquipement(ide);
		if(e != null)
			{if(!h.getEquipements().contains(e))
				h.getEquipements().add(e);
			}
	  hotelRepository.save(h);
	  		
	}
	@Override
	public Hotel ajouterHotel(Hotel h) {
		
		return hotelRepository.save(h);
	}
	@Override
	public List<Hotel> findHotelByVille(String ville) {
		List<Hotel> hotels = listhotels();
		 listhotels();
		
		 List<Hotel> tmp = hotels.stream().filter(hotel->hotel.getAdresse().getVille().equals(ville))
				 .collect(Collectors.toList());

		return tmp;
	}
	@Override
	public List<Equipement> listequipsHotel(Long id) {
		
		Hotel hotel = chercherHotel(id);
		return hotel.getEquipements();
	}
	@Override
	public List<Hotel> listhotels() {
		return hotelRepository.findAll();
	}
	
	@Override
	public Hotel modifierrHotel(Hotel h) {
		
		return hotelRepository.save(h);
	}
	@Override
	public void supprimerHotel(Long id) {
		hotelRepository.deleteById(id);
		
	}
	@Override
	public Hotel chercherHotel(Long id) {
		
		return hotelRepository.findById(id).orElse(null);
	}
	@Override
	public Hotel AddChamberToHot(Hotel h, Chambre c) {
		h.addChambers(c);
		//ichambreDaoRe.save(c);
		return hotelRepository.save(h);
	}
}
