package com.example.tademo.core.application.repository;

import java.util.List;

import com.example.tademo.core.application.repository.po.ApplicationPo;

public interface ApplicationRepositoryInterface {
	
    void save(ApplicationPo applicationPo);
    
    ApplicationPo findById(String id);

    List<ApplicationPo> queryByApplicantId(String applicantId);
    
   // void saveEvent(ApplicationEventPo applicationEventPo);

}
