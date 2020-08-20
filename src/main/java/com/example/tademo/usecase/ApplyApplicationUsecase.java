package com.example.tademo.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tademo.core.application.entity.Application;
import com.example.tademo.core.application.service.ApplicationDomainService;

@Service
public class ApplyApplicationUsecase {
	
	@Autowired
	ApplicationDomainService applicationDomainService;
	
    public void createApplicationInfo(Application application){
    	
        //create application
    	applicationDomainService.createApplication(application);

    }
    
    public void updateApplicationInfo(Application application){
    	
        //create application
    	applicationDomainService.updateApplicationInfo(application);

    }
    
    public void approveApplicationByRule(Application application){
    	
        //approve application
    	boolean resualt = applicationDomainService.determineApplicationRule(application);
    	
    	if(!resualt) {
    		applicationDomainService.rejectApplication(application);
    	}else {
    		applicationDomainService.finishApplication(application);
    	}

    }
    
    public Application getApplicationInfo(String applicationId){
    	
        return applicationDomainService.getApplicationInfo(applicationId);
    }
    
    public List<Application> queryLeaveInfoByApplicant(String applicantId){
    	
        return applicationDomainService.queryApplicationInfosByApplicant(applicantId);
    }


}
