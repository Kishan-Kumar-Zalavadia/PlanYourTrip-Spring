package com.project.PlanYourTrip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.PlanYourTrip.model.Hotel;

public interface HotelRepository extends JpaRepository <Hotel, Integer> {
	List<Hotel> findByHotelCity(String hotelCity);
}
