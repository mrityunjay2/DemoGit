package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Customer;
import net.javaguides.springboot.service.CustomerService;

@RestController
@RequestMapping
public class CustomerController {

	@Autowired
	private CustomerService CustomerService;
	

	public CustomerController(net.javaguides.springboot.service.CustomerService customerService) {
		super();
		CustomerService = customerService;
	}


	// build create Customer REST API
	//http://localhost:9090/customer1
	@PostMapping("/post1")
	public ResponseEntity<Customer> saveCustomer( @RequestBody Customer customer){
		return new ResponseEntity<Customer>(CustomerService.saveCustomer(customer),HttpStatus.CREATED);
	}

	
	// building get all Customer Rest API
	@GetMapping("/get1")
	public List<Customer> getAllCustomers() {
		return CustomerService.getAllCustomer();
	}

	// build get Customer by REST API
	// http://localhost:8080/api/Customers/1(pass any id)
	
	@GetMapping("/get1/{CustomerId}")

	public ResponseEntity<Customer> getCustomerById(@PathVariable("CustomerId") long CustomerCustomerId) {
		return new ResponseEntity<Customer>(CustomerService.getCustomerById(CustomerCustomerId), HttpStatus.OK);
	}

	// build update Customer RESET API
	// http://localhost:8080/put1/customers/1
	
	@PutMapping("/put1/{CustomerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("CustomerId") long CustomerId, @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(CustomerService.updateCustomer(customer, CustomerId), HttpStatus.OK);
	}

	// build delete Customer Rest API
	// http://localhost:8080/api/Customers/1
	
	@DeleteMapping("/delete1/{CustomerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("CustomerId") long CustomerId) {
		// delete Customer from DB

		CustomerService.deleteCustomer(CustomerId);

		return new ResponseEntity<String>("Customer deleted successfully!....", HttpStatus.OK);
	}

}
