package br.com.senai.analima.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


// As classes Java que representam os dados a serem armazenados no SGBD são chamadas de Entidades (Entity).
@Entity
public class Tarefa {

	// Define a primary key da tabela
	@Id
	
	// JPA passará a utilizar a geração de chave primária do banco de dados ao qual a aplicação está conectada.
	@GeneratedValue
	private Integer id;
	
	private String descricao;
	
	private Integer prioridade;
	
	private Boolean concluida;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}	
	
	
	
}
