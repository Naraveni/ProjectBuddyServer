package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.model.Email;
import com.example.repository.EmailRepository;

import jakarta.annotation.PostConstruct;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender mailSender;

    private final String Em = "banayaswanthreddy@gmail.com";

    @PostConstruct // Runs after bean initialization
    public void init() {
        System.out.println("Initializing EmailService...");
        emailRepository.count(); // Triggers database interaction
        System.out.println("Email table count: " + emailRepository.count());
    }

    public void saveAndSendEmail(Email email) {
        Email e = new Email();
        e.setContactNumber(email.getContactNumber());
        e.setFullName(email.getFullName());
        e.setSubject(email.getSubject());
        e.setMessage(email.getMessage());
        e.setEma(email.getEma());
        emailRepository.save(e); // Save the new object

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(Em);
        mail.setSubject("New message from " + email.getFullName());
        mail.setText("You have received a new message:\n\n " +
                "Name: " + email.getFullName() + "\n" +
                "Email: " + email.getEma() + "\n" +
                "Message: " + email.getMessage() + "\n" +
                "Contact Number: " + email.getContactNumber());

        mailSender.send(mail);
    }
}