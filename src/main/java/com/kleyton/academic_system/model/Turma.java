package com.kleyton.academic_system.model;

import java.io.Serializable;

public class Turma implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id_turma;
	private Integer id_disciplina;
	private String  nomeDisciplina;
	private Integer id_professor;
	private String  nomeProfessor;
	
	
	public Turma(Integer id_turma, Integer id_disciplina, Integer id_professor) {
		this.id_turma = id_turma;
		this.id_disciplina = id_disciplina;
		this.id_professor = id_professor;
	}
	
	public Turma(Integer id_turma, Integer id_disciplina, String nomeDisciplina, Integer id_professor,
			String nomeProfessor) {
		this.id_turma = id_turma;
		this.id_disciplina = id_disciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.id_professor = id_professor;
		this.nomeProfessor = nomeProfessor;
	}

	public Turma() {
		this.id_turma = null;
		this.id_disciplina = null;
		this.id_professor = null;
		this.nomeDisciplina = "";
		this.nomeProfessor = "";
	}

	public Integer getId_turma() {
		return id_turma;
	}

	public void setId_turma(Integer id_turma) {
		this.id_turma = id_turma;
	}

	public Integer getId_disciplina() {
		return id_disciplina;
	}

	public void setId_disciplina(Integer id_disciplina) {
		this.id_disciplina = id_disciplina;
	}

	public Integer getId_professor() {
		return id_professor;
	}

	public void setId_professor(Integer id_professor) {
		this.id_professor = id_professor;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	
	
	
		
}