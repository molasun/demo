package com.example.tademo.interfaces.converter;

import com.example.tademo.core.application.entity.valueobject.Insured;
import com.example.tademo.interfaces.dto.InsuredDto;

public class InsuredConverter {
	
	public static InsuredDto toDto(Insured insured) {
		
		InsuredDto dto = new InsuredDto();
		
		dto.setInsuredId(insured.getInsuredId());
		dto.setInsuredName(insured.getInsuredName());
		dto.setInsuredBirthDate(insured.getInsuredBirthDate());
		dto.setInsuredGender(insured.getInsuredGender());
		dto.setInsuredAddress(insured.getInsuredAddress());
		dto.setInsuredPhoneNumber(insured.getInsuredPhoneNumber());
		
		return dto;
	}
	
	public static Insured toEntity(InsuredDto dto) {
		
		Insured insured = new Insured();
		
		insured.setInsuredId(dto.getInsuredId());
		insured.setInsuredName(dto.getInsuredName());
		insured.setInsuredBirthDate(dto.getInsuredBirthDate());
		insured.setInsuredGender(dto.getInsuredGender());
		insured.setInsuredAddress(dto.getInsuredAddress());
		insured.setInsuredPhoneNumber(dto.getInsuredPhoneNumber());		

		return insured;
	}


}
