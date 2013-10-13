package com.soap.rpc;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;


public class Client {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		URL url = new URL("http://localhost:9876/servico?wsdl");
		QName qname = new QName("http://rpc.soap.com/", "ServicoServerImplService");

		Service service = Service.create(url, qname);
		ServicoServer eif = service.getPort(ServicoServer.class);
		
		System.out.println("Teste: " + eif.produto());
		
		
	}

}
