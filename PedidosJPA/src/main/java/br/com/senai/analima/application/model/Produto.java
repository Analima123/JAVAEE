package br.com.senai.analima.application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// Usado para retirar o Warning na tela 
@SuppressWarnings("serial")

// As classes Java que representam os dados a serem armazenados no SGBD são chamadas de Entidades (Entity).
@Entity

// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class Produto implements Serializable {

	// Primary key da tabela
	@Id
	
	// JPA passará a utilizar a geração de chave primária do banco de dados ao qual a aplicação está conectada.
	@GeneratedValue
	private Integer id;
	
	// Define o tamanho da coluna e se ela será "not null"
	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(nullable = false)
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

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", valor=" + valor
				+ "]";
	}
}
