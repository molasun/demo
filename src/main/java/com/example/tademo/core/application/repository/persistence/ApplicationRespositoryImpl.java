package com.example.tademo.core.application.repository.persistence;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.tademo.core.application.repository.ApplicationRepositoryInterface;
import com.example.tademo.core.application.repository.mapper.ApplicationDao;
import com.example.tademo.core.application.repository.po.ApplicationPo;

@Repository
public class ApplicationRespositoryImpl implements ApplicationRepositoryInterface{

	@Autowired
	ApplicationDao applicationDao;
	
	Logger logger = LoggerFactory.getLogger(ApplicationRespositoryImpl.class);
	
	@Override
	public void save(ApplicationPo applicationPo) {
		
		applicationDao.save(applicationPo);		
	}

	@Override
	public ApplicationPo findById(String id) {

		return applicationDao.findById(id)
                .orElseThrow(() -> new RuntimeException("application not found"));
	}

	@Override
	public List<ApplicationPo> queryByApplicantId(String applicantId) {
		
		List<ApplicationPo> applicationPoList = applicationDao.queryByApplicantId(applicantId);
	
		return applicationPoList;
	}

}
