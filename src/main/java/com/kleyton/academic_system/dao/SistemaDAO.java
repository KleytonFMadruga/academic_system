package com.kleyton.academic_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.kleyton.academic_system.model.Aluno;
import com.kleyton.academic_system.model.Curso;
import com.kleyton.academic_system.model.Disciplina;
import com.kleyton.academic_system.model.Professor;
import com.kleyton.academic_system.model.Turma;
import com.kleyton.academic_system.util.ConexaoBD;

public class SistemaDAO {
	
	//SALVAR
  
	public void salvarAluno(Aluno aluno) {
		try {
			Connection conexao = ConexaoBD.getConexao();
			PreparedStatement ps = conexao.prepareCall("INSERT INTO public.alunos(matricula, fk_id_curso, nome) VALUES (?, ?, ?);");
			ps.setInt(1, aluno.getMatricula());
			ps.setInt(2, aluno.getId_curso());
			ps.setString(3, aluno.getNome());
			ps.execute();
			ConexaoBD.closeConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvarProfessor(Professor professor) {
		try {
			Connection conexao = ConexaoBD.getConexao();
			PreparedStatement ps = conexao.prepareCall("INSERT INTO public.professores(siape, nome) VALUES (?, ?);");
			ps.setInt(1, professor.getSiape());
			ps.setString(2, professor.getNome());
			ps.execute();
			ConexaoBD.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvarCurso(Curso curso) {
		try {
			Connection conexao = ConexaoBD.getConexao();
			PreparedStatement ps = conexao.prepareCall("INSERT INTO public.cursos(nome) VALUES (?);");
			ps.setString(1, curso.getNome());
			ps.execute();
			ConexaoBD.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvarDisciplina(Disciplina disciplina) {
		try {
			Connection conexao = ConexaoBD.getConexao();
			PreparedStatement ps = conexao.prepareCall("INSERT INTO public.disciplina(cod_disciplina,nome) VALUES (?,?);");
			ps.setInt(1, disciplina.getCod_disciplina());
			ps.setString(2, disciplina.getNome());
			ps.execute();
			ConexaoBD.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvarTurma(Turma turma) {
		try {
			Connection conexao = ConexaoBD.getConexao();
			PreparedStatement ps = conexao.prepareCall("INSERT INTO public.turma(num_turma,cod_disciplina, siape_professor) VALUES (?,?,?);");
			ps.setInt(1, turma.getId_turma());
			ps.setInt(2, turma.getId_disciplina());
			ps.setInt(3, turma.getId_professor());
			ps.execute();
			ConexaoBD.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void matricularAluno(Aluno aluno, Turma turma) {
		try {
			Connection conexao = ConexaoBD.getConexao();
			PreparedStatement ps = conexao.prepareCall("INSERT INTO public.aluno_turma(matricula_aluno,id_turma, id_disciplina) VALUES (?,?,?);");
			ps.setInt(1, aluno.getMatricula());
			ps.setInt(2, turma.getId_turma());
			ps.setInt(3, turma.getId_disciplina());
			ps.execute();
			ConexaoBD.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluirAluno(Aluno aluno) {
		try {
			Connection conexao = ConexaoBD.getConexao();
	
			PreparedStatement ps = conexao.prepareCall("DELETE FROM public.aluno_turma WHERE matricula_aluno="+aluno.getMatricula()+";");
			PreparedStatement ps2 = conexao.prepareCall("DELETE FROM public.alunos WHERE matricula="+aluno.getMatricula()+";");
			ps.execute();
			ps2.execute();
			ConexaoBD.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//BUSCAR
	
	public List<Aluno> buscarAlunos() {
		try {
			Connection conexao = ConexaoBD.getConexao();
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM alunos;");
			ResultSet resultSet = ps.executeQuery();
			List<Aluno> alunos = new ArrayList<>();
			while(resultSet.next()) {
				Aluno aluno = new Aluno();
				aluno.setMatricula(resultSet.getInt("matricula"));
				aluno.setNome(resultSet.getString("nome"));
				alunos.add(aluno);
			}
			return alunos;
		} catch (SQLException e) {
			Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}
	
	public List<Professor> buscarProfessores() {
		try {
			Connection conexao = ConexaoBD.getConexao();
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM professores;");
			ResultSet resultSet = ps.executeQuery();
			List<Professor> professores = new ArrayList<>();
			while(resultSet.next()) {
				Professor professor = new Professor();
				professor.setSiape(resultSet.getInt("siape"));
				professor.setNome(resultSet.getString("nome"));
				professores.add(professor);
			}
			return professores;
		} catch (SQLException e) {
			Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}
	
	public List<Curso> buscarCursos() {
		try {
			Connection conexao = ConexaoBD.getConexao();
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM cursos;");
			ResultSet resultSet = ps.executeQuery();
			List<Curso> cursos = new ArrayList<>();
			while(resultSet.next()) {
				Curso curso = new Curso();
				curso.setId(resultSet.getInt("id_curso"));
				curso.setNome(resultSet.getString("nome"));
				cursos.add(curso);
			}
			return cursos;
		} catch (SQLException e) {
			Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}
	
	public List<Disciplina> buscarDisciplinas() {
		try {
			Connection conexao = ConexaoBD.getConexao();
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM disciplina;");
			ResultSet resultSet = ps.executeQuery();
			List<Disciplina> disciplinas = new ArrayList<>();
			while(resultSet.next()) {
				Disciplina disciplina = new Disciplina();
				disciplina.setCod_disciplina(resultSet.getInt("cod_disciplina"));
				disciplina.setNome(resultSet.getString("nome"));
				disciplinas.add(disciplina);
			}
			return disciplinas;
		} catch (SQLException e) {
			Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}
	
	public List<Turma> buscarTurmas() {
		try {
			Connection conexao = ConexaoBD.getConexao();
			PreparedStatement ps = conexao.prepareStatement("select  num_turma,turma.cod_disciplina,disciplina.nome,professores.nome as nome_professor from turma inner join disciplina on turma.cod_disciplina = disciplina.cod_disciplina inner join professores on turma.siape_professor = professores.siape;");
			ResultSet resultSet = ps.executeQuery();
			List<Turma> turmas = new ArrayList<>();
			while(resultSet.next()) {
				Turma turma = new Turma();
				turma.setId_turma(resultSet.getInt("num_turma"));
				turma.setId_disciplina(resultSet.getInt("cod_disciplina"));
				turma.setNomeDisciplina(resultSet.getString("nome"));
				turma.setNomeProfessor(resultSet.getString("nome_professor"));
				turmas.add(turma);
			}
			return turmas;
		} catch (SQLException e) {
			Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}
}
