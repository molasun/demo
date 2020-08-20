package com.example.tademo.core.application.repository.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tademo.core.application.repository.po.ApplicationPo;

@Repository
public interface ApplicationDao extends JpaRepository<ApplicationPo, String>{
	
    List<ApplicationPo> queryByApplicantId(String applicantId);

}
