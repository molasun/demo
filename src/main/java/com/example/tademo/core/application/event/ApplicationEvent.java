package com.example.tademo.core.application.event;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.example.tademo.core.application.entity.Application;
import com.example.tademo.infrastructure.common.event.DomainEvent;
import com.example.tademo.infrastructure.util.IdGenerator;

import lombok.Data;

@Data
public class ApplicationEvent extends DomainEvent{
	
	ApplicationEventType applicationEventType;
	
	public static ApplicationEvent create(ApplicationEventType eventType, Application application){
		
		ApplicationEvent event = new ApplicationEvent();
		event.setId(IdGenerator.nextId());
		event.setApplicationEventType(eventType);
		event.setTimestamp(new Date());
		event.setData(JSON.toJSONString(application));
		
		return event;
	}

}
