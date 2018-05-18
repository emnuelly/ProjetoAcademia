package br.senai.sp.jandira.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	private static Connection con;
	
	public static Connection novaConexao(){
		con = null; 
		
		// *** METODO QUE FAZ O CAMINHO ENTRE O BANCO DE DADOS 
		try { 
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String dbURL ="jdbc:ucanaccess://C:/Users/17259229/Desktop/clientes.accdb";
			con = DriverManager.getConnection(dbURL);			
			System.out.println("BANCO CONECTADO COM SUCESSO");
		}catch (Exception erro){
			JOptionPane.showMessageDialog(null,
					"Nao foi possivel conectar com o banco de dados",
					"ERRO!", JOptionPane.ERROR_MESSAGE);
			System.out.println(erro.getMessage());
		}
		
		return con;
	}
	
	//******* MÉTODO PARA FECHAR O BANCO APÓS SER FEITO O ACESSO.
	public static void fecharConexao (){
		if (con!= null){
			try {
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"O banco ja esta fechado!",
						"ERRO!", JOptionPane.ERROR_MESSAGE);
				System.out.println(e.getMessage());
			}
		}	
	}
}

