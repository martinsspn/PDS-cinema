package com.PDSCinema.PDSCinemaApplicantion.model;

public class Filme {

	private String name;
	private int duracao;
	private int avaliacoes;
	private int quantAvaliacoes;
	private String sinopse;
	private String classificacaoIndicativa;
	private String genero;
	private String diaDeEstreia;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(int avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public int getQuantAvaliacoes() {
		return quantAvaliacoes;
	}

	public void setQuantAvaliacoes(int quantAvaliacoes) {
		this.quantAvaliacoes = quantAvaliacoes;
	}

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
