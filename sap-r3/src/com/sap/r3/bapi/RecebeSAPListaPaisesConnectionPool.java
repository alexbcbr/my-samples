package com.sap.r3.bapi;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.IRepository;
import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.Client;

public class RecebeSAPListaPaisesConnectionPool {
	
	public static void main(String[] args) {
		
		String SID = "P01";
		IRepository repository;

		JCO.PoolManager.singleton().addClientPool("poolClient200", 1, "200", "BASIS00", "fiap2013", "EN", "192.168.60.17", SID);
		
		Client cliente = JCO.PoolManager.singleton().getClient("poolClient200"); 
		
		repository = JCO.createRepository("AppExample", cliente);
		
		IFunctionTemplate ftemplate = repository.getFunctionTemplate("YTESTE_JAVA");
		JCO.Function function = ftemplate.getFunction();
		
		JCO.ParameterList input = function.getImportParameterList();
		input.setValue("AF", "LAND1" );
		input.setValue("BR", "LAND2" );
		cliente.execute(function);
		
		JCO.Table tabPais = function.getTableParameterList().getTable("TAB_PAIS");

		if (tabPais.getNumRows() > 0) {
			do {
				   JCO.Field campoDescricaoPais = tabPais.getField("LKVRZ");
				   System.out.println(campoDescricaoPais.getString());
			} while(tabPais.nextRow());
		}
		
		JCO.PoolManager.singleton().releaseClient(cliente);
		JCO.PoolManager.singleton().removeClientPool(SID);
	}
}
