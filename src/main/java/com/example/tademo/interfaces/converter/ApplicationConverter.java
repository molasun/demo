package com.example.tademo.interfaces.converter;

import com.example.tademo.core.application.entity.Application;
import com.example.tademo.interfaces.dto.ApplicationDto;

public class ApplicationConverter {
	
	public static ApplicationDto toDto(Application application) {
		
		ApplicationDto dto = new ApplicationDto();
		dto.setApplicantDto(ApplicantConverter.toDto(application.getApplicant()));
		dto.setInsuredDto(InsuredConverter.toDto(application.getInsured()));
		dto.setInsuranceAmount(application.getInsuranceAmount());
		dto.setChannel(application.getChannel());
		dto.setApplyTime(application.getApplyTime());
		dto.setModifyTime(application.getModifyTime());
		dto.setRejectTime(application.getRejectTime());
		dto.setApprovedTime(application.getApprovedTime());
		
		return dto;
	}
	
	public static Application toEntity(ApplicationDto dto) {
		
		Application application = new Application();
		application.setApplicant(ApplicantConverter.toEntity(dto.getApplicantDto()));
		application.setInsured(InsuredConverter.toEntity(dto.getInsuredDto()));
		application.setInsuranceAmount(dto.getInsuranceAmount());
		application.setChannel(dto.getChannel());
		
		return application;
	}

}
