package com.project.PlanYourTrip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.PlanYourTrip.model.Hotel;
import com.project.PlanYourTrip.model.User;
import com.project.PlanYourTrip.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired 
	private RegistrationRepository repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	
	public User fetchUserByEmailIdAndPassword(String email, String password) {
		return repo.findByEmailIdAndPassword(email, password);
	}
	
	public List<User> getUsers(){
		return  repo.findAll();
	}
	public User getUserById(int id) {
		return repo.findById(id).orElse(null);
	}
}
