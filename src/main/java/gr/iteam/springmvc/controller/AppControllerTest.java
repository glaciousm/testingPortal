package gr.iteam.springmvc.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import gr.iteam.springmvc.model.User;
import gr.iteam.springmvc.model.UserProfile;
import gr.iteam.springmvc.model.UserProfileType;
import gr.iteam.springmvc.service.UserService;

public class AppControllerTest {
	
	@Mock
	UserService userService;
	
	@InjectMocks
	AppController appController;
	
	@Spy
	List<User> users = new ArrayList<>();
	
	@Spy
	ModelMap model;
	
	@Mock
	BindingResult result;
	
	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		users = getUserList();
		appController.control = true;
	}
	
	@Test
	public void listUsers(){
		when(userService.findAllUsers()).thenReturn(users);
		Assert.assertEquals(appController.listUsers(model), "userslist");
		Assert.assertEquals(model.get("users"), users);
		Assert.assertEquals(model.get("loggedinuser").toString().toLowerCase(), "admin");
	}
	
	@Test
	public void newUser(){
		Assert.assertEquals(appController.newUser(model), "registration");
		Assert.assertNotNull(model.get("user"));
		Assert.assertFalse((Boolean)model.get("edit"));
		Assert.assertEquals(((User) model.get("user")).getId(), 0);
	}
	
	@Test
	public void saveUserWithValidationError(){
		when(result.hasErrors()).thenReturn(true);
		doNothing().when(userService).saveUser(any(User.class));
		Assert.assertEquals(appController.saveUser(getUserList().get(0), result, model), "registration");
	}
	
	@Test
	public void saveUserWithValidationErrorNonUniqueSSN(){
		when(result.hasErrors()).thenReturn(true);
		when(userService.isUserSSOUnique(anyInt(), anyString())).thenReturn(false);
		Assert.assertEquals(appController.saveUser(getUserList().get(0), result, model), "registration");
	}
	
	@Test
	public void saveUserWithSuccess(){
		when(result.hasErrors()).thenReturn(false);
		when(userService.isUserSSOUnique(anyInt(), anyString())).thenReturn(true);
		doNothing().when(userService).saveUser(any(User.class));
		Assert.assertEquals(appController.saveUser(getUserList().get(0), result, model), "registrationsuccess");
		Assert.assertEquals(model.get("success"), "User user1 last1 registered successfully");
	}
	
	@Test
	public void editUser(){
		User user = users.get(0);
		when(userService.findBySSO(anyString())).thenReturn(user);
		Assert.assertEquals(appController.editUser(anyString(), model), "registration");
		Assert.assertNotNull(model.get("user"));
		Assert.assertTrue((boolean) model.get("edit"));
		Assert.assertEquals(((User)model.get("user")).getId(), 1001);
	}
	
	@Test
    public void updateUserWithValidationError(){
        when(result.hasErrors()).thenReturn(true);
        doNothing().when(userService).updateUser(any(User.class));
        Assert.assertEquals(appController.updateUser(users.get(0), result, model,""), "registration");
    }
	
	@Test
    public void updateUserWithValidationErrorNonUniqueSSN(){
        when(result.hasErrors()).thenReturn(true);
        when(userService.isUserSSOUnique(anyInt(), anyString())).thenReturn(false);
        Assert.assertEquals(appController.updateUser(users.get(0), result, model,""), "registration");
    }
	
	 @Test
	    public void updateUserWithSuccess(){
	        when(result.hasErrors()).thenReturn(false);
	        when(userService.isUserSSOUnique(anyInt(), anyString())).thenReturn(true);
	        doNothing().when(userService).updateUser(any(User.class));
	        Assert.assertEquals(appController.updateUser(users.get(0), result, model, ""), "registrationsuccess");
	        Assert.assertEquals(model.get("success"), "User user1 last1 updated successfully");
	    }
	 
	 @Test
	    public void deleteUser(){
	        doNothing().when(userService).deleteUserBySSO(anyString());
	        Assert.assertEquals(appController.deleteUser("123"), "redirect:/list");
	    }
	
	public List<User> getUserList(){
		User u1 = new User();
		User u2 = new User();
		
		UserProfile profile1 = new UserProfile();
		UserProfile profile2 = new UserProfile();
		
		Set<UserProfile> profileSet = new HashSet<>();
		
		profile1.setType(UserProfileType.ADMIN.getUserProfileType());
		profile2.setType(UserProfileType.USER.getUserProfileType());
		
		u1.setId(1001);
		u2.setId(1002);
		
		u1.setPassword("12345");
		u2.setPassword("12345");
		
		u1.setSsoId("unit1");
		u2.setSsoId("unit2");
		
		u1.setFirstName("user1");
		u2.setFirstName("user2");
		
		u1.setLastName("last1");
		u2.setLastName("last2");
		
		u1.setEmail("user1.last1@iteam.gr");
		u2.setEmail("user2.last2@iteam.gr");
		
		profileSet.add(profile1);		
		u1.setUserProfiles(profileSet);
		users.add(u1);
		
		profileSet.clear();
		
		profileSet.add(profile2);
		u2.setUserProfiles(profileSet);
		users.add(u2);
		
		profileSet.clear();
		
		return users;
	}

}
