package PDSCinema.model;

public class Filme extends Evento {


	private String sinopse;
	private String classificacaoIndicativa;
	private String genero;
	private String diaDeEstreia;


	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(String classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDiaDeEstreia() {
		return diaDeEstreia;
	}

	public void setDiaDeEstreia(String diaDeEstreia) {
		this.diaDeEstreia = diaDeEstreia;
	}

}
