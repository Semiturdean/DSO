package com.intproject.DSOtool.service;

import com.intproject.DSOtool.data.Customer;
import com.intproject.DSOtool.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createNewCustomer(Customer customer){

        return customerRepository.save(new Customer(
                customer.getCompanyname(),
                customer.getEmailadress(),
                customer.getPhonenumber(),
                customer.getContact()));
    }
}
