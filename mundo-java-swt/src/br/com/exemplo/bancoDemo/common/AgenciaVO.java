package br.com.exemplo.bancoDemo.common;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Esta classe representa os Trechos de Voo
 */
public class AgenciaVO {
	private String codigo;
	private String nome;
	private List operacoes;
	
	public AgenciaVO(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
		operacoes = new LinkedList();
	}
	
	public boolean add(OperacaoVO servico) {
		boolean added = operacoes.add(servico);
		if (added) servico.setAgencia(this);
		return added;
	}
	
	public List getOperacoes() {
		return Collections.unmodifiableList(operacoes);
	}
	
	 public boolean volumeCritico(OperacaoVO operacao, int column) {
	    boolean critico;
	    critico = operacao.getRentabilidade().equals("Queda") ? true : false;
	    return critico;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}

}