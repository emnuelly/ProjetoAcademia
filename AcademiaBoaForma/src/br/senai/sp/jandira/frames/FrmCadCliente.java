 package br.senai.sp.jandira.frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.senai.sp.jandira.calculo.Calculos;

public class FrmCadCliente extends JFrame{
	
	protected String nome;

	// método construtor - recebe o mesmo nome da classe e não é tipado. e serve para construir um objeto quando chamamos o "new".
	// pode ter varios construtores para um mesmo objeto, com parametros ou não.
	
	public FrmCadCliente(){
		// ****** CRIAÇÃO DE CORES **********
		Color branco = new Color(255, 255, 255);
		Color cinza = new Color(223, 223, 223);
		Color amarelo = new Color(255, 255, 215);
		Color verde = new Color(34,177,76);
		
		Calculos calc = new Calculos();
		
		// ****** CRIAÇÃO DE FONTE ********
		
		Font fontTitulo = new Font("Arial", 0, 30);
		
		// ******** CRIAÇÃO DA JANELA USANDO O MÉTODO CONTRUTOR *********
		setSize(680,515);
		setLayout(null);
		setTitle("Calculadora de Calorias");
		setBackground(amarelo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//****IMAGENS ****** criando objeto tipo Icon que recebe imagens.
		ImageIcon iconUser = new ImageIcon(FrmCadCliente.class.getResource("/br/senai/sp/jandira/imagens/user32.png"));
		ImageIcon iconLogo = new ImageIcon(FrmCadCliente.class.getResource("/br/senai/sp/jandira/imagens/logo64.png"));
		ImageIcon iconCalc = new ImageIcon(FrmCadCliente.class.getResource("/br/senai/sp/jandira/imagens/calc.png"));
		
		//********* BORDA COM TITULO ******
		TitledBorder bordaTitulo = new TitledBorder("Dados: ");
		TitledBorder bordaResultado = new TitledBorder("Resultado: ");
		
		// ****** CRIAÇÃO DE JLABELS PARA O JPANEL DOS DADOS *********
		JLabel lblLogo = new JLabel();
		lblLogo.setBounds(20, 20, 500, 70);
		lblLogo.setText(" ACADEMIA BOA FORMA");
		lblLogo.setIcon(iconLogo);
		lblLogo.setFont(fontTitulo);;
		
		JLabel lblNome = new JLabel();
		lblNome.setBounds(12, 12, 150, 40);
		lblNome.setText("Nome:");
		
		JLabel lblSexo = new JLabel();
		lblSexo.setBounds(12, 40, 150, 40);
		lblSexo.setText("Sexo:");
		
		JLabel lblPeso = new JLabel();
		lblPeso.setBounds(12, 70, 150, 40);
		lblPeso.setText("Peso:");
		
		JLabel lblAltura = new JLabel();
		lblAltura.setBounds(12, 100, 150, 40);
		lblAltura.setText("Altura:");
		
		JLabel lblIdade = new JLabel();
		lblIdade.setBounds(12, 130, 150, 40);
		lblIdade.setText("Idade:");
		
		JLabel lblNivelAtiv = new JLabel();
		lblNivelAtiv.setText("Nível de atividade:");
		lblNivelAtiv.setBounds(20, 300, 300, 20);
		
		// ************ CRIAÇÃO DE JLABEL PARA O JPANEL DO RESULTADO *******
		
		JLabel lblResultadoNome = new JLabel();
		lblResultadoNome.setBounds(60, 12, 150, 40);
		lblResultadoNome.setText("Nome:");
		
		JLabel lblNovoResultadoNome = new JLabel();
		lblNovoResultadoNome.setBounds(100, 12, 150, 40);
		lblNovoResultadoNome.setText("");
		lblNovoResultadoNome.setForeground(verde);
		
		JLabel lblResultadoIdade = new JLabel();
		lblResultadoIdade.setBounds(60, 40, 150, 40);
		lblResultadoIdade.setText("Idade:");
		
		JLabel lblNovoResultadoIdade = new JLabel();
		lblNovoResultadoIdade.setBounds(100, 40, 150, 40);
		lblNovoResultadoIdade.setText("");
		lblNovoResultadoIdade.setForeground(verde);
		
		JLabel lblResultadoAltura = new JLabel();
		lblResultadoAltura.setBounds(60, 70, 150, 40);
		lblResultadoAltura.setText("Altura:");
		
		JLabel lblNovoResultadoAltura = new JLabel();
		lblNovoResultadoAltura.setBounds(100, 70, 150, 40);
		lblNovoResultadoAltura.setText("");
		lblNovoResultadoAltura.setForeground(verde);
		
		JLabel lblResultadoPeso = new JLabel();
		lblResultadoPeso.setBounds(60, 100, 150, 40);
		lblResultadoPeso.setText("Peso:");
		
		JLabel lblNovoResultadoPeso = new JLabel();
		lblNovoResultadoPeso.setBounds(100, 100, 150, 40);
		lblNovoResultadoPeso.setText("");
		lblNovoResultadoPeso.setForeground(verde);
		
		JLabel lblResulNivelAtividade = new JLabel();
		lblResulNivelAtividade.setBounds(12, 130, 150, 40);
		lblResulNivelAtividade.setText("Nível da atividade:");
		
		JLabel lblResulNovoNivelAtividade = new JLabel();
		lblResulNovoNivelAtividade.setBounds(120, 130, 200, 40);
		lblResulNovoNivelAtividade.setText("");
		
		
		JLabel lblResulImc = new JLabel();
		lblResulImc.setBounds(60, 160, 150, 40);
		lblResulImc.setText("IMC:");
		
		JLabel lblImc = new JLabel();
		lblImc.setBounds(100, 160, 150, 40);
		lblImc.setText("");
		
		
		JLabel lblResultadoImc = new JLabel();
		lblResultadoImc.setBounds(100, 195, 200, 50);
		lblResultadoImc.setBackground(verde);
		
		JLabel lblResulTMB = new JLabel();
		lblResulTMB.setBounds(60, 240, 150, 40);
		lblResulTMB.setText("TMB:");
		
		JLabel lblNovoResulTMB = new JLabel();
		lblNovoResulTMB.setBounds(100, 240, 200, 40);
		lblNovoResulTMB.setText("");
		lblNovoResulTMB.setForeground(verde);
		
		JLabel lblResulFCM = new JLabel();
		lblResulFCM.setBounds(60, 270, 150, 40);
		lblResulFCM.setText("FCM:");
		
		JLabel lblNovoResulFCM = new JLabel();
		lblNovoResulFCM.setBounds(100, 270, 150, 40);
		lblNovoResulFCM.setText("");
		
		// ******** CRIAÇÃO DE JRADIUNBUTTON ******
		JRadioButton btnRadioHomem = new JRadioButton("Homem");
		btnRadioHomem.setBounds(50, 45, 80, 30);
		btnRadioHomem.setActionCommand("Homem");
		btnRadioHomem.setBackground(amarelo);
		
		JRadioButton btnRadioMulher = new JRadioButton("Mulher");
		btnRadioMulher.setBounds(130, 45, 150, 30);
		btnRadioMulher.setActionCommand("Mulher");
		btnRadioMulher.setBackground(amarelo);
		
		ButtonGroup btnGroupSexo = new ButtonGroup();
		btnGroupSexo.add(btnRadioHomem);
		btnGroupSexo.add(btnRadioMulher);
		
		
		// ******** CRIAÇÃO DE CAIXAS DE TEXTO PARA O JPANEL DOS DADOS *******
		JTextField txtNome = new JTextField();
		txtNome.setBounds(60, 24, 210, 18);
		
		JTextField txtPeso = new JTextField();
		txtPeso.setBounds(60, 80, 40, 20);
		
		JTextField txtAltura = new JTextField();
		txtAltura.setBounds(60, 110, 40, 20);
		
		JTextField txtIdade = new JTextField();
		txtIdade.setBounds(60, 140, 40, 20);
	
		
		//*********** CRIAÇÃO DE JBUTTON **********
		JButton btnCalcular = new JButton();
		btnCalcular.setText("CALCULAR");
		btnCalcular.setBounds(80, 360, 150, 50);
		btnCalcular.setIcon(iconCalc);
		btnCalcular.setBackground(cinza);
		
		//******** DECIMAL FORMAT **********
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.##");
		
		//******* PAINEIS *******
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBounds(1, 1, 675, 90);
		painelTitulo.setLayout(null);
		
		JPanel painelDados = new JPanel();
		painelDados.setBounds(1, 120, 310, 350);
		painelDados.setLayout(null);
		painelDados.setBorder(bordaTitulo);
		painelDados.setBackground(amarelo);
		
		JPanel painelResultado = new JPanel();
		painelResultado.setBounds(311, 120, 350, 350);
		painelResultado.setLayout(null);
		painelResultado.setBorder(bordaResultado);
		painelResultado.setBackground(amarelo);
		
		
		//********** CRIAÇÃO DE COMBOBOX ********
		String[] niveis = {"Sedentário", "Levemente Ativo", "Moderadamente Ativo", "Bastante Ativo", "Muito Ativo"};
		
		JComboBox<String> cbNiveis = new JComboBox<>();
		DefaultComboBoxModel<String> tipoNiveis = new DefaultComboBoxModel<>(niveis);
		cbNiveis.setModel(tipoNiveis);
		cbNiveis.setBounds(20, 325, 270, 20);
		cbNiveis.setBackground(cinza);
		
		// ******** ADCIONANDO CONTEUDO NA JANELA ****
		
		painelTitulo.add(lblLogo);
		getContentPane().add(painelTitulo);
		
		
		getContentPane().add(cbNiveis);
		getContentPane().add(lblNivelAtiv);
		getContentPane().add(btnCalcular);
				
		//***** ADCIONANDO CONTEUDO NO PAINEL DE DADOS DO USUÁRIO. ******
				
		painelDados.add(lblNome);
		painelDados.add(lblSexo);
		painelDados.add(btnRadioHomem);
		painelDados.add(btnRadioMulher);
		btnGroupSexo.add(btnRadioMulher);
		btnGroupSexo.add(btnRadioHomem);
		painelDados.add(lblPeso);
		painelDados.add(lblAltura);
		painelDados.add(lblIdade);
		painelDados.add(txtNome);
		painelDados.add(txtPeso);
		painelDados.add(txtAltura);
		painelDados.add(txtIdade);
		getContentPane().add(painelDados);
		
		
		// *********** ADICIONANDO CONTEUDO NO PAINEL DOS RESULTADOS DO USUÁRIO ******
		
		getContentPane().add(painelResultado);
		
		
		painelResultado.add(lblNovoResultadoNome);
		painelResultado.add(lblResultadoNome);
		painelResultado.add(lblResultadoAltura);
		painelResultado.add(lblNovoResultadoAltura);
		painelResultado.add(lblResultadoIdade);
		painelResultado.add(lblNovoResultadoIdade);
		painelResultado.add(lblResultadoPeso);
		painelResultado.add(lblNovoResultadoPeso);
		painelResultado.add(lblResulNivelAtividade);
		painelResultado.add(lblResulImc); 
		painelResultado.add(lblImc);
		painelResultado.add(lblResultadoImc);
		
		painelResultado.add(lblResulTMB);
		painelResultado.add(lblResulFCM);
		painelResultado.add(lblNovoResulTMB);
		painelResultado.add(lblNovoResulFCM);
		painelResultado.add(lblResulNovoNivelAtividade);
	
		
		btnCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				// *********** INSERIR OS ATRIBUTOS NO PAINEL *********
				calc.setNome(txtNome.getText());
				lblNovoResultadoNome.setText(calc.getNome());
				
				calc.setIdade(Integer.parseInt(txtIdade.getText()));
				lblNovoResultadoIdade.setText(String.valueOf(calc.getIdade() + " anos"));
				
				calc.setAltura(Double.parseDouble(txtAltura.getText()));
				lblNovoResultadoAltura.setText(String.valueOf(calc.getAltura() + " cm"));;
				
				calc.setPeso(Double.parseDouble(txtPeso.getText()));
				lblNovoResultadoPeso.setText(String.valueOf(calc.getPeso() + " quilos"));;
				
				lblImc.setText(String.valueOf(decimalFormat.format(calc.imc())));
				
				lblResultadoImc.setText(calc.getTipoImc());
				
				if(btnRadioHomem.isSelected()){
					calc.setSexo("Homem");
				}else{
					calc.setSexo("Mulher");
				}
				
				lblNovoResulTMB.setText(String.valueOf(calc.tmb()));
				
				lblNovoResulFCM.setText(String.valueOf(calc.fcm()));
				
				lblResulNovoNivelAtividade.setText(cbNiveis.getSelectedItem().toString());
				
			// ************ ESTRUTURA DE DECISÃO DO IMC ******************
				if (calc.imc() <= 16.9){
					lblResultadoImc.setText("<html><body>Muito abaixo do peso! <br> Pode acontecer: Queda de cabelo, infertilidade, ausência menstrual.</body></html>");
				}else if (calc.imc() <= 18.4){
					lblResultadoImc.setText("<html><body>Abaixo do peso! <br> Pode acontecer: Fadiga, stress, ansiedade.</body></html>");
				}else if (calc.imc() <= 24.9){
					lblResultadoImc.setText("<html><body>Peso normal! Pode acontecer: Menor risco de doenças cardiacas e vasculares.</body></html>");
				}else if (calc.imc() <= 29.9){
					lblResultadoImc.setText("<html><body>Acima do peso!<br> Pode acontecer: Fadiga, má circulação, varizes.</body></html>");
				}else if (calc.imc() <= 34.9){
					lblResultadoImc.setText("<html><body>Obesidade Grau I <br> Pode acontecer: Diabetes, angina, infarto, aterosclerose.</body></html>");
				}else if (calc.imc() <= 40){
					lblResultadoImc.setText("<html><body>Obesidade Grau II <br> Pode acontecer: Apneia do Sono, falta de ar.</body></html>");
				} else if (calc.imc() > 40){
					lblResultadoImc.setText("<html><body>Obesidade Grau III <br> Pode acontecer: Refluxo, dificuldade para se mover, AVC.</body></html>");
				}
			}
		});	
		
		// *********** TORNAR A JANELA VISIVEL **************
		setVisible(true);
		
	}

}
