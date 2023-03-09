package ib2022.paf.hotelreservation.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ib2022.paf.hotelreservation.model.Customer;
import ib2022.paf.hotelreservation.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService custSvc;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return custSvc.retrieveAllCustomers();
    }
}
