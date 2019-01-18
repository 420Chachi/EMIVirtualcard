package dao;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import model.Customer;
import model.User;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	private static final Logger logger = 			
			LoggerFactory.getLogger(CustomerDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	
	@Override
	public void addCustomer(Customer customer) {
		System.out.println("Adding customer in dao");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//customer - has users,address
		//insert the users,address
		//customer.getUsers().setEnabled(true);	
		session.save(customer);

		
		tx.commit();
		//session.flush();
		session.close();
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.openSession();
		List<Customer> customerList = session.createQuery("from Customer").list();
		
		return customerList;
	}

	@Override
	public Customer getCustomerByemailId(String emailId) {
		
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("hello");
		Customer p = (Customer) session.load(Customer.class, new String(emailId));
		System.out.println(p);
		logger.info("Customer loaded successfully, Customer details=" + p);
		tx.commit();
		session.close();
		return p;
		
//		
//		Session session = sessionFactory.openSession();
//		Query query = session.createQuery("from customer where emailId=?");
//		query.setString(0, emailId);
//		Customer customer  = (Customer)query.uniqueResult();
//		customer.getCustomer();
//		return customer;
	}



	@Override
	public boolean verifyUser(String username, String password) {
		Session session = this.sessionFactory.openSession();
		String query="select email, password from Customer where Email=:username and Password=:password";
		Query q=session.createQuery(query);
		q.setString("username", username);
		q.setString("password", password);
		List<Customer> l = q.list();
		
		if(l.size()==0)
		{
			return false;
		}
		
		session.close();
		
		return true;
	}

}
