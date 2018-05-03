package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.jandira.frames.FrmCadCliente;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class frmInicio extends JFrame {

	private JPanel contentPane;
	private JTable tableDados;
	

	
	public frmInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(255, 255, 204));
		panelTitulo.setBounds(0, 0, 434, 50);
		contentPane.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JLabel lblTitulo = new JLabel("ACADEMIA");
		lblTitulo.setIcon(new ImageIcon(frmInicio.class.getResource("/br/senai/sp/jandira/imagens/fitness.png")));
		lblTitulo.setForeground(SystemColor.desktop);
		lblTitulo.setFont(new Font("Aharoni", Font.PLAIN, 24));
		lblTitulo.setBounds(78, 4, 174, 39);
		panelTitulo.add(lblTitulo);
		
		JLabel lblBoaForma = new JLabel("Boa Forma");
		lblBoaForma.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoaForma.setForeground(new Color(250, 128, 114));
		lblBoaForma.setFont(new Font("Segoe Script", Font.PLAIN, 23));
		lblBoaForma.setBounds(173, 22, 135, 28);
		panelTitulo.add(lblBoaForma);
		
		JPanel panelDados = new JPanel();
		panelDados.setForeground(SystemColor.menu);
		panelDados.setBackground(new Color(255, 255, 255));
		panelDados.setBounds(0, 50, 434, 361);
		contentPane.add(panelDados);
		panelDados.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 339);
		panelDados.add(scrollPane);
		
		tableDados = new JTable();
		tableDados.setFont(new Font("Aharoni", Font.PLAIN, 11));
		tableDados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "CELULAR"
			}
		));
		tableDados.getColumnModel().getColumn(1).setPreferredWidth(277);
		tableDados.getColumnModel().getColumn(2).setPreferredWidth(138);
		scrollPane.setViewportView(tableDados);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBackground(new Color(255, 255, 204));
		panelBotoes.setBounds(0, 412, 434, 63);
		contentPane.add(panelBotoes);
		panelBotoes.setLayout(null);
		
		JButton btnAdiciona = new JButton("");
		btnAdiciona.setToolTipText("Adicionar um novo cliente!");
		btnAdiciona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmDados dadosCliente = new frmDados("ADCIONAR");
				dadosCliente.setTitle("Adicionar contato");
				dadosCliente.setVisible(true);
			}
		});
		btnAdiciona.setBounds(27, 8, 59, 50);
		btnAdiciona.setIcon(new ImageIcon(frmInicio.class.getResource("/br/senai/sp/jandira/imagens/user.png")));
		panelBotoes.add(btnAdiciona);
		
		JButton btnSair = new JButton("");
		btnSair.setToolTipText("Sair da aplica\u00E7\u00E3o!");
		btnSair.setIcon(new ImageIcon(frmInicio.class.getResource("/br/senai/sp/jandira/imagens/exit.png")));
		btnSair.setBounds(348, 8, 59, 50);
		panelBotoes.add(btnSair);
		
		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(frmInicio.class.getResource("/br/senai/sp/jandira/imagens/pencil.png")));
		btnEditar.setToolTipText("Editar um cliente!");
		btnEditar.setBounds(96, 8, 59, 50);
		panelBotoes.add(btnEditar);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(frmInicio.class.getResource("/br/senai/sp/jandira/imagens/garbage.png")));
		button.setToolTipText("Excluir um cliente!");
		button.setBounds(164, 8, 59, 50);
		panelBotoes.add(button);
	}
	
	public void criarTabela(){
		
	}
	
	public void adicionarDados(String operacao){
		frmDados frmDados = new frmDados(operacao);
		frmDados.setTitle(operacao + "Contato");

		
	}
}
