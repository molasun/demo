package com.example.tademo.interfaces.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ApplicationDto {
	
	private String id;
	
	private ApplicantDto applicantDto;
	private InsuredDto insuredDto;
	
	private int insuranceAmount;
	private String channel;
	
	private Date applyTime;
	private Date modifyTime;
	private Date rejectTime;
	private Date approvedTime;
	
	private String status;

}
