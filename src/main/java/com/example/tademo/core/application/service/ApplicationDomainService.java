package com.example.tademo.core.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tademo.core.application.entity.Application;
import com.example.tademo.core.application.event.ApplicationEvent;
import com.example.tademo.core.application.event.ApplicationEventType;
import com.example.tademo.core.application.repository.persistence.ApplicationRespositoryImpl;
import com.example.tademo.core.application.repository.po.ApplicationPo;
import com.example.tademo.interfaces.adapter.event.ApplicationEventProducer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApplicationDomainService {
	
	@Autowired
	ApplicationRespositoryImpl applicationRespositoryImpl;
	
	@Autowired
	ApplicationFactory applicationFactory;
	
    @Autowired
    ApplicationEventProducer eventProducer;
    
    Logger logger = LoggerFactory.getLogger(ApplicationDomainService.class);
    
    @Transactional
    public void createApplication(Application application) {
    	
    	application.create();
       	applicationRespositoryImpl.save(applicationFactory.createApplicationPO(application));
    	
        ApplicationEvent event = ApplicationEvent.create(ApplicationEventType.CREATED_EVENT, application);        
 
        eventProducer.publishCreatedEvent(event);
        
    }
    
    @Transactional
    public void updateApplicationInfo(Application application) {

    	// check input
    	applicationInputCheck(application);
    	
    	application.modify();
    	applicationRespositoryImpl.save(applicationFactory.createApplicationPO(application));

    }
    
    @Transactional
    public void rejectApplication(Application application) {
    	
    	// check input
    	applicationInputCheck(application);

    	application.reject();
    	applicationRespositoryImpl.save(applicationFactory.createApplicationPO(application));
    	
    	ApplicationEvent event = ApplicationEvent.create(ApplicationEventType.REJECTED_EVENT, application);
    	
    	eventProducer.publishRejectedEvent(event);

    }
    
    @Transactional
    public void finishApplication(Application application) {
    	
    	// check input
    	applicationInputCheck(application);

    	application.finish();
    	applicationRespositoryImpl.save(applicationFactory.createApplicationPO(application));
    	
    	ApplicationEvent event = ApplicationEvent.create(ApplicationEventType.APPROVED_EVENT, application);
    	 
    	eventProducer.publishApprovedEvent(event);

    }
    
    public Application getApplicationInfo(String applicationId) {
    	
    	ApplicationPo applicationPo = applicationRespositoryImpl.findById(applicationId);
    	
    	return applicationFactory.getApplication(applicationPo);

    }
    
    public List<Application> queryApplicationInfosByApplicant(String applicantId) {
    	
    	List<ApplicationPo> ApplicationPoList = applicationRespositoryImpl.queryByApplicantId(applicantId);
    	
    	return ApplicationPoList.stream()
    			.map(applicationPo -> applicationFactory.getApplication(applicationPo))
    			.collect(Collectors.toList());

    }
    
	public boolean determineApplicationRule(Application application) {
		
		boolean result = false;
		
		int queryAmount = 500000;
		int limitAmount;

		// set limit by channel
		switch(application.getChannel()) {
		case "TaipeiCenter" :
			limitAmount = 1000000;
			break;
		case "TaoyaunAirport" :
			limitAmount = 2000000;
			break;
		default :
			limitAmount = 1000000;
		}
		
		// determine qualification
		if(queryAmount + application.getInsuranceAmount() < limitAmount) {
			result = true;			
		}
		
		return result;
	}
	
	private void applicationInputCheck(Application application) {
		
    	ApplicationPo applicationPo = applicationRespositoryImpl.findById(application.getId());
    	
    	if (applicationPo == null) {
    		throw new RuntimeException("Application does no exist");
    	}
		
	}

}
