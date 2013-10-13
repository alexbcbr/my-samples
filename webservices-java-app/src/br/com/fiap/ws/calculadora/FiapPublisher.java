package br.com.fiap.ws.calculadora;

import javax.xml.ws.Endpoint;

public class FiapPublisher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:9877/calculadora", new CalculadoraServerImpl());
//		Endpoint.publish("http://127.0.0.1:9877/time", new TimeServerImpl());
//		Endpoint.publish("http://127.0.0.1:9877/cd", new CDServerImpl());


	}

}
