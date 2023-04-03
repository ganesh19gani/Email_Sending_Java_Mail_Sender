package com.ojas.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam("toEmail") String toEmail, @RequestParam("subject") String subject, @RequestParam("body") String body) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("adapaganeshofficial@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);
        javaMailSender.send(simpleMailMessage);
        return "Mail Sent successfully";
    }
}
