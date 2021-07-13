package com.bezkoder.springjwt.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StaffDTO {
    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String address;
    private String phone;
    private String image;
    private Date startWorkDay;
}
