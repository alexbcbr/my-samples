package com.email.smtp;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Classe para envio de email via SMTP Server
 * @author alexbc
 * 
 */
public class EnviarEmailSTMP {

	/**
	 * Envia email para um SMTP Server
	 *
	 */
	public static void main(String[] argv) {
		
		//* Dados para conexão
		String mailhost = "192.168.124.129";
		String mailer = "JavaMail";

		//* Dados do remetente e destinatário
		String from = "user1@fiapmail.com";
		String to = "user2@fiapmail.com";
		String cc = "user1@fiapmail.com";
		String bcc = "user1@fiapmail.com";	
		
		//* assunto e texto do email
		String assuntoMsg = "Assunto: Teste de Email";		
		String corpoMsg = "Este é um teste de email com Javamail";
		
		try {

			Properties props = System.getProperties();
			props.put("mail.smtp.host", mailhost);

			Session session = Session.getInstance(props, null);

			Message msg = new MimeMessage(session);
			msg.setHeader("X-Mailer", mailer);
			msg.setSentDate(new Date());
			
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(to, false));
			
			if (cc != null)
				msg.setRecipients(Message.RecipientType.CC,
						InternetAddress.parse(cc, false));
			
			if (bcc != null)
				msg.setRecipients(Message.RecipientType.BCC,
						InternetAddress.parse(bcc, false));

			msg.setSubject(assuntoMsg);
			msg.setText(corpoMsg);

			Transport.send(msg);

			System.out.println("\nEmail enviado com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
