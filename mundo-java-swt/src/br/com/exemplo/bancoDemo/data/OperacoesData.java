package br.com.exemplo.bancoDemo.data;

import br.com.exemplo.bancoDemo.common.AgenciaVO;
import br.com.exemplo.bancoDemo.common.OperacaoVO;

public class OperacoesData {
  public AgenciaVO[] agencia;

  public OperacoesData() {
  	agencia = new AgenciaVO[3];

  	agencia[0] = new AgenciaVO("0001", "São Paulo");
  	agencia[0].add(new OperacaoVO("Depósito", "Estável", 532000.12f));
  	agencia[0].add(new OperacaoVO("Fundo de renda fixa", "Queda", 230000.16f));
  	agencia[0].add(new OperacaoVO("Pagamentos", "Estável", 500000.23f));
  	agencia[0].add(new OperacaoVO("Previdência privada", "Crescente", 28000.14f));

  	agencia[1] = new AgenciaVO("0002", "Rio de Janeiro");
  	agencia[1].add(new OperacaoVO("Mercados futuros", "Crescente", 32000.11f));
  	agencia[1].add(new OperacaoVO("Saques", "Crescente", 450000.71f));
  	agencia[1].add(new OperacaoVO("Fundo de renda variável", "Estável", 280000.19f));  	

  	agencia[2] = new AgenciaVO("0003", "Florianópolis");
  	agencia[2].add(new OperacaoVO("Depósito", "Queda", 700235.59f));
  	agencia[2].add(new OperacaoVO("Titulos de cobrança", "Estável", 4000.11f));
  	agencia[2].add(new OperacaoVO("Ações", "Estável", 900521.21f));
  	agencia[2].add(new OperacaoVO("Pagamentos", "Estável", 444123.23f));
  	agencia[2].add(new OperacaoVO("Previdência privada", "Crescente", 23200.14f));
  	
  }
}