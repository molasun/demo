package com.example.tademo.core.application.entity;

import java.util.Date;

import com.example.tademo.core.application.entity.valueobject.Applicant;
import com.example.tademo.core.application.entity.valueobject.Insured;
import com.example.tademo.core.application.entity.valueobject.Status;

import lombok.Data;

@Data
public class Application{
	
	private String id;
	private Applicant applicant;
	private Insured insured;
	private int insuranceAmount;
	private String channel;
	
	private Date applyTime;
	private Date modifyTime;
	private Date rejectTime;
	private Date approvedTime;
	
	private Status status;
	
    public Application create(){
        this.setStatus(Status.APPROVING);
        this.setApplyTime(new Date());
        return this;
    }
    
    public Application modify(){
        this.setStatus(Status.APPROVING);
        this.setModifyTime(new Date());
        return this;
    }
    
    public Application reject(){
        this.setStatus(Status.REJECTED);
        this.setRejectTime(new Date());
        return this;
    }
    
    public Application finish(){
        this.setStatus(Status.APPROVED);
        this.setApprovedTime(new Date());
        return this;
    }

}
