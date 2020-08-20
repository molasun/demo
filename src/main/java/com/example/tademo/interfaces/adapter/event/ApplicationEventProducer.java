package com.example.tademo.interfaces.adapter.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.example.tademo.core.application.event.ApplicationEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApplicationEventProducer {
	
    @Autowired
    JmsTemplate jmsTemplate;
	
    public void publishCreatedEvent(ApplicationEvent evnet) {
  
    	jmsTemplate.convertAndSend("application.created", evnet);
    	
    	log.info("====Producer > created Message Sent====");
    }
    
    public void publishRejectedEvent(ApplicationEvent evnet) {
  
    	jmsTemplate.convertAndSend("application.rejected", evnet);
    	
    	log.info("====Producer > rejected Message Sent====");
    }
    
    public void publishApprovedEvent(ApplicationEvent evnet) {
  
    	jmsTemplate.convertAndSend("application.approved", evnet);
    	
    	log.info("====Producer > approved Message Sent====");
    }


}
