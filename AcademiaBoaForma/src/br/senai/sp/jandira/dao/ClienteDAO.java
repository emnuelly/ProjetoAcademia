package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.cliente.Cliente;
import br.senai.sp.jandira.jdbc.Conexao;

public class ClienteDAO {

	private Cliente cliente;
	private ResultSet resultado;
	private PreparedStatement stm;
	
	public void setCliente (Cliente cliente){
		this.cliente = cliente;
	}
	
	public ResultSet getContatos(){
		String consulta = "SELECT * FROM clientes ORDER by nome ASC";
		resultado = null;
		stm = null;
		
		try{
			stm = Conexao.getConexao().prepareStatement(consulta);
			resultado = stm.executeQuery();
			Conexao.fecharConexao();
		}catch (Exception erro){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro na consulta", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		return resultado;
		
	}
	
	public Cliente getCLiente(int id){
		Cliente cliente = new Cliente();
		
		String consulta = "SELECT * FROM clientes WHERE id = ?";
		resultado = null;
		stm = null;
		
		try{
			stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setInt(1, id );
			resultado = stm.executeQuery();
			
			resultado.next();
			cliente.setId(resultado.getInt("id"));  // pega o resultado da celula id
			cliente.setNome(resultado.getString("nome"));
			cliente.setDtNasc(resultado.getString("dtNasc"));
			cliente.setEmail(resultado.getString("email"));
			cliente.setTelefone(resultado.getString("telefone"));
			cliente.setCelular(resultado.getString("celular"));
			cliente.setSexo(resultado.getString("sexo"));
			
			
			Conexao.fecharConexao();
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro com a consulta" , "ERRO" , JOptionPane.ERROR_MESSAGE);
		}
		return cliente;
	}
}
