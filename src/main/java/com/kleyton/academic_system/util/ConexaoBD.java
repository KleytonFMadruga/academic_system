package com.kleyton.academic_system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {
	
	private static Connection conexao;
	private static final String URL_CONEXAO = "jdbc:postgresql://localhost:5432/sistema_academico";
	private static final String USUARIO = "postgres";
	private static final String SENHA = "123";
	
	public static Connection getConexao() {
		if(conexao == null) {
			try {
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
			}catch (SQLException ex) {
				Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
			}catch (ClassNotFoundException ex) {
				Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return conexao;
	}
	
	public static void closeConnection() {
		if(conexao != null) {
			try {
				conexao.close();
				conexao = null;
			} catch (SQLException ex) {
				Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	
}
