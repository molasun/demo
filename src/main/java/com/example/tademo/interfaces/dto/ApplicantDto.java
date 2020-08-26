package com.example.tademo.interfaces.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Applicant Data")
public class ApplicantDto {
	
	@NotEmpty(message = "please provide applicant id")
	@ApiModelProperty(value = "applicant id")
    private String applicantId;
	@NotEmpty(message = "please provide applicant name")
	@ApiModelProperty(value = "applicant name")
    private String applicantName;
	@ApiModelProperty(value = "applicant birthdate")
    private Date applicantBirthDate;
	@ApiModelProperty(value = "applicant gender")
    private String applicantGender;
	@ApiModelProperty(value = "applicant address")
    private String applicantAddress;
	@ApiModelProperty(value = "applicant phone number")
    private String applicantPhoneNumber;

}
