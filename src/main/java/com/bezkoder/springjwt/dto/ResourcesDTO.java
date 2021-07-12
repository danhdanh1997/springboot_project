package com.bezkoder.springjwt.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ResourcesDTO {
    private String id;
    private String resourcesName;
    private Date inputDate;
    private int expiryDate;
    private Long inventoryNumber;
    private String unit;
}
