package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.senai.sp.jandira.dao.ClienteDAO;
import br.senai.sp.jandira.model.Cliente;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmDados extends JFrame {

	private JPanel painelPrincipal;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCelular;
	private JTextField txtDtNasc;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtCpf;
	private JTextArea txtResultadoImc;
	private JComboBox comboBox;
	private JRadioButton rdbMasculino;
	private JRadioButton rdbFeminino;
	private ButtonGroup btnGrupoSexo;
	private JLabel lblResultadoIdade;
	private JLabel lblResultadoFcm;
	private JLabel lblResultadoTmb;
	private JLabel lblResultadoImc;
	private JLabel lblOperador;


	public void setTxtNome(String nome) {
		this.txtNome.setText(nome);
	}
	
	public void setTxtEmail(String email) {
		this.txtEmail.setText(email);
	}
	
	public void setTxtCelular(String celular) {
		this.txtCelular.setText(celular);
	}

	public void setTxtDtNasc(String dtNasc) {
		this.txtDtNasc.setText(dtNasc);
	}

	public void setTxtAltura(String altura) {
		this.txtAltura.setText(altura);
	}
	
	public void setTxtPeso(String peso) {
		this.txtPeso.setText(peso);
	}

	public void setTxtCpf(String cpf) {
		this.txtCpf.setText(cpf);
	}


	public void setComboBox(String niveisAtividades) {
		this.comboBox.setSelectedItem(niveisAtividades);
	}
	
	public void setSexo(String sexo) {
		if (sexo.equals("Masculino")) {
			rdbMasculino.setSelected(true);
		} else {
			rdbFeminino.setSelected(true);
		}
	}

	public frmDados(String operacao) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmDados.class.getResource("/br/senai/sp/jandira/imagens/fitness (2).png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 501);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(204, 51, 51));
		painelPrincipal.setForeground(new Color(255, 0, 0));
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelDados = new JPanel();
		painelDados.setBackground(new Color(204, 51, 51));
		painelDados.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		painelDados.setBounds(10, 82, 265, 369);
		painelPrincipal.add(painelDados);
		painelDados.setLayout(null);
		
		JLabel lblNome = new JLabel("CPF:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(10, 21, 46, 14);
		painelDados.add(lblNome);
		
		JLabel label = new JLabel("Nome:");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(10, 49, 46, 14);
		painelDados.add(label);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmail.setBounds(10, 81, 46, 14);
		painelDados.add(lblEmail);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setForeground(new Color(255, 255, 255));
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCelular.setBounds(10, 115, 46, 14);
		painelDados.add(lblCelular);
		
		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNascimento.setForeground(new Color(255, 255, 255));
		lblNascimento.setBounds(10, 151, 86, 14);
		painelDados.add(lblNascimento);
		
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAltura.setForeground(new Color(255, 255, 255));
		lblAltura.setBounds(10, 188, 46, 14);
		painelDados.add(lblAltura);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPeso.setForeground(new Color(255, 255, 255));
		lblPeso.setBounds(116, 188, 46, 14);
		painelDados.add(lblPeso);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setForeground(new Color(255, 255, 255));
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 11));
		lblSexo.setBounds(10, 213, 46, 14);
		painelDados.add(lblSexo);
		
		JLabel lblNivelAtividade = new JLabel("Nivel de atividade:");
		lblNivelAtividade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNivelAtividade.setForeground(new Color(255, 255, 255));
		lblNivelAtividade.setBounds(10, 264, 103, 14);
		painelDados.add(lblNivelAtividade);
		
		txtNome = new JTextField();
		txtNome.setBounds(49, 46, 204, 20);
		painelDados.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(52, 79, 204, 20);
		painelDados.add(txtEmail);
		
		MaskFormatter mascaraCelular = null;

		// CRIANDO MASCARA DE FORMATAÇÃO PARA O CELULAR
		try {
			mascaraCelular = new MaskFormatter("(##) #####-####");
			mascaraCelular.setPlaceholderCharacter('0');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtCelular = new JFormattedTextField(mascaraCelular);
		txtCelular.setColumns(10);
		txtCelular.setBounds(59, 112, 113, 20);
		painelDados.add(txtCelular);
		
		// CRIANDO MASCARA DE FORMATAÇAO PARA A DATA
		MaskFormatter mascaraData = null;

		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtDtNasc = new JFormattedTextField(mascaraData);
		txtDtNasc.setColumns(10);
		txtDtNasc.setBounds(86, 149, 86, 20);
		painelDados.add(txtDtNasc);
		
		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(49, 185, 37, 20);
		painelDados.add(txtAltura);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(150, 185, 54, 20);
		painelDados.add(txtPeso);
		
		MaskFormatter mascaraCpf = null;

		// CRIANDO MASCARA DE FORMATAÇÃO PARA O CPF
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('0');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setColumns(10);
		txtCpf.setBounds(51, 18, 153, 20);
		painelDados.add(txtCpf);
		
		rdbMasculino = new JRadioButton("Masculino");
		rdbMasculino.setForeground(new Color(255, 255, 255));
		rdbMasculino.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbMasculino.setBackground(new Color(204, 51, 51));
		rdbMasculino.setBounds(20, 234, 93, 23);
		rdbMasculino.setActionCommand("Moço");
		painelDados.add(rdbMasculino);
		
		rdbFeminino = new JRadioButton("Feminino");
		rdbFeminino.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbFeminino.setForeground(new Color(255, 255, 255));
		rdbFeminino.setBackground(new Color(204, 51, 51));
		rdbFeminino.setBounds(116, 234, 113, 23);
		rdbFeminino.setActionCommand("Moça");
		painelDados.add(rdbFeminino);
		
		btnGrupoSexo = new ButtonGroup();
		btnGrupoSexo.add(rdbMasculino);
		btnGrupoSexo.add(rdbFeminino);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sedent\u00E1rio", "Levemente Ativo", "Moderadamente Ativo", "Bastante Ativo", "Muito Ativo"}));
		comboBox.setBounds(10, 289, 225, 20);
		painelDados.add(comboBox);
		
		JButton btnCalcular = new JButton("");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				//CRIANDO A FORMATAÇÃO DA DATA E DO VALOR DO TMB E FMC
				DecimalFormat decimal = new DecimalFormat("0.#");
				SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
				Date dataAtual = new Date();
				
				try{
					Date dataAccess = data.parse(txtDtNasc.getText());
					
					long diferencaDataAtual = dataAtual.getTime() - dataAccess.getTime();
					Long diferencaAnos = diferencaDataAtual /1000/60/60/24/365;
					
					int idade = Integer.valueOf(diferencaAnos.intValue());
				// PEGANDO AS INFORMAÇÕES DO CALCULO FEITO COM ALTURA E PESO NA JANELA DE DADOS
					cliente.setIdade(idade);
					cliente.setAltura(Double.parseDouble(txtAltura.getText()));
					cliente.setPeso(Double.parseDouble(txtPeso.getText()));
					cliente.setSexo(btnGrupoSexo.getSelection().getActionCommand());
					cliente.setNiveisAtividades(comboBox.getSelectedItem().toString());
					
					int fcm;
					
					fcm = (int) cliente.fcm();
					// SETANDO AS INFORMAÇÕES DO CALCULO FEITO COM ALTURA E PESO NA JANELA DE DADOS
					lblResultadoIdade.setText(String.valueOf(cliente.getIdade()) + " anos");
					lblResultadoImc.setText(String.valueOf(decimal.format(cliente.imc()) + " kg"));
					txtResultadoImc.setText(cliente.getCalculoImc());
					lblResultadoTmb.setText(String.valueOf(decimal.format(cliente.tmb()) + " Kcal"));
					lblResultadoFcm.setText(String.valueOf(fcm) + " bpm");
					
				}catch(Exception erro){
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				}
			}
		});
		btnCalcular.setToolTipText("Fazer os c\u00E1lculos!");
		btnCalcular.setIcon(new ImageIcon(frmDados.class.getResource("/br/senai/sp/jandira/imagens/calculating.png")));
		btnCalcular.setBounds(111, 320, 37, 32);
		painelDados.add(btnCalcular);
		
		JPanel painelResultados = new JPanel();
		painelResultados.setBackground(new Color(204, 51, 51));
		painelResultados.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Resultados", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		painelResultados.setLayout(null);
		painelResultados.setBounds(285, 82, 270, 276);
		painelPrincipal.add(painelResultados);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setForeground(new Color(255, 255, 255));
		lblIdade.setBounds(10, 23, 46, 14);
		painelResultados.add(lblIdade);
		
		JLabel lblFcm = new JLabel("Frequ\u00EAncia Cardiaca Maxima:");
		lblFcm.setForeground(new Color(255, 255, 255));
		lblFcm.setBounds(10, 73, 204, 14);
		painelResultados.add(lblFcm);
		
		JLabel lblTmb = new JLabel("Taxa Metab\u00F3lica Basal:");
		lblTmb.setForeground(new Color(255, 255, 255));
		lblTmb.setBounds(10, 121, 166, 14);
		painelResultados.add(lblTmb);
		
		JLabel lblImc = new JLabel("Indice de Massa Corporal:");
		lblImc.setForeground(new Color(255, 255, 255));
		lblImc.setBounds(10, 171, 166, 14);
		painelResultados.add(lblImc);
		
		lblResultadoIdade = new JLabel("--");
		lblResultadoIdade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblResultadoIdade.setForeground(new Color(255, 255, 255));
		lblResultadoIdade.setBounds(20, 48, 92, 14);
		painelResultados.add(lblResultadoIdade);
		
		lblResultadoFcm = new JLabel("--");
		lblResultadoFcm.setFont(new Font("Arial", Font.PLAIN, 12));
		lblResultadoFcm.setForeground(new Color(255, 255, 255));
		lblResultadoFcm.setBounds(20, 96, 80, 14);
		painelResultados.add(lblResultadoFcm);
		
		lblResultadoTmb = new JLabel("--");
		lblResultadoTmb.setFont(new Font("Arial", Font.PLAIN, 12));
		lblResultadoTmb.setForeground(new Color(255, 255, 255));
		lblResultadoTmb.setBounds(20, 146, 110, 14);
		painelResultados.add(lblResultadoTmb);
		
		txtResultadoImc = new JTextArea();
		txtResultadoImc.setEditable(false);
		txtResultadoImc.setBounds(10, 200, 250, 65);
		painelResultados.add(txtResultadoImc);
		
		lblResultadoImc = new JLabel("--");
		lblResultadoImc.setFont(new Font("Arial", Font.PLAIN, 12));
		lblResultadoImc.setForeground(new Color(255, 255, 255));
		lblResultadoImc.setBounds(170, 170, 72, 14);
		painelResultados.add(lblResultadoImc);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(new Color(204, 51, 51));
		painelBotoes.setBounds(285, 369, 270, 76);
		painelPrincipal.add(painelBotoes);
		painelBotoes.setLayout(null);
		
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resp = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","ATENÇÃO", JOptionPane.YES_NO_OPTION);
				
				if(resp == 0){
					dispose();
				}
				
			}
		});
		btnSair.setBackground(UIManager.getColor("Button.background"));
		btnSair.setToolTipText("Sair da aplica\u00E7\u00E3o!");
		btnSair.setIcon(new ImageIcon(frmDados.class.getResource("/br/senai/sp/jandira/imagens/exit.png")));
		btnSair.setBounds(167, 11, 59, 54);
		painelBotoes.add(btnSair);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setBackground(UIManager.getColor("Button.background"));
		btnSalvar.setIcon(new ImageIcon(frmDados.class.getResource("/br/senai/sp/jandira/imagens/save (1).png")));
		btnSalvar.setToolTipText("Salvar o contato!");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat dataBase = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS");
				
				Date dataCliente = null;
				String dataBanco = null;
				
				try{
					dataCliente = data.parse(txtDtNasc.getText());
					dataBanco = dataBase.format(dataCliente);
					
					Cliente cliente = new Cliente();
					cliente.setCpf(txtCpf.getText());
					cliente.setNome(txtNome.getText());
					cliente.setCelular(txtCelular.getText());
					cliente.setEmail(txtEmail.getText());
					cliente.setSexo(btnGrupoSexo.getSelection().getActionCommand());
					cliente.setNiveisAtividades(comboBox.getSelectedItem().toString());
					cliente.setDtNasc(dataBanco);
					cliente.setAltura(Double.parseDouble(txtAltura.getText()));
					cliente.setPeso(Double.parseDouble(txtPeso.getText()));
					
					ClienteDAO clienteDAO = new ClienteDAO();
					clienteDAO.setCliente(cliente);
					//IF E ELSE PARA GRAVAR, EDITAR OU EXCLUIR UM USUÁRIO
					if(lblOperador.getText().equals("ADICIONAR")){
						clienteDAO.gravar();
						limpar();
					}else if(lblOperador.getText().equals("EDITAR")){
						clienteDAO.atualizar(txtCpf.getText());
						limpar();
					}else if(lblOperador.getText().equals("EXCLUIR")){
						int resposta = JOptionPane.showConfirmDialog(null,
								"Tem certeza que deseja excluir esse contato?", "Atenção",
								JOptionPane.YES_NO_OPTION);

						if (resposta == 0) {
							clienteDAO.excluir(txtCpf.getText());
							dispose();
						}
					}
				
			}catch(Exception erro){
				erro.printStackTrace();
			}
			}
		});
		
		btnSalvar.setBounds(38, 11, 59, 54);
		painelBotoes.add(btnSalvar);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(new Color(204, 51, 51));
		painelTitulo.setBounds(0, 0, 561, 76);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblBoaForma = new JLabel("Boa Forma");
		lblBoaForma.setForeground(new Color(255, 255, 255));
		lblBoaForma.setFont(new Font("Mistral", Font.PLAIN, 40));
		lblBoaForma.setBackground(new Color(255, 250, 240));
		lblBoaForma.setBounds(234, 33, 181, 44);
		painelTitulo.add(lblBoaForma);
		
		JLabel lblTitulo = new JLabel("ACADEMIA");
		lblTitulo.setBackground(new Color(255, 250, 240));
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setIcon(new ImageIcon(frmDados.class.getResource("/br/senai/sp/jandira/imagens/fitness (2).png")));
		lblTitulo.setFont(new Font("Aharoni", Font.PLAIN, 28));
		lblTitulo.setBounds(157, 11, 247, 66);
		painelTitulo.add(lblTitulo);
		
		lblOperador = new JLabel(operacao);
		lblOperador.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblOperador.setBounds(425, 49, 126, 22);
		painelTitulo.add(lblOperador);
	}
	
	public void limpar(){
		txtNome.requestFocus();
	}
	
}
