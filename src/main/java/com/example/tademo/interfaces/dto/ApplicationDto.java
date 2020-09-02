package com.example.tademo.interfaces.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Application Data")
public class ApplicationDto {
	
	@ApiModelProperty(value = "id", required = true)
	private String id;
	
	@ApiModelProperty(value = "application id")
	private String applicationId;	
	@ApiModelProperty(value = "applicant")
	private ApplicantDto applicant;
	@ApiModelProperty(value = "insured")
	private InsuredDto insured;
	
	@NotNull(message = "please provide insurace amount")
	@ApiModelProperty(value = "insurance amount")
	private int insuranceAmount;
	@NotBlank(message = "please provide channel info")
	@ApiModelProperty(value = "channel")
	private String channel;
	
	@ApiModelProperty(value = "status time")
	private Date statusTime;
	
	@ApiModelProperty(value = "status")
	private String status;

}
