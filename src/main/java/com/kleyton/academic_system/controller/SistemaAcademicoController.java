package com.kleyton.academic_system.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.kleyton.academic_system.dao.SistemaDAO;
import com.kleyton.academic_system.model.Aluno;
import com.kleyton.academic_system.model.Curso;
import com.kleyton.academic_system.model.Professor;


@Named
@ViewScoped
@ManagedBean(name="sistemaAcademicoController")
public class SistemaAcademicoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Aluno aluno;
	private List<Aluno> alunos = new ArrayList<>();
	private Professor professor;
	private List<Professor> professores = new ArrayList<>();
	private Curso curso;
	private List<Curso> cursos = new ArrayList<>();
	private SistemaDAO sisDAO = new SistemaDAO();
	
		
	@PostConstruct
	public void iniciarObjetos() {
		this.aluno = new Aluno();
		this.professor = new Professor();
		this.curso = new Curso();
	}
	
	
	
	
	//CADASTROS
	
	public void matricularAluno() {
		System.out.println("Aluno " + aluno.getNome() + ", de Matrícula: " + aluno.getMatricula() + " Matriculado com sucesso");
		alunos.add(aluno);	
		new SistemaDAO().salvarAluno(aluno);
		aluno = new Aluno();
	}
	
	public void matricularProfessor() {
		
		System.out.println("Professor " + professor.getNome() + ", de Siape: " + professor.getSiape() + " Matriculado com sucesso");
		professores.add(professor);	
		new SistemaDAO().salvarProfessor(professor);
		professor = new Professor();

	}
	
	public void cadastrarCurso() {
		System.out.println("Curso " + curso.getNome() + " Cadastrado com sucesso");
		cursos.add(curso);	
		new SistemaDAO().salvarCurso(curso);
		curso = new Curso();
	}
	
	
		
	//LISTAGENS DAO
	
	public void ListarAlunos() {
		alunos = sisDAO.buscarAlunos();
	}
	
	public void ListarProfessores() {
		professores = sisDAO.buscarProfessores();
	}
	
	public void ListarCursos() {
		cursos = sisDAO.buscarCursos();
	}
	
	
	
	//GETS E SETS LISTAS
	
	public List<Professor> getProfessores() {
		return professores;
	}
	
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	
	//GETS E SETS OBJETOS
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
