package com.soap.rpc;

import javax.jws.WebService;

@WebService(endpointInterface = "com.soap.rpc.ServicoServer")
public class ServicoServerImpl implements ServicoServer {

	@Override
	public String produto() {
		System.out.println("Invoquei o WebServices");
		return "Calca Jeans";
	}

}
