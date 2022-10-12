package com.project.PlanYourTrip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String hotelName;
	private String hotelCity;
	private int hotelRooms;
	private int hotelPrice;
	public Hotel() {}
	public Hotel(int id, String hotelName, String hotelCity, int hotelRooms, int hotelPrice) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.hotelCity = hotelCity;
		this.hotelRooms = hotelRooms;
		this.hotelPrice = hotelPrice;
	}
	public int getId() {
		return id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public String getHotelCity() {
		return hotelCity;
	}
	public int getHotelRooms() {
		return hotelRooms;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}
	public void setHotelRooms(int hotelRooms) {
		this.hotelRooms = hotelRooms;
	}
	public int getHotelPrice() {
		return hotelPrice;
	}
	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}
	
}
