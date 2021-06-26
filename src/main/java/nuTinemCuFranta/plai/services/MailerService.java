package nuTinemCuFranta.plai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailerService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private MailContentBuilder mailContentBuilder;

    public void prepareAndSend(String recipient,String message,String subject,String from){
        MimeMessagePreparator messagePreparator=mimeMessage -> {
            MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(from);
            messageHelper.setTo(recipient);
            messageHelper.setSubject(subject);
            messageHelper.setText(message);
            String content=mailContentBuilder.build(message);
            messageHelper.setText(content,true);
        };

        try {
            emailSender.send(messagePreparator);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
