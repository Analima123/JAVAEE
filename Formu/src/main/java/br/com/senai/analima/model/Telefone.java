package br.com.senai.analima.model;

//Classe Telefone e seus atributos 
public class Telefone {

	// Uma enum é um tipo no qual declaramos um conjunto de valores constantes pré-definidos.
	// Por serem constantes, possuem as letras MAIÚSCULAS
	// Ao utilizar enums, limitamos os valores que podem ser atribuídos a uma variável. Sendo assim, devemos atribuir ao campo um dos valores pré-definidos na enum Turno.
	public enum Tipo {
		FIXO, CELULAR
	}

	private String ddd;
	private String numero;
	private Tipo tipo;

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
