package com.mq.jms;

import java.io.File;
import java.util.Hashtable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class FechamentoCaixa {

	public static void main(String[] args) {

		String url = "file:/D:/jndi-aula";
		String icf = "com.sun.jndi.fscontext.RefFSContextFactory";
		String pkg = "com.sun.jndi.url";

		InitialContext ctx;

		String cfName = "CAIXA" + File.separator + "CFCliente";
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
			connection.start();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			MessageConsumer mConsumer = session.createConsumer(queue);
			

			TextMessage message= (TextMessage) mConsumer.receiveNoWait();

			while (message != null) {
				System.out.println("Resposta:" + message.getText());
				message = (TextMessage) mConsumer.receiveNoWait();
			};

			System.out.println("Fim de Processamento de Caixa");
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
