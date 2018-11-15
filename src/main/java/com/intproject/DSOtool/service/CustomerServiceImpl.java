package com.intproject.DSOtool.service;

import com.intproject.DSOtool.data.Customer;
import com.intproject.DSOtool.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl {

    private final CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createNewCustomer(Customer customer){

        return customerRepository.save(new Customer(
                customer.getCompanyName(),
                customer.getEmailAddress(),
                customer.getPhoneNumber(),
                customer.getContact()));
    }
}
