package com.project.PlanYourTrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.PlanYourTrip.model.Hotel;
import com.project.PlanYourTrip.model.User;
import com.project.PlanYourTrip.service.RegistrationService;

@RestController
public class RegistrationController {
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registerUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User userObj = service.fetchUserByEmailId(tempEmailId);
			if(userObj != null) {
				throw new Exception("user with "+tempEmailId+" is already exist");
			}
		}
		
		User userObj = null; 
		userObj = service.saveUser(user);
		return userObj;
	}

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		User userObj = null;
		if(tempEmailId != null && tempPass != null) {
			userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if(userObj == null)
			throw new Exception("Bad Credentials");
		return userObj;
	}
	
	@GetMapping("/users")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<User> findAllUsers(){
		return service.getUsers();
	}
	
	@GetMapping("/getUserById/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public User findUserById(@PathVariable int id) {
		return service.getUserById(id);
	}
	
	@PutMapping("/update/{id}/{hotelName}")
	@CrossOrigin(origins = "http://localhost:4200")
	public User updateUser(@PathVariable int id, @PathVariable String hotelName) {
		
		User updateUser = service.getUserById(id);
		updateUser.setHotelBooked(hotelName);
		service.saveUser(updateUser);
		return updateUser;
	}
	
	
	@PutMapping("updateUser/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public User updateHotel(@PathVariable int id, @RequestBody User user) {
		User updateUser = service.getUserById(id);
		updateUser.setEmailId(user.getEmailId());
		updateUser.setUserName(user.getUserName());
		updateUser.setPassword(user.getPassword());
		service.saveUser(updateUser);
		return updateUser;
	}
	
}	
