package com.sap.r3.bapi;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;

public class TesteSAP {

	public static void main(String[] args) {

		//Declarando um objeto do tipo JCO.Client (Conex�o)
		JCO.Client conexao;

		JCO.PoolManager.singleton().addClientPool("poolClient200",
				100,
				"200",
				"BASIS00",
				"fiap2013",
				"EN",
				"192.168.60.17",
				"00");

		conexao = JCO.PoolManager.singleton().getClient("poolClient200");

		//Cria��o de reposit�rio
		JCO.Repository repositorio;
		repositorio = new JCO.Repository("repExemplo", conexao);

		System.out.println("Dados de Conex�o:" + conexao.getAttributes());

		System.out.println("***********************************************");

		//Cria��o de um objeto JCO.Function
		IFunctionTemplate functionTemplate =
				repositorio.getFunctionTemplate("BAPI_BANK_GETDETAIL");
		JCO.Function function = functionTemplate.getFunction();

		JCO.ParameterList parametrosEntrada =
				function.getImportParameterList();
		parametrosEntrada.setValue("BR", "BANKCOUNTRY");
		parametrosEntrada.setValue("123947598", "BANKKEY");

		//Executando uma fun��o
		conexao.execute(function);

		//Obtendo resultado da execu��o por meio da tabela TAB_PAIS
		JCO.ParameterList parametrosSaida = function.getExportParameterList();
		
		JCO.Structure estruturaSaida = parametrosSaida.getStructure("BANK_ADDRESS");

		System.out.println("Endere�o do Banco Informado: " + estruturaSaida.getField("STREET").getString());
		
		//Libera��o de conex�o com o SAP
		JCO.PoolManager.singleton().releaseClient(conexao);

	}
}
