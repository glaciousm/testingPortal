package gr.iteam.springmvc.service;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import gr.iteam.springmvc.dao.UserDao;
import gr.iteam.springmvc.model.User;
import gr.iteam.springmvc.model.UserProfile;
import gr.iteam.springmvc.model.UserProfileType;

public class UserServiceImplTest {

	@Mock
	UserDao dao;

	@InjectMocks
	UserServiceImpl userService;

	@Spy
	List<User> users = new ArrayList<User>();

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		users = getUserList();
	}

	@Test
	public void findById() {
		User user = users.get(0);
		when(dao.findById(anyInt())).thenReturn(user);
	}

	/*@Test
	public void saveUser() {
		doNothing().when(dao).save(any(User.class));
		userService.saveUser(any(User.class));
		verify(dao, atLeastOnce()).save(any(User.class));
	}*/

	@Test
	public void updateEmployee() {
		User user = users.get(0);
		when(dao.findById(anyInt())).thenReturn(user);
		userService.updateUser(user);
		verify(dao, atLeastOnce()).findById(anyInt());
	}
	
	 @Test
	    public void deleteUserBySsn(){
	        doNothing().when(dao).deleteBySSO(anyString());
	        userService.deleteUserBySSO(anyString());
	        verify(dao, atLeastOnce()).deleteBySSO(anyString());
	    }
	     
	    @Test
	    public void findAllUsers(){
	        when(dao.findAllUsers()).thenReturn(users);
	        Assert.assertEquals(userService.findAllUsers(), users);
	    }
	     
	    @Test
	    public void findUserBySso(){
	    	User user = users.get(0);
	        when(dao.findBySSO(anyString())).thenReturn(user);
	        Assert.assertEquals(userService.findBySSO(anyString()), user);
	    }
	 
	    @Test
	    public void isEmployeeSsnUnique(){
	    	User user = users.get(0);
	        when(dao.findBySSO(anyString())).thenReturn(user);
	        Assert.assertEquals(userService.isUserSSOUnique(user.getId(), user.getSsoId()), true);
	    }

	public List<User> getUserList() {
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
