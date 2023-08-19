package com.jsp.demo.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.jsp.demo.Entity.CustomerEntity;
import com.jsp.demo.Repository.CustomerRepository;
import com.jsp.demo.dto.ResponseStructure;
@Service
public class CustomerService 
{
	@Autowired
private CustomerRepository customerRepository;
	
	public CustomerEntity savecustomer(CustomerEntity customerEntity)
	{
		return customerRepository.save(customerEntity);
	}
	public List<CustomerEntity>getAll()
	{
		return customerRepository.findAll();
	}
	public CustomerEntity getcustomerdataByid(int id)
	{
		return customerRepository.findById(id).orElse(new CustomerEntity (HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.name()));
	}
	public List<CustomerEntity>getCustomerByName(String name)
	{
		return customerRepository.findByName(name);
	}
	
	public List<CustomerEntity>validateCustomer(String name,String email)
	{
		return customerRepository.validateCustomer(name, email);
	}
	public ResponseStructure<CustomerEntity> updateCustomer(CustomerEntity customerEntity)
	{
		ResponseStructure<CustomerEntity>rs=new ResponseStructure();
		rs.setData(customerEntity);
	    rs.setMessage(HttpStatus.ACCEPTED.name());
	    rs.setTimeStamp(LocalDateTime.now());
	    rs.setStatuscode(HttpStatus.ACCEPTED.value());
	    return rs;	
	}
public CustomerEntity  deleteById(CustomerEntity customerEntity)
{
	 customerRepository.delete(customerEntity);
	return customerEntity;
}
	}

