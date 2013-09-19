package com.sap.r3.bapi;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.IRepository;
import com.sap.mw.jco.JCO;

public class RecebeSAPListaPaisesDirectConnection {
	
	public static void main(String[] args) {
		
		String SID = "P01";
		IRepository repository;

		
		JCO.Client conexao = JCO.createClient("200", "BASIS00", "fiap2013", "EN", "192.168.60.17", SID); //Pode ser passado o SYSID ou SYSNR (00)
		
		conexao.connect();
		
		repository = JCO.createRepository("AppExample", conexao);
		
		IFunctionTemplate ftemplate = repository.getFunctionTemplate("YTESTE_JAVA");
		JCO.Function function = ftemplate.getFunction();
		
		System.out.println("Atributos da Função: \n" + conexao.getAttributes());
		
		JCO.ParameterList input = function.getImportParameterList();
		input.setValue("AF", "LAND1" );
		input.setValue("BR", "LAND2" );
		conexao.execute(function);
		
		JCO.Table tabPais = function.getTableParameterList().getTable("TAB_PAIS");

		if (tabPais.getNumRows() > 0) {
			do {
				   JCO.Field campoDescricaoPais = tabPais.getField("LKVRZ");
				   System.out.println(campoDescricaoPais.getString());
			} while(tabPais.nextRow());
		}
		
		conexao.disconnect();
		
	}
}
