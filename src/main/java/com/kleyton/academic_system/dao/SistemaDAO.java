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
import com.kleyton.academic_system.model.Professor;
import com.kleyton.academic_system.util.ConexaoBD;

public class SistemaDAO {
  
	public void salvarAluno(Aluno aluno) {
		try {
			Connection conexao = ConexaoBD.getConexao();
			PreparedStatement ps = conexao.prepareCall("INSERT INTO public.alunos(matricula, nome) VALUES (?, ?);");
			ps.setInt(1, aluno.getMatricula());
			ps.setString(2, aluno.getNome());
			ps.execute();
			ConexaoBD.closeConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
}
