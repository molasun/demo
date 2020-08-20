package com.example.tademo.interfaces.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ApplicantDto {
	
    private String applicantId;
    private String applicantName;
    private Date applicantBirthDate;
    private String applicantGender;
    private String applicantAddress;
    private String applicantPhoneNumber;

}
