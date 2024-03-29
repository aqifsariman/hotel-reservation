package ib2022.paf.hotelreservation.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ib2022.paf.hotelreservation.model.Customer;

@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String findAllSQL = "select * from customer";
    private final String findAllSQLLimitOffset = "select * from customer limit ? offset ?";
    private final String findSQLById = "select * from customer where id = ?";

    public List<Customer> getAllCustomers() {

        final List<Customer> custList = new ArrayList<>();

        final SqlRowSet rs = jdbcTemplate.queryForRowSet(findAllSQL);

        while (rs.next()) {
            Customer cust = new Customer();
            cust.setId(rs.getInt("id"));
            cust.setFirstName(rs.getString("first_name"));
            cust.setLastName(rs.getString("last_name"));
            cust.setDob(rs.getDate("dob"));
            custList.add(cust);
        }
        return Collections.unmodifiableList(custList);
    }

    public List<Customer> getAllCustomersWithLimitOffset(int limit, int offset) {

        final List<Customer> custList = new ArrayList<>();

        // ! Replace placeholder ? with values
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(findAllSQLLimitOffset, limit, offset);

        while (rs.next()) {
            Customer cust = new Customer();
            cust.setId(rs.getInt("id"));
            cust.setFirstName(rs.getString("first_name"));
            cust.setLastName(rs.getString("last_name"));
            cust.setDob(rs.getDate("dob"));
            custList.add(cust);
        }
        return Collections.unmodifiableList(custList);
    }

    public Customer getCustomerById(int id) {
        return jdbcTemplate.queryForObject(findSQLById, BeanPropertyRowMapper.newInstance(Customer.class), id);

    }
}
