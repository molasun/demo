package com.example.tademo.core.application.entity;

import java.util.Date;

import com.example.tademo.core.application.entity.valueobject.Applicant;
import com.example.tademo.core.application.entity.valueobject.Insured;
import com.example.tademo.core.application.entity.valueobject.Status;

import lombok.Data;

@Data
public class Application{
	
	private String id;
	private String applicationId;
	private Applicant applicant;
	private Insured insured;
	private int insuranceAmount;
	private String channel;
	
	private Date statusTime;
	
	private Status status;
	
    public Application create(){
        this.setStatus(Status.APPROVING);
        this.setStatusTime(new Date());
        return this;
    }
    
    public Application modify(){
        this.setStatus(Status.APPROVING);
        this.setStatusTime(new Date());
        return this;
    }
    
    public Application reject(){
        this.setStatus(Status.REJECTED);
        this.setStatusTime(new Date());
        return this;
    }
    
    public Application finish(){
        this.setStatus(Status.APPROVED);
        this.setStatusTime(new Date());
        return this;
    }

}
