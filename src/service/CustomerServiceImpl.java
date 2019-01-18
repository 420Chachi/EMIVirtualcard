package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomerDAO;
import model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
    @Transactional
	@Override
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	@Override
	public Customer getCustomerByemailId(String emailId) {
		return customerDAO.getCustomerByemailId(emailId);
	}

	@Override
	public boolean verifyUser(String username, String password) {
		// TODO Auto-generated method stub
		return customerDAO.verifyUser(username,password);
	}

}
