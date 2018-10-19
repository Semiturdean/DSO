package com.intproject.DSOtool.repositories;

import com.intproject.DSOtool.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findAllByCompanyname(String s);
}
