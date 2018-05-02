package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class frmDados extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtNasc;
	private JTextField txtPeso;
	private JTextField txtAltura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDados frame = new frmDados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmDados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 526);
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
		
		JPanel panelDadosUsuario = new JPanel();
		panelDadosUsuario.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), " Dados do cliente", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(250, 128, 114)));
		panelDadosUsuario.setForeground(SystemColor.menu);
		panelDadosUsuario.setBackground(new Color(255, 255, 255));
		panelDadosUsuario.setBounds(0, 50, 434, 231);
		contentPane.add(panelDadosUsuario);
		panelDadosUsuario.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(22, 21, 23, 14);
		panelDadosUsuario.add(lblId);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(99, 21, 46, 14);
		panelDadosUsuario.add(lblNome);
		
		JLabel lblNasc = new JLabel("NASCIMENTO:");
		lblNasc.setBounds(22, 60, 85, 14);
		panelDadosUsuario.add(lblNasc);
		
		JLabel lblPeso = new JLabel("PESO:");
		lblPeso.setBounds(172, 60, 38, 14);
		panelDadosUsuario.add(lblPeso);
		
		JLabel lblAltura = new JLabel("ALTURA:");
		lblAltura.setBounds(266, 60, 46, 14);
		panelDadosUsuario.add(lblAltura);
		
		JLabel lblSexo = new JLabel("SEXO:");
		lblSexo.setBounds(22, 105, 38, 14);
		panelDadosUsuario.add(lblSexo);
		
		JLabel lblNivelDeAtividade = new JLabel("NIVEL DE ATIVIDADE:");
		lblNivelDeAtividade.setBounds(22, 150, 138, 14);
		panelDadosUsuario.add(lblNivelDeAtividade);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBounds(172, 197, 89, 23);
		panelDadosUsuario.add(btnCalcular);
		
		txtId = new JTextField();
		txtId.setBounds(22, 35, 66, 20);
		panelDadosUsuario.add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(99, 35, 325, 20);
		panelDadosUsuario.add(txtNome);
		
		txtNasc = new JTextField();
		txtNasc.setColumns(10);
		txtNasc.setBounds(22, 79, 109, 20);
		panelDadosUsuario.add(txtNasc);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(172, 79, 66, 20);
		panelDadosUsuario.add(txtPeso);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(266, 79, 73, 20);
		panelDadosUsuario.add(txtAltura);
		txtAltura.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sedent\u00E1rio - Pouco ou nenhum exerc\u00EDcio di\u00E1rio", "Levemente Ativo \u2013 Exerc\u00EDcio Leve 1 a 3 dias na semana", "Moderadamente Ativo - Exerc\u00EDcio Moderado 3 a 5 dias na semana", "Bastante Ativo - Exerc\u00EDcio Pesado 6 a 7 dias na semana", "Muito Ativo - Exerc\u00EDcio Pesado todos dias da semana ou treinos 2x ao dia"}));
		comboBox.setBounds(22, 168, 269, 20);
		panelDadosUsuario.add(comboBox);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(22, 120, 73, 23);
		panelDadosUsuario.add(rdbtnFeminino);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(99, 120, 73, 23);
		panelDadosUsuario.add(rdbtnMasculino);
		
		tableDados = new JTable();
		tableDados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"ID", "CLIENTES"
			}
		));
		tableDados.getColumnModel().getColumn(0).setPreferredWidth(53);
		tableDados.getColumnModel().getColumn(1).setPreferredWidth(340);
		
		JPanel panelCalculos = new JPanel();
		panelCalculos.setBounds(0, 280, 434, 144);
		contentPane.add(panelCalculos);
		panelCalculos.setLayout(null);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBackground(new Color(255, 255, 204));
		panelBotoes.setBounds(0, 424, 434, 63);
		contentPane.add(panelBotoes);
		panelBotoes.setLayout(null);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvar.setBounds(27, 8, 59, 50);
		btnSalvar.setIcon(new ImageIcon(frmInicio.class.getResource("/br/senai/sp/jandira/imagens/save (1).png")));
		panelBotoes.add(btnSalvar);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(frmInicio.class.getResource("/br/senai/sp/jandira/imagens/exit.png")));
		btnSair.setBounds(348, 8, 59, 50);
		panelBotoes.add(btnSair);
	}
}
