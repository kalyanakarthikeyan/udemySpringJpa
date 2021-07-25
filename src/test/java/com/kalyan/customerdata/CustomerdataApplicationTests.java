package com.kalyan.customerdata;

import com.kalyan.customerdata.entities.Customer;
import com.kalyan.customerdata.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.Arrays;
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

	@Test
	@Transactional
	@Rollback(value = false)
	public void testUpdateEmail(){
		customerRepository.updateCustomerEmail(2, "updatedemail@test.com");
	}


	@Test
	public void testCustomerIdInWithPageable(){
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		Pageable pageable = PageRequest.of(0, 2, sort);
		customerRepository.findByIdIn(Arrays.asList(1,2,3,4,5,6,7,8,9,10), pageable).forEach(System.out::println);
	}

	@Test
	public void testCustomerIdInWithPageable1(){
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		Pageable pageable = PageRequest.of(0, 5, sort);
		customerRepository.findByIdIn(Arrays.asList(1,2,3,4,5,6,7,8,9,10), pageable).forEach(System.out::println);
	}

}
