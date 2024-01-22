package com.example.mailSender.Service;

import com.example.mailSender.Model.MailResponse;
import com.example.mailSender.Model.MailSender;
import freemarker.template.*;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Configuration configuration;

    public MailResponse SentEmail(MailSender mailSender, Map<String, Object> stringObjectsMap) {
        MailResponse mailResponse=new MailResponse();
        MimeMessage mimeMessage= javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
           mimeMessageHelper.addAttachment("svaaan.png",new ClassPathResource("svaaan.png"));

            Template template=configuration.getTemplate("template.ftl");
            String html= FreeMarkerTemplateUtils.processTemplateIntoString(template,stringObjectsMap);

            mimeMessageHelper.setTo(mailSender.getTo());
            mimeMessageHelper.setText(html, true);
            mimeMessageHelper.setSubject(mailSender.getSubject());
            mimeMessageHelper.setFrom(mailSender.getFrom());
            javaMailSender.send(mimeMessage);
            mailResponse.setMessage("mail send to : " + mailSender.getTo());
            mailResponse.setStatus(Boolean.TRUE);
        } catch (MessagingException | IOException | TemplateException e) {
            mailResponse.setMessage("Mail Sending failure : "+e.getMessage());
            mailResponse.setStatus(Boolean.FALSE);
        }
        return mailResponse;
    }
}
