package com.example.tademo.interfaces.converter;

import com.example.tademo.core.application.entity.valueobject.Applicant;
import com.example.tademo.interfaces.dto.ApplicantDto;

public class ApplicantConverter {
	
	public static ApplicantDto toDto(Applicant applicant) {
		
		ApplicantDto dto = new ApplicantDto();
		
		dto.setApplicantId(applicant.getApplicantId());
		dto.setApplicantName(applicant.getApplicantName());
		dto.setApplicantBirthDate(applicant.getApplicantBirthDate());
		dto.setApplicantGender(applicant.getApplicantGender());
		dto.setApplicantAddress(applicant.getApplicantAddress());
		dto.setApplicantPhoneNumber(applicant.getApplicantPhoneNumber());	
		
		return dto;
	}
	
	public static Applicant toEntity(ApplicantDto dto) {
		
		Applicant applicant = new Applicant();
		
		applicant.setApplicantId(dto.getApplicantId());
		applicant.setApplicantName(dto.getApplicantName());
		applicant.setApplicantBirthDate(dto.getApplicantBirthDate());
		applicant.setApplicantGender(dto.getApplicantGender());
		applicant.setApplicantAddress(dto.getApplicantAddress());
		applicant.setApplicantPhoneNumber(dto.getApplicantPhoneNumber());
				
		return applicant;
	}

}
