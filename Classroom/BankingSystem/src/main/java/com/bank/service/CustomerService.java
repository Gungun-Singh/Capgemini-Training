package com.bank.service;

import com.bank.dto.CustomerDto;
import com.bank.entity.Customer;
import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerDto dto);
    Customer getCustomerById(Integer id);
    List<Customer> getAllCustomers();
    void deleteCustomer(Integer id);
}