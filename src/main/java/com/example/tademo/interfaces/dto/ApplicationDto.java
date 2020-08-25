package com.example.tademo.interfaces.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Application Data")
public class ApplicationDto {
	
	@ApiModelProperty(value = "id", required = true)
	private String id;
	
	@ApiModelProperty(value = "applicant")
	private ApplicantDto applicant;
	@ApiModelProperty(value = "insured")
	private InsuredDto insured;
	
	@ApiModelProperty(value = "insuranceAmount")
	private int insuranceAmount;
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
