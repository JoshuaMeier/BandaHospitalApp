//email implementation
//found on https://www.tutorialspoint.com/java/java_sending_email.htm


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    // Get system properties
    private static Properties properties = new Properties();
    Session session;

    public SendEmail(String host, int port) {
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", Integer.toString(port));

        session = Session.getDefaultInstance(properties);
    }

    public SendEmail() {
        // Setup mail server
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");

        // Sending email with Google's SMTP
        final String user = "letusoftwareengineeringtest@gmail.com";
        final String password = "HamboneandSwoop";

        session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });
    }
    public void send(String sender, String receiver, String errorMessage, String subject) {
      System.out.println("Sending email");
      // Recipient's email ID needs to be mentioned.
      String to = sender;

      // Sender's email ID needs to be mentioned
      String from = receiver;

      // Get the default Session object.
      /*Session session = Session.getDefaultInstance(properties,
      new javax.mail.Authenticator(){
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password);
          }
      });*/

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject(subject);

         // Now set the actual message
         message.setText(errorMessage);

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
    }

}
