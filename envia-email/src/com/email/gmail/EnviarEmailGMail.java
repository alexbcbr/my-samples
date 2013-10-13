package com.email.gmail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * Enviar email utilizando o servico do GMail
 * 
 */
public class EnviarEmailGMail {

	private String mailSMTPServer;
	private String mailSMTPServerPort;
	private String mailUser;
	private String mailPwd;

	/**
	 * quando instanciar um Objeto, ja sera atribuido o servidor SMTP do GMAIL 
	 * e a porta usada por ele
	 * DEVE SER LIBERADA PORTA 465 DO FIREWALL
	 */
	public EnviarEmailGMail() { 
		mailSMTPServer 	   = "smtp.gmail.com";
		mailSMTPServerPort = "465";
		mailUser 		   = "email-gmail@gmail.com";
		mailPwd 		   = "senha";
	}

	/**
	 * caso queira mudar o servidor e a porta, so enviar para o contrutor
	 * os valor como string
	 */
	EnviarEmailGMail(String mailSMTPServer, String mailSMTPServerPort) { //Para outro Servidor
		this.mailSMTPServer = mailSMTPServer;
		this.mailSMTPServerPort = mailSMTPServerPort;
	}

	public void Mailer(String to, String subject, String message) {
		Properties props = new Properties();

		// quem estiver utilizando um SERVIDOR PROXY descomente essa parte e atribua as propriedades do SERVIDOR PROXY utilizado

		/*
	    props.setProperty("proxySet","true");
	    props.setProperty("socksProxyHost","192.168.155.1"); // IP do Servidor Proxy
	    props.setProperty("socksProxyPort","1080");  // Porta do servidor Proxy
		 */

		props.put("mail.transport.protocol", "smtp"); //define protocolo de envio como SMTP
		props.put("mail.smtp.starttls.enable","true"); 
		props.put("mail.smtp.host", mailSMTPServer); //server SMTP do GMAIL
		props.put("mail.smtp.auth", "true"); //ativa autenticacao
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", mailSMTPServerPort); //porta
		props.put("mail.smtp.socketFactory.port", mailSMTPServerPort); //mesma porta para o socket
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		/**
		 * Session - objeto que ira realizar a conexao com o servidor
		 * Como h� necessidade de autenticacao � criada uma autenticacao que
		 * � responsavel por solicitar e retornar o usu�rio e senha para 
		 * autenticacao
		 */
		Session session = Session.getDefaultInstance(props, null);
		session.setDebug(true); //Habilita o LOG das a��es executadas durante o envio do email

		//Objeto que contem a mensagem
		Message msg = new MimeMessage(session);

		try {
			//Setando o destinat�rio
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			//Setando a origem do email
			msg.setFrom(new InternetAddress(mailUser));
			//Setando o assunto
			msg.setSubject(subject);
			//Setando o conte�do/corpo do email
			msg.setContent(message,"text/html");

		} catch (Exception e) {
			System.out.println(">> Erro: Completar Mensagem");
			e.printStackTrace();
		}

		//Objeto encarregado de enviar os dados para o email
		Transport tr;
		try {
			tr = session.getTransport("smtp"); //define smtp para transporte
			/*
			 *  1 - define o servidor smtp
			 *  2 - seu nome de usuario do gmail
			 *  3 - sua senha do gmail
			 */
			tr.connect(mailUser, mailPwd);
			msg.saveChanges();
			
			//envio da mensagem
			tr.sendMessage(msg, msg.getAllRecipients());
			tr.close();

		} catch (Exception e) {
			System.out.println(">> Erro: Envio Mensagem");
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		EnviarEmailGMail m = new EnviarEmailGMail();
		m.Mailer("emailteste@yahoo.com.br", "Assunto MSG", "<html><b>teste</b>Teste</html>");
	}
}	
