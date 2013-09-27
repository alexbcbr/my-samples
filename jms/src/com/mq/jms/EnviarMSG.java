package com.mq.jms;

import java.io.File;
import java.util.Hashtable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class EnviarMSG {
	
	public void registraCaixa(String transacao) {
		String url = "file:/D:/jndi-aula";
		String icf = "com.sun.jndi.fscontext.RefFSContextFactory";
		String pkg = "com.sun.jndi.url";

		InitialContext ctx;

		String cfName = "CAIXA" + File.separator + "CFCliente1";
		String queueName = "CAIXA" + File.separator + "QPagto";

		Hashtable<String, String> environment = new Hashtable<String, String> () ;
		environment.put(Context.INITIAL_CONTEXT_FACTORY, icf);
		environment.put(Context.URL_PKG_PREFIXES, pkg);
		environment.put(Context.PROVIDER_URL, url);
		
		try {
			ctx = new InitialContext(environment);
			ConnectionFactory cf = (ConnectionFactory)ctx.lookup(cfName);
			Queue queue = (Queue)ctx.lookup(queueName);

			Connection connection = cf.createConnection();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			MessageProducer mProducer = session.createProducer(queue);
			TextMessage message = session.createTextMessage();

			message.setText(transacao);

			mProducer.send(message);
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
