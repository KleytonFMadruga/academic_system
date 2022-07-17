package com.kleyton.academic_system.model;

import java.io.Serializable;
import java.util.Objects;

public class Disciplina implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private Integer cod_disciplina;
	
	
	public Disciplina(String nome, Integer cod_disciplina) {
		this.nome = nome;
		this.cod_disciplina = cod_disciplina;
	}

	public Disciplina() {
		this.nome = "";
		this.cod_disciplina = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCod_disciplina() {
		return cod_disciplina;
	}

	public void setCod_disciplina(Integer cod_disciplina) {
		this.cod_disciplina = cod_disciplina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod_disciplina, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(cod_disciplina, other.cod_disciplina) && Objects.equals(nome, other.nome);
	}



}
