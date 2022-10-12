package com.project.PlanYourTrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.PlanYourTrip.model.Hotel;
import com.project.PlanYourTrip.service.HotelService;



@RestController
public class HotelController {
	
	@Autowired
	private HotelService service;
	
	@PostMapping("/addHotel")
	@CrossOrigin(origins = "http://localhost:4200")
	public Hotel addHotel(@RequestBody Hotel hotel) {
		return service.saveHotel(hotel);
	}
	
	@GetMapping("/hotels")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Hotel> findAllHotels(){
		return service.getHotels();
	}
	
	@GetMapping("/getHotelById/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Hotel findHotelById(@PathVariable int id) {
		return service.getHotelById(id);
	}
	
	@GetMapping("/getHotelByCity/{hotelCity}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Hotel> findByHotelCity(@PathVariable String hotelCity) {
		return service.getHotelByHotelCity(hotelCity);
	}
	
	@DeleteMapping("/delete/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String deleteHotel(@PathVariable int id) {
		return service.deleteHotel(id);
	}
	
	@PutMapping("updateRooms/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Hotel updateRooms(@PathVariable int id) {
		Hotel updateHotel = service.getHotelById(id);
		updateHotel.setHotelRooms(updateHotel.getHotelRooms()-1);
		service.saveHotel(updateHotel);
		return updateHotel;
	}
	
	
	@PutMapping("updateHotel/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Hotel updateHotel(@PathVariable int id, @RequestBody Hotel hotel) {
		Hotel updateHotel = service.getHotelById(id);
		updateHotel.setHotelName(hotel.getHotelName());
		updateHotel.setHotelCity(hotel.getHotelCity());
		updateHotel.setHotelRooms(hotel.getHotelRooms());
		updateHotel.setHotelPrice(hotel.getHotelPrice());
		service.saveHotel(updateHotel);
		return updateHotel;
	}
	
	
}
