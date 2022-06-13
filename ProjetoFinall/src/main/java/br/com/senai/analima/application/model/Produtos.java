package br.com.senai.analima.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


// As classes Java que representam os dados a serem armazenados no SGBD são chamadas de Entidades (Entity).
@Entity

public class Produtos {
	
	// Primary key
	@Id
	
	// JPA passará a utilizar a geração de chave primária do banco de dados ao qual a aplicação está conectada.
	@GeneratedValue
	
	
	private Integer id;
	private String nome;
	private Double valor;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
