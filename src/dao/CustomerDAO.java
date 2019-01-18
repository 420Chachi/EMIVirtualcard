package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.Customer;
@Repository
public interface CustomerDAO {
	
	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerByemailId(String emailId);

	boolean verifyUser(String username, String password);

}
