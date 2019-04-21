package com.dbwatcher.dbwatcherapi.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbwatcher.dbwatcherapi.domain.Admin;
import com.dbwatcher.dbwatcherapi.repository.AdminRepository;
import com.dbwatcher.dbwatcherapi.service.dto.QueryParamDTO;

@Service
public class DBWatcherAPIService {
	
    private final AdminRepository adminRepository;
	
	public DBWatcherAPIService(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	@Transactional(readOnly = true)
	public ByteArrayResource 
	getResultList(QueryParamDTO params) throws UnsupportedEncodingException {
		List<Admin>  admins = adminRepository.findFirstThree();
		StringBuilder sb = new StringBuilder();
		admins.forEach(a -> sb.append(a.toString()));
		
		return new ByteArrayResource(sb.toString().getBytes());
	}
}
