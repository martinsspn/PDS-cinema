package PDSFramework.model;

public class Premio {

	private int idPremio;

	private String descricao;

	private int condicao;

	public int getCondicao() {
		return condicao;
	}

	public Premio() {
		this.condicao = 0;
	}

	public void setCondicao(int condicao) {
		this.condicao = condicao;
	}

	public int getIdPremio() {
		return idPremio;
	}

	public void setIdPremio(int idPremio) {
		this.idPremio = idPremio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
