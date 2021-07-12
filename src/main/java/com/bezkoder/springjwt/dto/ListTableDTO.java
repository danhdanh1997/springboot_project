package com.bezkoder.springjwt.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ListTableDTO {
    private String id;
    private Date bookingTableDate;
    private long numberOfGuest;
    private String moreInfo;
}
