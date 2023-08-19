package com.jsp.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.demo.Entity.CustomerEntity;
import com.jsp.demo.Service.CustomerService;

@RestController
public class CustomerRestController 
{
	@Autowired
private CustomerService customerService;
	
	@PostMapping(value="/saveCustomer1")
	public @ResponseBody CustomerEntity saveCustomer1(@RequestBody CustomerEntity customerEntity)
	{
	return customerService.savecustomer(customerEntity);
	}
	
	@GetMapping(value="/getAll")
	public @ResponseBody List <CustomerEntity>getAll()
	{
		return customerService.getAll();
	}
	
	@GetMapping(value="/getcustomerdataByid/{id}")
	public @ResponseBody CustomerEntity getcustomerdataByid(@PathVariable("id")int id)
	{
		return customerService.getcustomerdataByid(id);
	}
	
	@GetMapping(value="/getCustomerByName/{name}")
	public @ResponseBody  List<CustomerEntity>getCustomerByName(@PathVariable("name")String name)
	{
		return customerService.getCustomerByName(name);
	}
	
	@PostMapping(value="/validateCustomer")
	public @ResponseBody List<CustomerEntity>validateCustomer(@RequestParam("name") String name,@RequestParam("email")String email)
	{
		return customerService.validateCustomer(name, email);
	}
	
	@GetMapping(value="/deleteById/{id}")
	public CustomerEntity  deleteById(@PathVariable("id")CustomerEntity customerEntity)
	{
		return customerService.deleteById(customerEntity);
	}
	
}
