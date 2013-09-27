package com.mq.jms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaixaApp {
	public static void main(String[] args) {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		

		try {
			System.out.println("*** Digite um numero do boleto:");
			String boleto = stdin.readLine();
			
			System.out.println("*** Digite um vencimento:");
			String vencimento = stdin.readLine();

			System.out.println("*** Digite um valor:");
			String valor = stdin.readLine();
			
			EnviarMSG e = new EnviarMSG();
			e.registraCaixa(boleto + "|" + vencimento + "|" + valor);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
