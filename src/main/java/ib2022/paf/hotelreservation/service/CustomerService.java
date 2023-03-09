package ib2022.paf.hotelreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ib2022.paf.hotelreservation.model.Customer;
import ib2022.paf.hotelreservation.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepo;

    public List<Customer> retrieveAllCustomers() {
        return customerRepo.getAllCustomers();
    }

    public List<Customer> retrieveAllCustomersWithLimitOffset(int limit, int offset) {
        return customerRepo.getAllCustomersWithLimitOffset(limit, offset);
    }

    public Customer retrieveCustomerById(int id) {
        return customerRepo.getCustomerById(id);
    }

}
