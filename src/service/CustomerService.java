package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Customer;
@Service
public interface CustomerService {


	void addCustomer(Customer customer);



	List<Customer> getAllCustomers();



	Customer getCustomerByemailId(String emailId);



	boolean verifyUser(String username, String password);

}
