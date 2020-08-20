package com.example.tademo.core.application.entity.valueobject;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {
	
    private String applicantId;
    private String applicantName;
    private Date applicantBirthDate;
    private String applicantGender;
    private String applicantAddress;
    private String applicantPhoneNumber;

}
