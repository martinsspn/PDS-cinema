package com.PDSCinema.PDSCinemaApplicantion.model;

import javax.persistence.*;

@Entity
@Table(name = "Filme")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "duracao")
	private int duracao;

	@Column(name = "Avaliacao")
	private int avaliacao;

	@Column(name = "Sinopse")
	private String sinopse;

	@Column(name = "Classificacao indicativa")
	private String classificacaoIndicativa;

	@Column(name = "genero")
	private String genero;

	@Column(name = "Dia de estreia")
	private String diaDeEstreia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
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
