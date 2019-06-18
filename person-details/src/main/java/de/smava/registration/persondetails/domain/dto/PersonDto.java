package de.smava.registration.persondetails.domain.dto;

import lombok.Data;

@Data
public class PersonDto {

    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private Long userId;

}
