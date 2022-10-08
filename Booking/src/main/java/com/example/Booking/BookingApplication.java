package com.example.Booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.Booking.Controller.ChamberController;
import com.example.Booking.Dao.IadresseDao;
import com.example.Booking.Dao.IchambreDao;
import com.example.Booking.Dao.IequipementDao;
import com.example.Booking.Dao.IhotelDao;
import com.example.Booking.Dao.IreservationDao;
import com.example.Booking.Dao.IvisiteurDao;
import com.example.Booking.Entities.Adresse;
import com.example.Booking.Entities.Chambre;
import com.example.Booking.Entities.Equipement;
import com.example.Booking.Entities.Hotel;
import com.example.Booking.Entities.Reservation;
import com.example.Booking.Entities.Visiteur;
import com.example.Booking.Repository.AdresseRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@SpringBootApplication
public class BookingApplication implements CommandLineRunner {

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
	@Bean
	public WebMvcConfigurer corsMappingConfigurer() {
	   return new WebMvcConfigurer() {
	       @Override
	       public void addCorsMappings(CorsRegistry registry) {
	          
	           registry.addMapping("/**")
	             .allowedOrigins("http://localhost:4200")
	             .allowedMethods("GET", "POST", "PATCH", "PUT", "DELETE","OPTIONS", "HEAD")
	             .maxAge(3600)
	             .allowedHeaders("Requestor-Type")
	             .exposedHeaders("X-Get-Header");
	       }
	   };
	}

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
	@Autowired
	private IvisiteurDao ivisiteurDao; 
	
	private AdresseRepository adrrepo;
	
	@Override
	public void run(String... args) throws Exception {
	Hotel h = ihotelDao.chercherHotel(1L);
	Equipement e = iquipIequipementDao.charcherEquipement(2L);
	List<Hotel> ho = ihotelDao.findHotelByVille("rabat");
	ho.stream().map(Hotel::getNom).forEach(System.out::println);
	}
	
	
	

}
