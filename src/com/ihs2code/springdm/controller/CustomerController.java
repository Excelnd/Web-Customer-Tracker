package com.ihs2code.springdm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ihs2code.springdm.dao.CustomerDAO;
import com.ihs2code.springdm.entity.Customer;
import com.ihs2code.springdm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// Inject the Customer Service
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add the customers to the model
		theModel.addAttribute("customers",  theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormAdd")
	public String showFormAdd(Model theModel) {
		return "customer-from";
	}
			
}
