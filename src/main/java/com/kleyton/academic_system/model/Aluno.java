package com.kleyton.academic_system.model;

import java.io.Serializable;
import java.util.Objects;

public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private Integer matricula;
	
	public Aluno(String nome, Integer matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public Aluno() {
		this.nome ="";
		this.matricula = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	
	

}
