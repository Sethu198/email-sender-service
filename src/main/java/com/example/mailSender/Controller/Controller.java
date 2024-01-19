package com.example.mailSender.Controller;

import com.example.mailSender.Model.MailResponse;
import com.example.mailSender.Model.MailSender;
import com.example.mailSender.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private EmailService service;

    @PostMapping("/sendingEmail")
    public MailResponse sendEmail(@RequestBody MailSender mailSender) {
        Map<String, Object> model = new HashMap<>();
        model.put("Name", mailSender.getName());
        model.put("reciverName",mailSender.getReciverName());
        model.put("location", "Chennai,India");
        return service.SentEmail(mailSender,model);
    }
}
