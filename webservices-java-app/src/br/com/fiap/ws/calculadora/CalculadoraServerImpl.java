package br.com.fiap.ws.calculadora;

import javax.jws.WebService;

@WebService(endpointInterface = "br.com.fiap.ws.calculadora.CalculadoraServer")
public class CalculadoraServerImpl implements CalculadoraServer {

	@Override
	public long divide(long x, long y) {
		return (y >=0) ? x/y : 0;
	}

	@Override
	public long multiplica(long x, long y) { 
		return x * y;
	}

	@Override
	public long soma(long x, long y) {
		return x + y;
	}

	@Override
	public long subtrai(long x, long y) {
		return x - y;
	}

}
