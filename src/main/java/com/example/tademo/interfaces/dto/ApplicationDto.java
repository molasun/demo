package com.example.tademo.interfaces.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Application Data")
public class ApplicationDto {
	
	@ApiModelProperty(value = "id", required = true)
	private String id;
	
	@NotEmpty(message = "please provide applicant info")
	@ApiModelProperty(value = "applicant")
	private ApplicantDto applicant;
	@NotEmpty(message = "please provide insured info")
	@ApiModelProperty(value = "insured")
	private InsuredDto insured;
	
	@NotNull(message = "please provide insurace amount")
	@ApiModelProperty(value = "insuranceAmount")
	private int insuranceAmount;
	@NotEmpty(message = "please provide channel infor")
	@ApiModelProperty(value = "insured")
	private String channel;
	
	@ApiModelProperty(value = "applyTime")
	private Date applyTime;
	@ApiModelProperty(value = "modifyTime")
	private Date modifyTime;
	@ApiModelProperty(value = "rejectTime")
	private Date rejectTime;
	@ApiModelProperty(value = "approvedTime")
	private Date approvedTime;
	
	@ApiModelProperty(value = "status")
	private String status;

}
