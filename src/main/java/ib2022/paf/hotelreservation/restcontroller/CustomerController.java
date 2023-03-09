package ib2022.paf.hotelreservation.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        // custSvc is customer service
        return custSvc.retrieveAllCustomers();
    }

    @GetMapping("/limit")
    public List<Customer> getAllCustomersWithLimitOffset(@RequestParam("limit") int limit,
            @RequestParam("offset") int offset) {
        // custSvc is customer service
        return custSvc.retrieveAllCustomersWithLimitOffset(limit, offset);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") int id) {
        return custSvc.retrieveCustomerById(id);
    }
}
