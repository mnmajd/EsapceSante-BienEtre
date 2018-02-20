/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utile;

import Entite.Newsletter;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author said hmidi
 */
public class Mail {

    private static final String HOST = "smtp.gmail.com";
    private static final String FROM = "saidhmidi96@gmail.com";
    private static final String LOGIN = "saidhmidi96@gmail.com";
    //private static final String to = "said.hmidi@esprit.tn";
    private static final String PASS = "said1996jj  ";

    public static void sendMail(String recipient, String title, String content) {
        Thread mailThread = new Thread(() -> {
            Transport transport = null;
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", HOST);
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.port", "587");
            Session session = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(LOGIN, PASS);
                }
            });
            MimeMessage message = new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress(FROM));

                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

                message.setSubject(title);

                message.setText(content);

                System.out.println("Tentative de connexion");

                transport = session.getTransport("smtp");
                transport.connect(HOST, LOGIN, PASS);

                System.out.println("Envoi de mail...");

                transport.sendMessage(message, message.getAllRecipients());

                System.out.println("Mail enovyé avecc succés.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        mailThread.start();
    }
    
    public static void sendNewsletter(List<Newsletter> newsletters, String title, String content) {

        List<InternetAddress> addresses = new ArrayList<>();
        for (Newsletter newsletter : newsletters) {
            try {
                addresses.add(new InternetAddress(newsletter.getEmail(), newsletter.getName()));
            } catch (UnsupportedEncodingException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        Thread mailThread = new Thread(() -> {
            Transport transport = null;
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", HOST);
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.sendpartial", "true");
            
            Session session = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(LOGIN, PASS);
                }
            });
            MimeMessage message = new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress(FROM));

                message.addRecipients(Message.RecipientType.TO, addresses.toArray(new InternetAddress[addresses.size()]));

                message.setSubject(title);

                message.setText(content);

                System.out.println("Tentative de connexion");

                transport = session.getTransport("smtp");
                transport.connect(HOST, LOGIN, PASS);

                System.out.println("Envoi de mail...");

                transport.sendMessage(message, message.getAllRecipients());

                System.out.println("Mail enovyé avecc succés.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        mailThread.start();
    }
    
    public  boolean Send(String toAddress,String emailBody) throws UnsupportedEncodingException, MessagingException {
	 	final String password="said1996jj  ";
                final String from = "saidhmidi96@gmail.com";
                
                final String name="E-shop";
                String subject="Changing Password";
                
                Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
		if(Session.getDefaultInstance(props)!=null){
			System.out.println("connected");
		}else{
			System.out.println("not connected");
		}
		
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {                                      
                                        @Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, password);
					}
				  });
                
		
		try {
			Message message = new MimeMessage(session);	 
			message.setFrom(new InternetAddress(from));			
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(toAddress));
			message.setSubject(subject);
			message.setContent(emailBody,"text/html");
			InternetAddress fromAddress=new InternetAddress(from, name);
			message.setFrom(fromAddress);
			Transport.send(message);
			return true;
		} catch (MessagingException c) {
			return false;
		}
		
    
}
}
