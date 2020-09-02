package com.example.tademo.interfaces.converter;

import com.example.tademo.core.application.entity.Application;
import com.example.tademo.interfaces.dto.ApplicationDto;

public class ApplicationConverter {
	
	public static ApplicationDto toDto(Application application) {
		
		ApplicationDto dto = new ApplicationDto();
		dto.setId(application.getId());
		dto.setApplicationId(application.getApplicationId());
		dto.setApplicant(ApplicantConverter.toDto(application.getApplicant()));
		dto.setInsured(InsuredConverter.toDto(application.getInsured()));
		dto.setInsuranceAmount(application.getInsuranceAmount());
		dto.setChannel(application.getChannel());
		dto.setStatusTime(application.getStatusTime());
		dto.setStatus(application.getStatus().toString());
		
		return dto;
	}
	
	public static Application toEntity(ApplicationDto dto) {
		
		Application application = new Application();
		application.setId(dto.getId());
		application.setApplicationId(dto.getApplicationId());
		application.setApplicant(ApplicantConverter.toEntity(dto.getApplicant()));
		application.setInsured(InsuredConverter.toEntity(dto.getInsured()));
		application.setInsuranceAmount(dto.getInsuranceAmount());
		application.setChannel(dto.getChannel());
		
		return application;
	}

}
