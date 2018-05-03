package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import javax.swing.text.MaskFormatter;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
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
	private JTextField txtImc;
	private JTextField txtTcm;
	private JTextField txtFcm;
	private JComboBox cbNiveisAtividades;
	private JTextField txtCelular;
	private JTextField txtTelefone;


	public void setTxtId(int id) {
		this.txtId.setText(String.valueOf(id));;
	}

	public void setTxtNome(String nome) {
		this.txtNome.setText(nome);
	}

	public void setTxtNasc(String nasc) {
		this.txtNasc.setText(nasc);
	}

	public void setTxtPeso(int peso) {
		this.txtPeso.setText(String.valueOf(peso));
	}

	public void setTxtAltura(int altura) {
		this.txtAltura.setText(String.valueOf(altura));
	}

	public void setcbNiveisAtividades(String niveisAtividades){
		if(niveisAtividades.equals("Sedentário")){
			cbNiveisAtividades.setSelectedIndex(0);
		}else if(niveisAtividades.equals("Levemente Ativo")){
			cbNiveisAtividades.setSelectedIndex(1);
		}
	}
	
	public frmDados(String operacao) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(255, 255, 204));
		panelTitulo.setBounds(0, 0, 434, 56);
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
		
		JLabel lblOperao = new JLabel("opera\u00E7\u00E3o");
		lblOperao.setBounds(340, 18, 84, 14);
		panelTitulo.add(lblOperao);
		
		JPanel panelDadosUsuario = new JPanel();
		panelDadosUsuario.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), " Dados do cliente", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(250, 128, 114)));
		panelDadosUsuario.setForeground(SystemColor.menu);
		panelDadosUsuario.setBackground(new Color(255, 255, 255));
		panelDadosUsuario.setBounds(0, 61, 434, 288);
		contentPane.add(panelDadosUsuario);
		panelDadosUsuario.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(22, 21, 23, 14);
		panelDadosUsuario.add(lblId);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(99, 21, 46, 14);
		panelDadosUsuario.add(lblNome);
		
		JLabel lblNasc = new JLabel("NASCIMENTO:");
		lblNasc.setBounds(22, 64, 85, 14);
		panelDadosUsuario.add(lblNasc);
		
		JLabel lblPeso = new JLabel("PESO:");
		lblPeso.setBounds(172, 64, 38, 14);
		panelDadosUsuario.add(lblPeso);
		
		JLabel lblAltura = new JLabel("ALTURA:");
		lblAltura.setBounds(266, 64, 73, 14);
		panelDadosUsuario.add(lblAltura);
		
		JLabel lblSexo = new JLabel("SEXO:");
		lblSexo.setBounds(22, 151, 38, 14);
		panelDadosUsuario.add(lblSexo);
		
		JLabel lblNivelDeAtividade = new JLabel("NIVEL DE ATIVIDADE:");
		lblNivelDeAtividade.setBounds(22, 202, 138, 14);
		panelDadosUsuario.add(lblNivelDeAtividade);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBounds(156, 254, 101, 23);
		panelDadosUsuario.add(btnCalcular);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
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
		
		JComboBox cbNiveisAtividades = new JComboBox();
		cbNiveisAtividades.setModel(new DefaultComboBoxModel(new String[] {"Sedent\u00E1rio - Pouco ou nenhum exerc\u00EDcio di\u00E1rio", "Levemente Ativo \u2013 Exerc\u00EDcio Leve 1 a 3 dias na semana", "Moderadamente Ativo - Exerc\u00EDcio Moderado 3 a 5 dias na semana", "Bastante Ativo - Exerc\u00EDcio Pesado 6 a 7 dias na semana", "Muito Ativo - Exerc\u00EDcio Pesado todos dias da semana ou treinos 2x ao dia"}));
		cbNiveisAtividades.setBounds(22, 223, 345, 20);
		panelDadosUsuario.add(cbNiveisAtividades);
		
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setSelected(true);
		rdbtnFeminino.setBounds(22, 172, 85, 23);
		panelDadosUsuario.add(rdbtnFeminino);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(121, 172, 101, 23);
		panelDadosUsuario.add(rdbtnMasculino);
		
		JRadioButton rdbtnNoEspecificado = new JRadioButton("N\u00E3o especificado");
		rdbtnNoEspecificado.setBounds(230, 172, 137, 23);
		panelDadosUsuario.add(rdbtnNoEspecificado);
		
		ButtonGroup btnGroupSexo = new ButtonGroup();
		btnGroupSexo.add(rdbtnFeminino);
		btnGroupSexo.add(rdbtnMasculino);
		btnGroupSexo.add(rdbtnNoEspecificado);
		
		JLabel lblCelular = new JLabel("CELULAR:");
		lblCelular.setBounds(22, 108, 85, 14);
		panelDadosUsuario.add(lblCelular);
		
		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setBounds(172, 108, 85, 14);
		panelDadosUsuario.add(lblTelefone);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(22, 122, 109, 20);
		panelDadosUsuario.add(txtCelular);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(172, 122, 109, 20);
		panelDadosUsuario.add(txtTelefone);

		
		JPanel panelCalculos = new JPanel();
		panelCalculos.setBounds(0, 348, 434, 177);
		contentPane.add(panelCalculos);
		panelCalculos.setLayout(null);
		
		JLabel lblImc = new JLabel("IMC:");
		lblImc.setForeground(new Color(250, 128, 114));
		lblImc.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblImc.setBounds(24, 11, 46, 14);
		panelCalculos.add(lblImc);
		
		JLabel lblTmc = new JLabel("TMC:");
		lblTmc.setForeground(new Color(250, 128, 114));
		lblTmc.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblTmc.setBounds(24, 89, 46, 14);
		panelCalculos.add(lblTmc);
		
		JLabel lblFcm = new JLabel("FCM:");
		lblFcm.setForeground(new Color(250, 128, 114));
		lblFcm.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblFcm.setBounds(24, 131, 46, 14);
		panelCalculos.add(lblFcm);
		
		txtImc = new JTextField();
		txtImc.setBounds(23, 27, 390, 54);
		panelCalculos.add(txtImc);
		txtImc.setColumns(10);
		
		txtTcm = new JTextField();
		txtTcm.setBounds(24, 104, 389, 20);
		panelCalculos.add(txtTcm);
		txtTcm.setColumns(10);
		
		txtFcm = new JTextField();
		txtFcm.setBounds(22, 146, 391, 20);
		panelCalculos.add(txtFcm);
		txtFcm.setColumns(10);
		
		//********CRIANDO A FORMATAÇÃO DE INSEÇÃO DE DATA NO FORMULÁRIO
		MaskFormatter dataMask = null;
		try {
			dataMask = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBackground(new Color(255, 255, 204));
		panelBotoes.setBounds(0, 522, 434, 63);
		contentPane.add(panelBotoes);
		panelBotoes.setLayout(null);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setToolTipText("Salvar as altera\u00E7\u00F5es");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//*** FORMATANDO A DATA PARA O USUARIO ****
				 //SimpleDateFormat toDate = SimpleDateFormat("dd/MM/yyyy");
				
				//***** FORMATANDO A DATA PARA O BANCO DE DADOS ****
				//SimpleDateFormat toDataBase = SimpleDateFormat("yyyy-MM-dd hh:mm:ss.000000");
				
				Date date = null;
				String dataAccess = "";
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
