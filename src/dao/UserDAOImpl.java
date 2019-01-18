package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User;
@Repository
public class UserDAOImpl implements UserDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		//List<Product> products = session.createQuery("from Product").list();
	 List<User> users=	 session.createCriteria(User.class).list();
	 System.out.println(users);
		session.close();
		return users;
	}

	@Override
	public void deleteUser(String userId) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, userId);
		session.saveOrUpdate(user);
		session.flush();
		session.close();// close the session
	}

	@Override
	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();
	}

	@Override
	public User getUserById(String userId) {
		// Reading the records from the table
				Session session = sessionFactory.openSession();
			
				// if we call get method,Record doesnot exist it will return null
				// if we call load, if the record doesnt exist it will throw exception
				User user = (User) session.get(User.class, userId);
				session.close();
				return user;
	}

}
