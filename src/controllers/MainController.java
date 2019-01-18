package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



import model.Address;
import model.Bank;
import model.Customer;
import model.EMICard;
import model.User;
import service.CustomerService;


@Controller
@SessionAttributes(value = "sessionuser")
public class MainController
{
	private CustomerService customerService;
	//private UserService userService;


	@Autowired
	public void setCustomerService(CustomerService customerService)
	{
		this.customerService = customerService;
	}

	// Home page
	 @RequestMapping(value = "/", method = RequestMethod.GET)
		public String userHome(Model model) 
		{
			model.addAttribute("customer",new Customer());
			return "index";
			}
	 
	 
	//FOR REGISTRATION AND REGISTRATION FORM
		@RequestMapping(value = "/RegisterSpring", method = RequestMethod.GET)
		public String regSpring(Model model) 
		{
			model.addAttribute("customer",new Customer());
			return "register";
			}
		
		 @RequestMapping(value = "/RegisterFormsSpring", method = RequestMethod.POST)
		    public String validateregistrationPage1(@Valid @ModelAttribute("customer") Customer customer,
		    		BindingResult bindingResult,Model model)
		 {
			 	System.out.println(customer);
			    customerService.addCustomer(customer);
			    return "regSuccess";
		 	}
		 
		 
		// FOR LOGIN AND LOGIN FORM
			@RequestMapping(value = "/Login", method = RequestMethod.GET)
			public String indexes() 
			{
				return "login";
			}
			
			@RequestMapping(value = "/LoginForms", method = RequestMethod.POST)
			public ModelAndView loginpro(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Customer u, BindingResult result, Model model)
			{
				ModelAndView mav = null;
				String username=request.getParameter("email");
				String password=request.getParameter("password");
				System.out.println("Username is: "+ username+ " Password is: "+password);
				if(customerService.verifyUser(username,password))
				{
					mav = new ModelAndView("loginsuccess");   	
				}
				else
				{
					mav = new ModelAndView("loginerror");
				}
				return mav;
				}
			
			
			
		 //Dashboard
		 @RequestMapping(value = "/Dashboard", method = RequestMethod.GET)
			public String userDashboard(Model model) 
			{
				model.addAttribute("customer",new Customer());
				return "dashboard";
				}
	
       //Product
	 @RequestMapping(value = "/Product", method = RequestMethod.GET)
		public String userProduct(Model model) 
		{
			model.addAttribute("customer",new Customer());
			return "product";
			}
	 
	 
	 //ProductDetails
	 @RequestMapping(value = "/Product-Detail", method = RequestMethod.GET)
		public String userProductDetail(Model model) 
		{
			model.addAttribute("customer",new Customer());
			return "product-detail";
			}
	 
	 
	 //Payment
	 @RequestMapping(value = "/Payment", method = RequestMethod.GET)
		public String userPayment(Model model) 
		{
			model.addAttribute("customer",new Customer());
			return "payment";
			}
	 
	 
	 //Successpayment
	 @RequestMapping(value = "/SuccessPayment", method = RequestMethod.GET)
		public String paymentsuccessful(Model model) 
		{
			model.addAttribute("customer",new Customer());
			return "successpayment";
			}
	 
	
	 //Logout
	 @RequestMapping(value = "/Logout", method = RequestMethod.GET)
		public String userLogout(Model model) 
		{
			model.addAttribute("customer",new Customer());
			return "logout";
			}
	
	 
	 //Info
	 @RequestMapping(value = "/Info", method = RequestMethod.GET)
		public String userInfo(Model model) 
		{
			model.addAttribute("customer",new Customer());
			return "info";
			}
	 
	 
	 //carddetails
	 @RequestMapping(value = "/CardDetails", method = RequestMethod.GET)
		public String userCardDetails(Model model) 
		{
			model.addAttribute("customer",new Customer());
			return "carddetails";
			}
	 
	 
	 //adminlogin
	 @RequestMapping(value = "/Admin", method = RequestMethod.GET)
		public String Admin(Model model) 
		{
			model.addAttribute("customer",new Customer());
			return "admin";
			}
	 
	 //adminlogin
	 @RequestMapping(value = "/AdminDashboard", method = RequestMethod.GET)
		public String AdminDashboard(Model model) 
		{
			model.addAttribute("customer",new Customer());
			return "admindashboard";
			}
	 
	 
	 //adminuser
	 @RequestMapping(value = "/AdminUser", method = RequestMethod.GET)
		public String adminUser(Model model) 
		{
			model.addAttribute("customer",new Customer());
			return "adminuser";
			}
	 
	
 //adminproduct
	 @RequestMapping(value = "/AdminProduct", method = RequestMethod.GET)
		public String adminProduct(Model model) 
		{
			model.addAttribute("customer",new Customer());
			return "adminproduct";
			}
	 
	 //contactus
	 @RequestMapping(value = "/Contact", method = RequestMethod.GET)
		public String contactUs(Model model) 
		{
			model.addAttribute("customer",new Customer());
			return "contact";
			}
	 
	
	 
	}
