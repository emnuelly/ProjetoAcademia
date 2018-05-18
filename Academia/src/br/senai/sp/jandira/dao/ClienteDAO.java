package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.conexao.Conexao;
import br.senai.sp.jandira.model.Cliente;

public class ClienteDAO {

	private Cliente cliente;
	private PreparedStatement stm;
	private ResultSet resultado;
	
	//PEGANDO AS INFORMAÇÕES DOS CLIENTES DO BANCO
	public Cliente getCliente(String cpf){
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		
		cliente = new Cliente();
		//comandos para puxar as informações
		String sql = "SELECT * FROM clientes WHERE cpf = ?";
		//try/catch para localizar o erro se houver algum erro
		try{
			//usando a classe estática com o comando do sql
			stm = Conexao.novaConexao().prepareStatement(sql);
			stm.setString(1, cpf);
			resultado = stm.executeQuery();
			
			resultado.next();
			//pegando as informaçoes de dentro do banco
			cliente.setCpf(resultado.getString("cpf"));
			cliente.setNome(resultado.getString("nome"));
			cliente.setEmail(resultado.getString("email"));
			cliente.setCelular(resultado.getString("celular"));
			cliente.setDtNasc(data.format(resultado.getDate("dtNasc")));
			cliente.setSexo(resultado.getString("sexo"));
			cliente.setAltura(resultado.getDouble("altura"));
			cliente.setPeso(resultado.getDouble("peso"));
			cliente.setNiveisAtividades(resultado.getString("niveisAtividades"));
			
			//fechando a conexão
			stm.close();
		}catch(Exception erro){
			System.out.println(erro.getMessage());
		}
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	//INSERINDO OS DADOS DO BANCO NA TABELA
	
	public ArrayList<Cliente> getClientes(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		String sql = "SELECT * FROM clientes ORDER BY nome";
		stm = null;
		resultado = null;
		
		try{
			stm = Conexao.novaConexao().prepareStatement(sql);
			resultado = stm.executeQuery();
			
			while(resultado.next()){
				cliente = new Cliente();
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setEmail(resultado.getString("email"));
				cliente.setCelular(resultado.getString("celular"));
				cliente.setDtNasc(resultado.getString("dtNasc"));
				cliente.setSexo(resultado.getString("sexo"));
				cliente.setAltura(resultado.getDouble("altura"));
				cliente.setPeso(resultado.getDouble("peso"));
				cliente.setNiveisAtividades(resultado.getString("niveisAtividades"));
				
				clientes.add(cliente);
			}
			Conexao.novaConexao().close();
		}catch(Exception erro){
			System.out.println(erro.getMessage() + " erro no ClienteDAo em getCLientes");
		}
		
		return clientes;
	}
	
	//GRAVANDO UM NOVO CLIENTE NO BANCO DE DADOS
	public void gravar(){
		//COMANDO EM SQL PARA INSERIR AS INFORMAÇÕES
		String sql = "INSERT INTO clientes (cpf, nome, email, celular, dtNasc, sexo, altura, peso, niveisAtividades) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		stm = null;
		
		try {
			stm = Conexao.novaConexao().prepareStatement(sql);
			stm.setString(1, cliente.getCpf());
			stm.setString(2, cliente.getNome());
			stm.setString(3, cliente.getEmail());
			stm.setString(4, cliente.getCelular());
			stm.setString(5, cliente.getDtNasc());
			stm.setString(6, cliente.getSexo());
			stm.setDouble(7, cliente.getAltura());
			stm.setDouble(8, cliente.getPeso());
			stm.setString(9, cliente.getNiveisAtividades());
			stm.execute();
			stm.close();
			
			JOptionPane.showMessageDialog(null, "O cliente foi cadastrado", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro: " + e.getMessage());
		}
		
		
	}
	
	// ATUALIZANDO O CLIENTE NO BANCO DE DADOS
	public void atualizar(String cpf){
		String sql = "UPDATE clientes SET nome = ?, email = ?, celular = ?,"
				+ "dtNasc = ?, sexo = ?, altura = ?, peso = ?, niveisAtividades = ? WHERE cpf = ?";
		stm = null;
		
		try {
			stm = Conexao.novaConexao().prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getEmail());
			stm.setString(3, cliente.getCelular());
			stm.setString(4, cliente.getDtNasc());
			stm.setString(5, cliente.getSexo());
			stm.setDouble(6, cliente.getAltura());
			stm.setDouble(7, cliente.getPeso());
			stm.setString(8, cliente.getNiveisAtividades());
			stm.setString(9, cpf);
			stm.execute();
			stm.close();
			
			JOptionPane.showMessageDialog(null, "Cliente atualizado!");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	//APAGANDO O CLIENTE DO BANCO DE DADOS
	public void excluir(String cpf){
		String sql = "DELETE FROM clientes WHERE cpf = ?";
		stm = null;
		
		try {
			stm = Conexao.novaConexao().prepareStatement(sql);
			stm.setString(1, cpf);
			stm.execute();
			stm.close();
			
			JOptionPane.showMessageDialog(null, "O cliente foi excluído!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
