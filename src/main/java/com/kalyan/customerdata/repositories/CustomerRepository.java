package com.kalyan.customerdata.repositories;

import com.kalyan.customerdata.entities.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Modifying
    @Query("update Customer set email=:email where id=:id")
    public void updateCustomerEmail(@Param("id") int id, @Param("email") String email);
}
