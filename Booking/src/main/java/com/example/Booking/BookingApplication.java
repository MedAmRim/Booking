package com.example.Booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Booking.Controller.ChamberController;
import com.example.Booking.Dao.IadresseDao;
import com.example.Booking.Dao.IchambreDao;
import com.example.Booking.Dao.IequipementDao;
import com.example.Booking.Dao.IhotelDao;
import com.example.Booking.Dao.IreservationDao;
import com.example.Booking.Entities.Adresse;
import com.example.Booking.Entities.Chambre;
import com.example.Booking.Entities.Equipement;
import com.example.Booking.Entities.Hotel;
import com.example.Booking.Entities.Reservation;
import com.example.Booking.Entities.Visiteur;

@SpringBootApplication
public class BookingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
		
	}

	@Autowired
	private IreservationDao ireservationDao;
	@Autowired
	private IchambreDao  ichambreDao;
	@Autowired
	private IhotelDao  ihotelDao;
	@Autowired
	private IequipementDao  iquipIequipementDao;
	@Autowired
	private IadresseDao iadresseDao;
	@Override
	public void run(String... args) throws Exception {
		
		Adresse a = new Adresse("rabat-sale", "rabat", "Agdal",null );
		Hotel h = new Hotel("Othmane-Zineb", "Hotel spa ressot", a, null, null);
		//iadresseDao.AjouterAdresse(a);
		h.setAdresse(a);
		//Hotel h1 = ihotelDao.ajouterHotel(h);
		
		Visiteur v1 = new Visiteur("Othmane", "Oumoudid", "0706806418",null);
		Equipement e1 = new Equipement("piscin1", "adults", null);
		Equipement e2 = new Equipement("piscin2", "enfants", null);
		Chambre c1 = new Chambre(2, 4, 250.0F, "double", 205, null, null);
		Chambre c2 = new Chambre(2, 4, 250.0F, "Enfants", 206, null, null);
		
		
		List<Chambre> chambres  = new ArrayList<Chambre>();
		chambres.add(c1);
		chambres.add(c2);
		
		//ichambreDao.ajouterChambre(c1);
		//ichambreDao.ajouterChambre(c2);
		Hotel hotel = ihotelDao.AddChamberToHot(h, c1);
		//Hotel hotel2 = ihotelDao.AddChamberToHot(h, c2);
		
		for(Chambre c : hotel.getChambres())
		{
			System.out.println(c.getId_chambre());
		}
		
		Reservation r1 = new Reservation(LocalDate.of(2022, 6, 24),LocalDate.of(2022,8 , 28),2 , 2, "rabat", chambres, v1);
		
		
	
		//ireservationDao.ajouterReservation(r1);
		ireservationDao.addVisiteur(r1,v1);
		
		ireservationDao.addChambersToReservation(chambres, r1.getId_reservation());
		
		iquipIequipementDao.ajouterEquip(e1);
		iquipIequipementDao.ajouterEquip(e2);
		
		ihotelDao.affecterEquiptoHotel(e1.getId_equipement(), h.getId_hotel());
		
		List<Hotel> hotels = ihotelDao.findHotelByVille("rabat");
		float tarif = ireservationDao.tarifs(r1.getId_reservation());
//		System.out.println(hotels);
		
		
		System.out.println("tarifs "+tarif);
		
	}

}
