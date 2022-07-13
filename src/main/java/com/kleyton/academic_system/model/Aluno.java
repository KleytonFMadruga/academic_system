package com.kleyton.academic_system.model;

import java.io.Serializable;
import java.util.Objects;

public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private Integer matricula;
	private Integer id_curso;
	
	public Aluno(String nome, Integer matricula, Integer id_curso) {
		this.nome = nome;
		this.matricula = matricula;
		this.id_curso = id_curso;
	}
	
	public Aluno() {
		this.nome ="";
		this.matricula = null;
		this.id_curso = null;
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
	
	public Integer getId_curso() {
		return id_curso;
	}

	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
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
