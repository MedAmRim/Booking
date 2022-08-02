package com.example.Booking.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Booking.Entities.Equipement;
import com.example.Booking.Repository.EquipementRepository;
@Service
@Transactional
public class EquipementDaoImpl implements IequipementDao {
	@Autowired
	private EquipementRepository equipementRepository;
	@Override
	public Equipement ajouterEquip(Equipement e) {
		
		return equipementRepository.save(e);
	}
	@Override
	public Equipement charcherEquipement(Long id) {
		
		return equipementRepository.findById(id).orElse(null);
	}
	@Override
	public List<Equipement> listequips() {
		
		return equipementRepository.findAll();
	}
	@Override
	public Equipement modifierEquip(Equipement e) {
		
		return equipementRepository.save(e);
	}
	@Override
	public void supprimerEquip(Long id) {
		equipementRepository.deleteById(id);
		
	}

}
