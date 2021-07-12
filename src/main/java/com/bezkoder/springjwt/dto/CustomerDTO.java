package com.bezkoder.springjwt.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CustomerDTO {
    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
}
