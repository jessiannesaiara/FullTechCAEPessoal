package br.com.jffw.cae.dto;

public class VagaVeiculosDTO {
	private String placa;
	private String cor;
	private String modelo;
	private int Vaga;
	private String bloco;
	private String numero;
<<<<<<< HEAD
	
	public  VagaVeiculosDTO() { }
	public  VagaVeiculosDTO(String placa, String cor, String modelo, int vaga, String bloco, String numero ) {
		this.setPlaca(placa);this.setCor(cor);
=======

	public VagaVeiculosDTO() {
	}

	public VagaVeiculosDTO(String placa, String cor, String modelo, int vaga, String bloco, String numero) {
		this.setPlaca(placa);
		this.setCor(cor);
>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
		this.setModelo(modelo);
		this.setVaga(vaga);
		this.setBloco(bloco);
		this.setNumero(numero);
	}
<<<<<<< HEAD
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getModelo() {
		return modelo;
	}
=======

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getVaga() {
		return Vaga;
	}
<<<<<<< HEAD
	public void setVaga(int vaga) {
		Vaga = vaga;
	}
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	public String getNumero() {
		return numero;
	}
=======

	public void setVaga(int vaga) {
		Vaga = vaga;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getNumero() {
		return numero;
	}

>>>>>>> 804433d87484860616f7c2bfc3ec9c03aceb9dea
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
