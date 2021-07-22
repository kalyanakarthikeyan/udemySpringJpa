package com.kalyan.customerdata.repositories;

import com.kalyan.customerdata.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
