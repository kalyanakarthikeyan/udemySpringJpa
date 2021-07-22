package com.kalyan.customerdata.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Customer {
    @Id
    Integer id;
    String name;
    String email;
}
