package io.backend.user_verification.email;

import io.backend.user_verification.notifications.Notifications;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements  EmailSender{

    private final static Logger logger = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender mailSender;
    private final Notifications notification;
    private final String dummyEmail = "mobpiper@gmail.com";

    public EmailService(JavaMailSender mailSender, Notifications notification) {
        this.mailSender=mailSender;
        this.notification=notification;
    }

    @Override
    @Async
    public void send(String to, String email){
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMessageHelper.setText(email, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(notification.getCONFIRM_EMAIL_MSG());
            mimeMessageHelper.setFrom(dummyEmail);
            mailSender.send(mimeMessage);
        }catch (MessagingException e){
            logger.error(notification.getFAILED_TO_SEND_EMAIL_MSG(), e);
            throw new IllegalStateException(notification.getFAILED_TO_SEND_EMAIL_MSG());
        }
    }
}
