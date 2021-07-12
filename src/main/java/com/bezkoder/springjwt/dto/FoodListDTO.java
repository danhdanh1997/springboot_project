package com.bezkoder.springjwt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodListDTO {
    private Long id;
    private String foodListName;
    private String description;
}
