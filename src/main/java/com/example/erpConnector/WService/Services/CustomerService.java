package com.example.erpConnector.WService.Services;

import com.example.erpConnector.WService.Entity.Customer;
import com.example.erpConnector.WService.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository ;

    public List<Customer> getCustomers()
    {
        return customerRepository.findAll();
    }

}
