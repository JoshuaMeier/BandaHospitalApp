//email implementation
//found on https://www.tutorialspoint.com/java/java_sending_email.htm


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    // Get system properties
    private static Properties properties = new Properties();
    static Session session;
    static Config config = new Config();

    public static void send(String errorMessage, String subject) {

        // Setup mail server
        properties.put("mail.smtp.host", config.getProperty("smtpHost"));
        properties.put("mail.smtp.socketFactory.port", config.getProperty("smtpPort"));
        properties.put("mail.smtp.port", config.getProperty("smtpPort"));

        if(config.getProperty("SSL").equals("enabled"))
            properties.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
        if(config.getProperty("auth").equals("true")) {
            properties.put("mail.smtp.auth", "true");

            // Sending email with Google's SMTP
            final String user = "letusoftwareengineeringtest@gmail.com";
            final String password = "HamboneandSwoop";

            session = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(user, password);
                        }
                    });
        }


      System.out.println("Sending email");
      // Recipient's email ID needs to be mentioned.
      String to = config.getProperty("Sender");

      // Sender's email ID needs to be mentioned
      String from = config.getProperty("Receiver");

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

    public static void send(String sender, String receiver, String errorMessage, String subject, String host, int port) {

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", Integer.toString(port));

        session = Session.getInstance(properties);

        System.out.println("Sending test email");
        // Recipient's email ID needs to be mentioned.
        String to = sender;

        // Sender's email ID needs to be mentioned
        String from = receiver;

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
