package gr.iteam.springmvc.dao;

import java.util.List;

import gr.iteam.springmvc.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
