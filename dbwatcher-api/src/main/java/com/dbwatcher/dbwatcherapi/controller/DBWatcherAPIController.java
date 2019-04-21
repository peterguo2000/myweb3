package com.dbwatcher.dbwatcherapi.controller;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dbwatcher.dbwatcherapi.service.DBWatcherAPIService;
import com.dbwatcher.dbwatcherapi.service.dto.QueryParamDTO;

@RestController
public class DBWatcherAPIController {
	
	@Autowired
	DBWatcherAPIService apiService;

	@PostMapping(path = "/query")
	public ResponseEntity<Resource> 
	query(@RequestBody QueryParamDTO params) throws UnsupportedEncodingException {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=result.csv");
		return ResponseEntity.ok()
				.headers(headers)
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.body(apiService.getResultList(params));
		
	}
	
}
