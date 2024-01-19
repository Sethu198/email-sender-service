package com.example.mailSender.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailSender {

    private String name;
    private String reciverName;
    private String to;
    private String from;
    private String subject;
}
