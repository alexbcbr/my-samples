package br.com.fiap.ws.calculadora;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface CalculadoraServer {
	
	@WebMethod long soma(long x, long y);
	@WebMethod long subtrai(long x, long y);
	@WebMethod long divide(long x, long y);
	@WebMethod long multiplica(long x, long y);

}
