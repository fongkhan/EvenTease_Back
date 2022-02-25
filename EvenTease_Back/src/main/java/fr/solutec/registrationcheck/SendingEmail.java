package fr.solutec.registrationcheck;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import fr.solutec.registrationcheck.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SendingEmail {

   

    @ResponseBody
    @RequestMapping("/sign-in")
    public String sendHtmlEmail(String emailDestinataire, JavaMailSender emailSender) throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;
        
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        
        String htmlMsg = "<h3>Voici le code d'identification</h3>"
                +MyConstants.checkCode;
        
        message.setContent(htmlMsg, "text/html");
        
        helper.setTo(emailDestinataire);
        
        helper.setSubject("Test send HTML email");
        
    
        emailSender.send(message);
        
        String msgEnvoi = "Email envoyé à " + emailDestinataire;

        return msgEnvoi;
    }

}

