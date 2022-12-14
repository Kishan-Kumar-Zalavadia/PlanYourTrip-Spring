package com.project.PlanYourTrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.PlanYourTrip.model.User;

public interface RegistrationRepository extends JpaRepository <User, Integer>{
	public User findByEmailId(String emailId);
	public User findByEmailIdAndPassword(String email, String password);

}
