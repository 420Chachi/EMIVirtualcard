package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDAO;
import model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	

	@Transactional
	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
	@Transactional
	@Override
	public void deleteUser(String userId) {
		userDAO.deleteUser(userId);
		
	}

	@Transactional
	@Override
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Override
	public User getUserById(String userId) {
		return userDAO.getUserById(userId);
	}

}
