package com.example.controller;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Email;
import com.example.service.EmailService;

@RestController
@RequestMapping("/api/email/")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	public ResponseEntity<?> sendEmail(@RequestBody Email email)
	{
		try {
			emailService.saveAndSendEmail(email);
			return ResponseEntity.ok("sent successfully");
		}catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body("An error occured: "+e.getMessage());
		}
	}

}
