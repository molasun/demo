package com.example.tademo.core.application.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.tademo.core.application.entity.Application;
import com.example.tademo.core.application.entity.valueobject.Applicant;
import com.example.tademo.core.application.entity.valueobject.Insured;
import com.example.tademo.core.application.repository.po.ApplicationPo;

@Service
public class ApplicationFactory {
	
	Logger logger = LoggerFactory.getLogger(ApplicationFactory.class);
	
    public ApplicationPo createApplicationPO(Application application) {
    	
    	ApplicationPo applicationPo = new ApplicationPo();
    	
    	applicationPo.setId(UUID.randomUUID().toString());
    	
    	applicationPo.setApplicantId(application.getApplicant().getApplicantId());
    	applicationPo.setApplicantName(application.getApplicant().getApplicantName());
    	applicationPo.setApplicantBirthDate(application.getApplicant().getApplicantBirthDate());
    	applicationPo.setApplicantGender(application.getApplicant().getApplicantGender());
    	applicationPo.setApplicantAddress(application.getApplicant().getApplicantAddress());
    	applicationPo.setApplicantPhoneNumber(application.getApplicant().getApplicantPhoneNumber());
    	
    	logger.info("====done====");
    	
    	applicationPo.setInsuredId(application.getInsured().getInsuredId());
    	applicationPo.setInsuredName(application.getInsured().getInsuredName());
    	applicationPo.setInsuredBirthDate(application.getInsured().getInsuredBirthDate());
    	applicationPo.setInsuredGender(application.getInsured().getInsuredGender());
    	applicationPo.setInsuredAddress(application.getInsured().getInsuredAddress());
    	applicationPo.setInsuredPhoneNumber(application.getInsured().getInsuredPhoneNumber());
    	
    	logger.info("====done====");
    	
    	applicationPo.setInsuranceAmount(application.getInsuranceAmount());
    	applicationPo.setChannel(application.getChannel());

    	logger.info("====done====");
    	
    	applicationPo.setApplyTime(application.getApplyTime());
    	applicationPo.setModifyTime(application.getModifyTime()	);
    	applicationPo.setRejectTime(application.getRejectTime());
    	applicationPo.setApprovedTime(application.getApprovedTime());
    	
    	logger.info("====done====");
    	
    	applicationPo.setStatus(application.getStatus());
    	
    	logger.info("====done====");

        return applicationPo;
    }
    
    public Application getApplication(ApplicationPo applicationPo) {
    	
    	Application application = new Application();
    	
    	Applicant applicant = Applicant.builder()
    			.applicantId(applicationPo.getApplicantId())
    			.applicantName(applicationPo.getApplicantName())
    			.applicantBirthDate(applicationPo.getApplicantBirthDate())
    			.applicantGender(applicationPo.getApplicantGender())
    			.applicantAddress(applicationPo.getApplicantAddress())
    			.applicantPhoneNumber(applicationPo.getApplicantPhoneNumber())
    			.build();    	
    	application.setApplicant(applicant);
    	
    	Insured insured = Insured.builder()
    			.insuredId(applicationPo.getInsuredId())
    			.insuredName(applicationPo.getInsuredName())
    			.insuredBirthDate(applicationPo.getInsuredBirthDate())
    			.insuredGender(applicationPo.getInsuredGender())
    			.insuredAddress(applicationPo.getApplicantAddress())
    			.insuredPhoneNumber(applicationPo.getInsuredPhoneNumber())
    			.build();
    	application.setInsured(insured);
    	
    	application.setInsuranceAmount(applicationPo.getInsuranceAmount());
    	application.setChannel(applicationPo.getChannel());
    	
    	application.setApplyTime(applicationPo.getApplyTime());
    	application.setModifyTime(applicationPo.getModifyTime());
    	application.setRejectTime(applicationPo.getRejectTime());
    	application.setApprovedTime(applicationPo.getApprovedTime());
    	application.setStatus(applicationPo.getStatus());

        return application;
    }

}
