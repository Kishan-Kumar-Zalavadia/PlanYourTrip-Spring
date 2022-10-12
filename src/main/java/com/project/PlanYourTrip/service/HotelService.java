package com.project.PlanYourTrip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.PlanYourTrip.model.Hotel;
import com.project.PlanYourTrip.repository.HotelRepository;


@Service
public class HotelService {
	@Autowired
	private HotelRepository repository;
	
	public Hotel saveHotel(Hotel hotel) {
		return repository.save(hotel);
	}
	
	public List<Hotel> getHotels(){
		return  repository.findAll();
	}
	
	public Hotel getHotelById(int id) {
		return repository.findById(id).orElse(null);
	}
	public List<Hotel> getHotelByHotelCity(String hotelCity) {
		return repository.findByHotelCity(hotelCity);
	}
	public String deleteHotel(int id) {
		repository.deleteById(id);
		return "deleted " + id;
	}
	
}
