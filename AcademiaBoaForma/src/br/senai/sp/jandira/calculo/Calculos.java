package br.senai.sp.jandira.calculo;

public class Calculos {
	
	private String nome;
	private double peso;
	private double altura;
	private double idade;
	private String sexo;
	private String nivelAtividade;
	
	private double imc;
	private String tipoImc;
	private double tmb;
	private double fcm;

	 
	// GET E SETTERS


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public double getAltura() {
		return altura;
	}


	public void setAltura(double altura) {
		this.altura = altura;
	}


	public double getIdade() {
		return idade;
	}


	public void setIdade(double idade) {
		this.idade = idade;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getNivelAtividade() {
		return nivelAtividade;
	}


	public void setNivelAtividade(String nivelAtividade) {
		this.nivelAtividade = nivelAtividade;
	}


	public double getImc() {
		return imc;
	}


	public void setImc(double imc) {
		this.imc = imc;
	}


	public String getTipoImc() {
		return tipoImc;
	}


	public void setTipoImc(String tipoImc) {
		this.tipoImc = tipoImc;
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
	
	//	MÉTODOS DA CLASSE
	public double imc(){
		
		imc = peso / ((altura/100) * (altura/100 ));

		return imc;
	}



	public double tmb(){
		if (sexo == "Homem"){
			tmb = 66 + (13.7 * peso) + (5*altura) - (4.7*idade);
		} else if (sexo == "Mulher"){
			tmb = 665 + (9.6 * peso) + (1.8*altura) - (4.7 * idade);
		}
		return tmb;
	}

		public double fcm(){
			if (sexo == "Homem"){
				 fcm = (210 - (0.5 * idade) - peso * 1 /100) + 4;
			} else if (sexo == "Mulher"){
				 fcm = (210 - (0.5 * idade) - peso * 1/100);
			}
			return fcm;
		}
}
