package com.kalyan.customerdata;

import com.kalyan.customerdata.entities.Customer;
import com.kalyan.customerdata.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CustomerdataApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testSave(){
		Customer customer = new Customer();
		customer.setName("test");
		customer.setEmail("test@test.com");

		customerRepository.save(customer);
	}

	@Test
	public void testFetch(){
		Optional<Customer> customerOptional = customerRepository.findById(1);
		Customer customer=null;
		if(customerOptional.isPresent()){
			customer = customerOptional.get();
			assertEquals("test", customer.getName());
		}

	}

	@Test
	public void testUpdate(){
		Optional<Customer> customerOptional = customerRepository.findById(1);
		Customer customer=null;
		if(customerOptional.isPresent()){
			customer = customerOptional.get();
			customer.setEmail("testing@test.com");
			customerRepository.save(customer);
		}

	}

	@Test
	public void testDelete(){
		if(customerRepository.existsById(1)){
			customerRepository.deleteById(1);
		}

	}

}
