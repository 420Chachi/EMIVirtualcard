package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.User;
@Repository
public interface UserDAO {

	List<User> getAllUsers();

	void deleteUser(String userId);
	
	void addUser(User user);
	
	User getUserById(String userId);
}
