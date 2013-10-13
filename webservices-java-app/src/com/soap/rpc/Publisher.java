package com.soap.rpc;

import javax.xml.ws.Endpoint;

public class Publisher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:9876/servico", new ServicoServerImpl());
	}

}
