package br.com.exemplo.bancoDemo.data;

import br.com.exemplo.bancoDemo.common.AgenciaVO;
import br.com.exemplo.bancoDemo.common.OperacaoVO;

public class OperacoesData {
  public AgenciaVO[] agencia;

  public OperacoesData() {
  	agencia = new AgenciaVO[3];

  	agencia[0] = new AgenciaVO("0001", "S�o Paulo");
  	agencia[0].add(new OperacaoVO("Dep�sito", "Est�vel", 532000.12f));
  	agencia[0].add(new OperacaoVO("Fundo de renda fixa", "Queda", 230000.16f));
  	agencia[0].add(new OperacaoVO("Pagamentos", "Est�vel", 500000.23f));
  	agencia[0].add(new OperacaoVO("Previd�ncia privada", "Crescente", 28000.14f));

  	agencia[1] = new AgenciaVO("0002", "Rio de Janeiro");
  	agencia[1].add(new OperacaoVO("Mercados futuros", "Crescente", 32000.11f));
  	agencia[1].add(new OperacaoVO("Saques", "Crescente", 450000.71f));
  	agencia[1].add(new OperacaoVO("Fundo de renda vari�vel", "Est�vel", 280000.19f));  	

  	agencia[2] = new AgenciaVO("0003", "Florian�polis");
  	agencia[2].add(new OperacaoVO("Dep�sito", "Queda", 700235.59f));
  	agencia[2].add(new OperacaoVO("Titulos de cobran�a", "Est�vel", 4000.11f));
  	agencia[2].add(new OperacaoVO("A��es", "Est�vel", 900521.21f));
  	agencia[2].add(new OperacaoVO("Pagamentos", "Est�vel", 444123.23f));
  	agencia[2].add(new OperacaoVO("Previd�ncia privada", "Crescente", 23200.14f));
  	
  }
}