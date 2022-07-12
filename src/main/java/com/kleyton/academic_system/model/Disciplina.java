package com.kleyton.academic_system.model;

import java.util.HashMap;
import java.util.Map;

public class Disciplina {
	
	private int codigoUltimaTurma;
	private String nome, codigo;
	private Curso curso;
	private Map<Integer, Turma> turmas;
	
	public Disciplina(String nome, String codigo, Curso curso) {
		this.nome = nome;
		this.codigo = codigo;
		this.curso = curso;
		this.turmas = new HashMap<>();
		this.codigoUltimaTurma = 0;
	}
	
	public Turma criarTurma() {
		Turma turma = new Turma(geraCodigoTurma(), this);
		turmas.put(turma.getCodigo(), turma);
		return turma;
	}
	
	public Turma getTurma(int numero) throws IllegalArgumentException  {
		if(numero <= 0) throw new IllegalArgumentException("código inválido:"+numero);
		if(turmas.get(numero)==null) throw new IllegalArgumentException("Não existe turma com código:"+numero);
		Turma turma = turmas.get(numero);
		return turma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public Curso getCurso() {
		return curso;
	}
	
	private int geraCodigoTurma() {
		return ++codigoUltimaTurma;
	}
	
	public Map<Integer, Turma> getTurmas() {
		
		return turmas;
	}
	

}
