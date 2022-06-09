package br.com.senai.analima.application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


	
// As classes Java que representam os dados a serem armazenados no SGBD são chamadas de Entidades (Entity).
@Entity

// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class Pagamento implements Serializable {
	
	// Uma enum é um tipo no qual declaramos um conjunto de valores constantes pré-definidos.
	// Por serem constantes, possuem as letras MAIÚSCULAS
	// Ao utilizar enums, limitamos os valores que podem ser atribuídos a uma variável. Sendo assim, devemos atribuir ao campo um dos valores pré-definidos na enum TipoPagamento.
	
	public enum TipoPagamento {
		CARTAO_CREDITO,
		BOLETO
	}

	// Primary key da tabela
	@Id
	
	// JPA passará a utilizar a geração de chave primária do banco de dados ao qual a aplicação está conectada.
	@GeneratedValue
	
	private Integer id;
	
	// É usada para especificar que um atributo de entidade representa um tipo enumerado.
	
	// @Enumerated(EnumType.ORDINAL) → Armazenar os valores de enum de acordo com a posição ordinal (ou seja, 0 , 1, 2 … ) do valor de enum.
	// @Enumerated(EnumType.STRING) → Armazenar os valores enum de acordo com o nome do valor enum. O padrão é EnumType.ORDINAL.
	
	@Enumerated(EnumType.STRING)
	
	// Define o tamanho da coluna e se ela será "not null"
	@Column(name = "tipo_pagto", length = 20, nullable = false)
	private TipoPagamento tipoPagto;
	
	
	// Relacionamento de cardinalidade um para um 
	@OneToOne(mappedBy = "pagamento")
	private Pedido pedido;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoPagamento getTipoPagto() {
		return tipoPagto;
	}

	public void setTipoPagto(TipoPagamento tipoPagto) {
		this.tipoPagto = tipoPagto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", tipoPagto=" + tipoPagto + "]";
	}
}
