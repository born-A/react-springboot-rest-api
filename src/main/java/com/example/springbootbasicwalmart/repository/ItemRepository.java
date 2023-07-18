package com.example.springbootbasicwalmart.repository;

import com.example.springbootbasicwalmart.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Customer,Long> {
}
