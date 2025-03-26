package com.ndieujou.logement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndieujou.logement.entity.Logement;
import com.ndieujou.logement.services.LogementService;

@RestController
@RequestMapping("logement/")
public class LogementController {
	
	@Autowired
	LogementService logementService;
	
	public ResponseEntity createLogement(@RequestBody Logement logement){
		Logement result = logementService.createLogement(logement);
		if(result != null) {
			return  ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body("");
	}

}
