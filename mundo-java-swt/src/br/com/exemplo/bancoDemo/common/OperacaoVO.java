package br.com.exemplo.bancoDemo.common;

public class OperacaoVO {
	private AgenciaVO agencia;
	private String operacao;
	private String rentabilidade;
	private float volume;
	
	public OperacaoVO() {
		this(null, null, 0.0f);
	}
	
	public OperacaoVO(String operacao, String rentabilidade, float volume) {
		setOperacao(operacao);
		setRentabilidade(rentabilidade);
		setVolume(volume);
	}
	
	public boolean volumeCritico(int column) {
	  return agencia.volumeCritico(this, column);
	}
	
	public String getOperacao() {
		return operacao;
	}
	
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	
	public String getRentabilidade() {
		return rentabilidade;
	}

	public void setRentabilidade(String rentabilidade) {
		this.rentabilidade = rentabilidade;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public AgenciaVO getAgencia() {
		return agencia;
	}

	public void setAgencia(AgenciaVO agencia) {
		this.agencia = agencia;
	}
}