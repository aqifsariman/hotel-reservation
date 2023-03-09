package ib2022.paf.hotelreservation.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer id;

    private String firstName;

    private String lastName;

    private Date dob;
}
