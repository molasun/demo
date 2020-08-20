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
public class Insured {
	
    private String insuredId;
    private String insuredName;
    private Date insuredBirthDate;
    private String insuredGender;
    private String insuredAddress;
    private String insuredPhoneNumber;

}
