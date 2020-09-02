package com.example.tademo.core.application.repository.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.example.tademo.core.application.entity.valueobject.Status;

import lombok.Data;

@Entity
@Table(name = "application")
@Data
public class ApplicationPo {

    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String id;
	
    private String applicationId;
    private String applicantId;
    private String applicantName;
    private Date applicantBirthDate;
    private String applicantGender;
    private String applicantAddress;
    private String applicantPhoneNumber;
	
    private String insuredId;
    private String insuredName;
    private Date insuredBirthDate;
    private String insuredGender;
    private String insuredAddress;
    private String insuredPhoneNumber;
	
	private int insuranceAmount;
	private String channel;
	
	private Date statusTime;
	
    @Enumerated(EnumType.STRING)
	private Status status;
	    
    public ApplicationPo toApplication() {
        return new ApplicationPo();
    }

}
