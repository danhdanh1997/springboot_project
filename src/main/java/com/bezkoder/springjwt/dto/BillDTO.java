package com.bezkoder.springjwt.dto;

import com.bezkoder.springjwt.models.Customer;
import com.bezkoder.springjwt.models.ListTable;
import com.bezkoder.springjwt.models.Staff;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BillDTO {
    private String id;
    private Date exportDate;
    private ListTable listTable;
    private Customer customer;
    private Staff staff;
}
