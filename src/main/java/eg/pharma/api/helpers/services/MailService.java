package eg.pharma.api.helpers.services;

import eg.pharma.api.exception.BusinessException;
import eg.pharma.api.helpers.models.Mail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MailService {

    @Value("${spring.application.name}")
    private String appName;
    @Value("${spring.mail.username}")
    private String senderUsername;

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(@NonNull Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(String.format("%s <%s>", this.appName, this.senderUsername));
        message.setText(mail.getBody());
        message.setSubject(mail.getSubject());
        message.setTo(mail.getTo());
        message.setSentDate(new Date());

        try {
            mailSender.send(message);
        } catch (Exception ex) {
            throw new BusinessException(ex.getMessage());
        }
    }
}
