package com.kalyan.customerdata;

import com.kalyan.customerdata.entities.Customer;
import com.kalyan.customerdata.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		customer.setId(1);
		customer.setName("test");
		customer.setEmail("test@test.com");

		customerRepository.save(customer);
	}

	@Test
	public void testFetch(){
		Customer customer = customerRepository.findById(1).get();
		assertEquals("test", customer.getName());
	}

	@Test
	public void testUpdate(){
		Customer customer = customerRepository.findById(1).get();
		customer.setEmail("testing@test.com");
		customerRepository.save(customer);
	}

	@Test
	public void testDelete(){
		customerRepository.deleteById(1);
	}

}
