package com.example.tademo.interfaces.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Insured Data")
public class InsuredDto {
	
	@ApiModelProperty(value = "insured id")
    private String insuredId;
	@ApiModelProperty(value = "insured name")
    private String insuredName;
	@ApiModelProperty(value = "applicant birth date")
    private Date insuredBirthDate;
	@ApiModelProperty(value = "applicant gender")
    private String insuredGender;
	@ApiModelProperty(value = "applicant address")
    private String insuredAddress;
	@ApiModelProperty(value = "applicant phone number")
    private String insuredPhoneNumber;

}
