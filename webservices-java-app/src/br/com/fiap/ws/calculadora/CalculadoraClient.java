package br.com.fiap.ws.calculadora;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;


public class CalculadoraClient {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		URL url = new URL("http://localhost:9877/calculadora?wsdl");
		long x =4 , y=2;
		QName qname = new QName("http://calculadora.ws.fiap.com.br/", "CalculadoraServerImplService");

		Service service = Service.create(url, qname);
		CalculadoraServer eif = service.getPort(CalculadoraServer.class);
		
		System.out.println("Teste soma de "+x+" + "+y+" = " +eif.soma(x, y));
		System.out.println("Teste subtracao de "+x+" - "+y+" = " +eif.subtrai(x, y));
		System.out.println("Teste multiplicacao de "+x+" * "+y+" = " +eif.multiplica(x, y));
		System.out.println("Teste divisao de "+x+" / "+y+" = " +eif.divide(x, y));
		
		
	}

}
