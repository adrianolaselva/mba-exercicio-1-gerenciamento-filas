package fiap.scj.gerenciamento_filas.to;

public class SenhaTO {

	private String codigoSenha;
	private String nomeCidadao;
	private StatusSenhaEnum status;
	
	private SenhaTO() {
		super();
		this.status = StatusSenhaEnum.EM_ESPERA;
	}

	public SenhaTO(String nomeCidadao, String codigoSenha) {
		this();
		this.nomeCidadao = nomeCidadao;
		this.codigoSenha = codigoSenha;
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

	public StatusSenhaEnum getStatus() {
		return status;
	}

	public void setStatus(StatusSenhaEnum status) {
		this.status = status;
	}
	
}
