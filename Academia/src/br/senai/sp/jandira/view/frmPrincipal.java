package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.jandira.dao.ClienteDAO;
import br.senai.sp.jandira.model.Cliente;

import javax.swing.JButton;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class frmPrincipal extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaClientes;
	private JScrollPane rolagemTabela;
	private JPanel painelTabela;
	private JTable tabela;

	public frmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmPrincipal.class.getResource("/br/senai/sp/jandira/imagens/fitness (2).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 560);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(204, 51, 51));
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(new Color(204, 51, 51));
		painelTitulo.setBounds(5, 5, 472, 73);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblBoaForma = new JLabel("Boa Forma");
		lblBoaForma.setBounds(174, 32, 150, 30);
		painelTitulo.add(lblBoaForma);
		lblBoaForma.setForeground(new Color(255, 255, 255));
		lblBoaForma.setFont(new Font("Mistral", Font.PLAIN, 38));
		
		JLabel lblFitnessa = new JLabel("ACADEMIA");
		lblFitnessa.setIcon(new ImageIcon(frmPrincipal.class.getResource("/br/senai/sp/jandira/imagens/fitness (2).png")));
		lblFitnessa.setBounds(90, 0, 234, 75);
		painelTitulo.add(lblFitnessa);
		lblFitnessa.setForeground(new Color(0, 0, 0));
		lblFitnessa.setFont(new Font("Aharoni", Font.PLAIN, 29));
		
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		
		JLabel lblData = new JLabel("");
		lblData.setBackground(new Color(255, 255, 255));
		lblData.setForeground(new Color(0, 0, 0));
		lblData.setFont(new Font("CordiaUPC", Font.BOLD, 19));
		lblData.setBounds(369, 24, 72, 30);
		Date dataAtual = new Date();
		lblData.setText(data.format(dataAtual));
		painelTitulo.add(lblData);
		
		painelTabela = new JPanel();
		painelTabela.setBackground(new Color(204, 51, 51));
		painelTabela.setBounds(5, 74, 472, 352);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		abrirTabela(); //ABRINDO A TABELA
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(new Color(204, 51, 51));
		painelBotoes.setBounds(5, 437, 472, 84);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnEditar = new JButton("");
		btnEditar.setToolTipText("Editar um cliente.");
		btnEditar.setIcon(new ImageIcon(frmPrincipal.class.getResource("/br/senai/sp/jandira/imagens/edit (1).png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janelaCadastro("EDITAR");
			}
		});
		btnEditar.setBounds(86, 17, 60, 56);
		painelBotoes.add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setToolTipText("Excluir um cliente.");
		btnExcluir.setIcon(new ImageIcon(frmPrincipal.class.getResource("/br/senai/sp/jandira/imagens/remove-user (1).png")));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaCadastro("EXCLUIR");
			}
		});
		btnExcluir.setBounds(156, 17, 62, 56);
		painelBotoes.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(frmPrincipal.class.getResource("/br/senai/sp/jandira/imagens/exit.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","ATENÇÃO", JOptionPane.YES_NO_OPTION);
				
				if(resp == 0){
					dispose();
				}
			}
			
		});
		btnSair.setBounds(381, 17, 62, 56);
		painelBotoes.add(btnSair);
		
		JButton btnNovo = new JButton("");
		btnNovo.setToolTipText("Adicionar um novo cliente.");
		btnNovo.setBounds(16, 17, 60, 56);
		painelBotoes.add(btnNovo);
		btnNovo.setIcon(new ImageIcon(frmPrincipal.class.getResource("/br/senai/sp/jandira/imagens/add-user (1).png")));
		btnNovo.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent arg0) {
				frmDados dados = new frmDados("ADICIONAR");
				dados.setVisible(true);
				
			}
		});
	}
	
	public void abrirTabela(){
		rolagemTabela = new JScrollPane();
		rolagemTabela.setBounds(41, 30, 399, 311);
		painelTabela.add(rolagemTabela);
		
		tabela = new JTable();
		tabela.getTableHeader().setReorderingAllowed(false);
		tabela.setFont(new Font("Arial", Font.PLAIN, 12));
		tabela.setForeground(new Color(0, 0, 0));
		tabela.setBackground(new Color(255, 255, 255));
		DefaultTableModel modeloTabela = new DefaultTableModel(){
			//fazendo com que as colunas não sejam alteradas pelo usuário
			@Override
			public boolean isCellEditable(int linha, int celula){
				return false;
			}
		};
			String[] nomesColunas = {"CPF", "NOME", "CELULAR"};
			modeloTabela.setColumnIdentifiers(nomesColunas);
			
			ClienteDAO clienteDAO = new ClienteDAO();
			ArrayList<Cliente> clientes = new ArrayList<>();
			
			clientes = clienteDAO.getClientes();
			
			Object[] linha = new Object[3];
			for (Cliente cliente : clientes){
				linha[0] = cliente.getCpf();
				linha[1] = cliente.getNome();
				linha[2] = cliente.getCelular();
				
				modeloTabela.addRow(linha);
			}
		tabela.setModel(modeloTabela);
		rolagemTabela.setViewportView(tabela);
	}
	// METODO PARA O EXCLUIR E EDITAR
	public void janelaCadastro(String operacao){
		try{
			int linha;
			linha = tabela.getSelectedRow();
			
			String cpf;
			cpf = (String) tabela.getValueAt(linha, 0);
			
			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = clienteDAO.getCliente(cpf);
			
			int altura;
			int peso;
			
			altura = (int) cliente.getAltura();
			peso = (int) cliente.getPeso();
			
			frmDados dados = new frmDados(operacao);
			dados.setTxtCpf(cliente.getCpf());
			dados.setTxtNome(cliente.getNome());
			dados.setTxtCelular(cliente.getCelular());
			dados.setTxtDtNasc(cliente.getDtNasc());
			dados.setTxtEmail(cliente.getEmail());
			dados.setTxtAltura(String.valueOf(cliente.getAltura()));
			dados.setTxtPeso(String.valueOf(cliente.getPeso()));
			dados.setSexo(cliente.getSexo());
			dados.setComboBox(cliente.getNiveisAtividades());
			dados.setVisible(true);
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null, "Selecione um contato primeiro","Atenção", JOptionPane.WARNING_MESSAGE);
		}
	}
}
