package com.example.tademo.interfaces.adapter.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tademo.core.application.entity.Application;
import com.example.tademo.infrastructure.common.rest.Response;
import com.example.tademo.interfaces.converter.ApplicationConverter;
import com.example.tademo.interfaces.dto.ApplicationDto;
import com.example.tademo.usecase.ApplyApplicationUsecase;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/application")
@Api(tags = "SKI demo project", value = "SKI demo project")
@Slf4j
public class ApplicationRestController {
	
	@Autowired
	ApplyApplicationUsecase applyApplicationUsecase;
	
	@PostMapping
	@ApiOperation(value = "Create Application")
    public Response createApplicationInfo(@RequestBody ApplicationDto applicationDto){
		
		Application application = ApplicationConverter.toEntity(applicationDto);
			
		applyApplicationUsecase.createApplicationInfo(application);
        
		return Response.ok();
    }
	
	@PutMapping
    public Response modifyApplicationInfo(@RequestBody ApplicationDto applicationDto){
        
		Application application = ApplicationConverter.toEntity(applicationDto);
		
		applyApplicationUsecase.updateApplicationInfo(application);
        
		return Response.ok();
    }
	
	@PostMapping(value = "/approve")
    public Response approveApplication(@RequestBody ApplicationDto applicationDto){
        
		Application application = ApplicationConverter.toEntity(applicationDto);
		
		applyApplicationUsecase.approveApplicationByRule(application);
        
		return Response.ok();
    }
	
	@PostMapping(value = "/query/applicant/{applicantId}")
    public Response queryApplicationByApplicant(@ApiParam(required = true, value = "Applicatn ID") @PathVariable String applicantId){
		
		List<Application> applicationList = applyApplicationUsecase.queryLeaveInfoByApplicant(applicantId);
        List<ApplicationDto> applicationDtoList = applicationList.stream()
        		.map(application -> ApplicationConverter.toDto(application))
        		.collect(Collectors.toList());
	
        return Response.ok(applicationDtoList);
    }

}
