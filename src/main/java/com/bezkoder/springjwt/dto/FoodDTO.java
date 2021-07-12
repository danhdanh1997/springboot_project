package com.bezkoder.springjwt.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FoodDTO {
    private String id;
    private String foodName;
    private BigDecimal price;
}
