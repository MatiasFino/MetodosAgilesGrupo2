package Email;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailService {
    public static final String SENDER = "metodosagiles2022@gmail.com";
    private static final String PASSWORD = "olxwzwqojutdejoi";
    private String subject = "Si lees esto, el mail funciona y Boca murio el 9 de diciembre de 2018";
    private String recipient = SENDER;
    private String content = "TOMALA VOS, DAMELA A MI, EL QUE NO SALTA, MURIO EN MADRIIID";
    private Properties properties;
    private Session session;
    private MimeMessage message;

    public EmailService() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int notificarAyudante(){
        createEmail();
        sendEmail();
        return 200;
    }
    private void createEmail() {
        properties = new Properties();
        properties.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.setProperty("mail.smtp.user", SENDER);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        session = Session.getDefaultInstance(properties);
        message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(SENDER));
        } catch (MessagingException e) {
            System.out.println("Error, sender value is not valid");
            throw new RuntimeException(e);
        }
        try {
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        } catch (MessagingException e) {
            System.out.println("Error, recipient value is not valid");
            throw new RuntimeException(e);
        }
        try {
            message.setSubject(subject);
        } catch (MessagingException e) {
            System.out.println("Error, Subject value is not valid");
            throw new RuntimeException(e);
        }
        try {
            message.setText(content,"ISO-8859-1","html");
        } catch (MessagingException e) {
            System.out.println("Error, Text value is not valid");
            throw new RuntimeException(e);
        }
        System.out.println("Email Succesfuly created");
    }

    private void sendEmail() {
        try {
            Transport transport = session.getTransport("smtp");
            try {
                transport.connect(SENDER,PASSWORD);
                transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
                transport.close();
            } catch (MessagingException e) {
                System.out.println("Error, Could not connect the transport");
                throw new RuntimeException(e);
            }
        } catch (NoSuchProviderException e) {
            System.out.println("Error, could not get the transport from your session");
            throw new RuntimeException(e);
        }
        System.out.println("Email sent succesfuly");
    }
}
