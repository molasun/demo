package com.example.tademo.infrastructure.common.event;

import java.util.Date;

import lombok.Data;

@Data
public class DomainEvent {
	
    private String id;
    private Date timestamp;
    private String source;
    private String data;

}
