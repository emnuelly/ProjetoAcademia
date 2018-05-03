package br.senai.sp.jandira.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	//*** CRIANDO O ATRIBUTO CONEXÃO DE MANEIRA ESTÁTICA
	private static Connection con;
	// *** CRIANDO O MÉTODO ESTÁTICO
	public static Connection getConexao(){
		con = null;
		
		// *** TRY/CATCH PARA TER CERTEZA DE QUE NÃO VAI DAR ERRO NA CONEXÃO
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String dbURL = "jdbc:ucanaccess:C://Users/17259229/Documents/clientes.accdb";
			con = DriverManager.getConnection(dbURL);
			
		}catch (Exception erro){
			JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados","ERRO", JOptionPane.ERROR_MESSAGE);
			System.out.println(erro.getMessage());
		}
		// ***** QUANDO USADO EM OUTRAS CLASSES SEMPRE RETORNARÁ O OBJETO CRIADO
		return con;
	}

	// **** FECHANDO A CONEXÃO APOS SER FEITO O ACESSO NO BANCO DE DADOS
	
	public static void fecharConexao(){
		if (con!= null){
			try{
				con.close();
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "O banco já está fechado!", "ERRO", JOptionPane.ERROR_MESSAGE);
				System.out.println(e.getMessage());
			}
		}
	}
}
