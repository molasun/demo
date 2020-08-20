package com.example.tademo.interfaces.dto;

import java.util.Date;

import lombok.Data;

@Data
public class InsuredDto {
	
    private String insuredId;
    private String insuredName;
    private Date insuredBirthDate;
    private String insuredGender;
    private String insuredAddress;
    private String insuredPhoneNumber;

}
