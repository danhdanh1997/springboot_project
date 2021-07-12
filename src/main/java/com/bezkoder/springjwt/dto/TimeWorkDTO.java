package com.bezkoder.springjwt.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TimeWorkDTO {
    private String id;
    private Date dateOfWork;
    private String categoryShift;
}
