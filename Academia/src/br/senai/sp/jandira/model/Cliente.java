package br.senai.sp.jandira.model;

public class Cliente {
	
	// ATRIBUTOS DO CLIENTE
	private String cpf;
	private String nome;
	private String email;
	private String celular;
	private String dtNasc;
	private String sexo;
	private String niveisAtividades;
	private String calculoImc;
	private double altura;
	private double peso;
	private int idade;
	private double imc;
	private double tmb;
	private double fcm;
	
	//METODOS GET E SET
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNiveisAtividades() {
		return niveisAtividades;
	}
	public void setNiveisAtividades(String niveisAtividades) {
		this.niveisAtividades = niveisAtividades;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getImc() {
		return imc;
	}
	public void setImc(double imc) {
		this.imc = imc;
	}
	public double getTmb() {
		return tmb;
	}
	public void setTmb(double tmb) {
		this.tmb = tmb;
	}
	public double getFcm() {
		return fcm;
	}
	public void setFcm(double fcm) {
		this.fcm = fcm;
	}
	public String getCalculoImc() {
		return calculoImc;
	}
	public void setCalculoImc(String calculoImc) {
		this.calculoImc = calculoImc;
	}
	
	//METODOS DE CALCULOS
	
	
	public double imc(){
		
		imc = peso / (altura / 100 * altura /100);
		
		if (imc <= 16.9) {
			calculoImc = "Muito abaixo do peso:\nQueda de cabelo, \n infertilidade, ausência menstrual.";
		} else if (imc <= 18.4) {
			calculoImc = "Abaixo do peso:\n Fadiga, stress, \n ansiedade.";
		} else if (imc <= 24.9) {
			calculoImc = "Peso normal: \n Menor risco de doenças \n cardíacas e vasculares.";
		} else if (imc <= 29.9) {
			calculoImc = "Acima do peso: \n Fadiga, má circulação, \n varizes.";
		} else if (imc <= 34.9) {
			calculoImc = "Obesidade Grau I: \n Diabetes, angina, infarto, \n aterosclerose.";
		} else if (imc <= 40) {
			calculoImc = "Obesidade Grau II: \n Apneia do sono, falta de ar.";
		} else if (imc > 40) {
			calculoImc = "Obesidade Grau III: \n Refluxo, dificuldade para se mover,\n escaras, diabetes, infarto, AVC.";
		}
		
		return imc;
	}
	
	public double tmb(){
		if (sexo == "Moço") {
			tmb = 66 + (13.7 * peso) + (5 * altura) - (6.8 * idade);
		} else if (sexo == "Moça") {
			tmb = 665 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade);
		}

		if (niveisAtividades == "Sedentário") {
			tmb = tmb * 1.20;
		} else if (niveisAtividades == "Levemente Ativo") {
			tmb = tmb * 1.37;
		} else if (niveisAtividades == "Moderadamente Ativo") {
			tmb = tmb * 1.55;
		} else if (niveisAtividades == "Bastante Ativo") {
			tmb = tmb * 1.72;
		} else if (niveisAtividades == "Muito Ativo") {
			tmb = tmb * 1.90;
		}

		return tmb;
	}
	
	public double fcm(){
		if (sexo == "Moço") {
			fcm = ((210 - (0.5 * idade)) - peso * 1 / 100) + 4;
		} else if (sexo == "Moça") {
			fcm = ((210 - (0.5 * idade)) - peso * 1 / 100);
		}
		return fcm;
	}
	
}
