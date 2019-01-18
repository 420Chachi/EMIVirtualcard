package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.User;
@Service
public interface UserService {	
	
	List<User> getAllUsers();
	void deleteUser(String userId);
	void addUser(User user);
	User getUserById(String userId);

}
