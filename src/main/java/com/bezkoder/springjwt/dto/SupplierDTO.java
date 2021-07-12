package com.bezkoder.springjwt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierDTO {
    private Long id;
    private String supplierName;
    private String address;
    private String phone;
}
