package homeproject.webshop.webshop.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final Log log = LogFactory.getLog(this.getClass());

    @Value("${spring.mail.username}")
    private String MESSAGE_FROM;

    private JavaMailSender javaMailSender;

    @Autowired
    public void setEmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String email) {
        SimpleMailMessage message = null;

        try{
            message = new SimpleMailMessage();
            message.setFrom(MESSAGE_FROM);
            message.setTo(email);
            message.setSubject("Subject field of the email");
            message.setText("Text field of the email");
            javaMailSender.send(message);
        }catch (Exception e) {
            log.error("Email sending failed");
        }
    }
}
