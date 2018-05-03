package br.senai.sp.jandira.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	//*** CRIANDO O ATRIBUTO CONEX�O DE MANEIRA EST�TICA
	private static Connection con;
	// *** CRIANDO O M�TODO EST�TICO
	public static Connection getConexao(){
		con = null;
		
		// *** TRY/CATCH PARA TER CERTEZA DE QUE N�O VAI DAR ERRO NA CONEX�O
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String dbURL = "jdbc:ucanaccess:C://Users/17259229/Documents/clientes.accdb";
			con = DriverManager.getConnection(dbURL);
			
		}catch (Exception erro){
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel conectar ao banco de dados","ERRO", JOptionPane.ERROR_MESSAGE);
			System.out.println(erro.getMessage());
		}
		// ***** QUANDO USADO EM OUTRAS CLASSES SEMPRE RETORNAR� O OBJETO CRIADO
		return con;
	}

	// **** FECHANDO A CONEX�O APOS SER FEITO O ACESSO NO BANCO DE DADOS
	
	public static void fecharConexao(){
		if (con!= null){
			try{
				con.close();
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "O banco j� est� fechado!", "ERRO", JOptionPane.ERROR_MESSAGE);
				System.out.println(e.getMessage());
			}
		}
	}
}
