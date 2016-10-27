package fiap.scj.gerenciamento_filas.to;

import java.util.Date;

public class AtendimentoTO {

	private Integer identificador;
	private String codigoSenha;
	private String nomeCidadao;
	private Date dataInicio;
	private Date dataFim;
	private String servico;
	private String avaliacao;

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getCodigoSenha() {
		return codigoSenha;
	}

	public void setCodigoSenha(String codigoSenha) {
		this.codigoSenha = codigoSenha;
	}

	public String getNomeCidadao() {
		return nomeCidadao;
	}

	public void setNomeCidadao(String nomeCidadao) {
		this.nomeCidadao = nomeCidadao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Override
	public String toString() {
		return "AtendimentoTO [identificador=" + identificador + ", codigoSenha=" + codigoSenha + ", nomeCidadao="
				+ nomeCidadao + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", servico=" + servico
				+ ", avaliacao=" + avaliacao + "]";
	}

}
