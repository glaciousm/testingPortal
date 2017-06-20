package gr.iteam.springmvc.service;

import java.util.List;

import gr.iteam.springmvc.model.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
