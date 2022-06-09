package br.com.senai.analima.application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


	// Uma enum é um tipo no qual declaramos um conjunto de valores constantes pré-definidos.
	// Por serem constantes, possuem as letras MAIÚSCULAS
	// Ao utilizar enums, limitamos os valores que podem ser atribuídos a uma variável. Sendo assim, devemos atribuir ao campo um dos valores pré-definidos na enum TipoPagamento.
@Entity
public class Pagamento implements Serializable {
	public enum TipoPagamento {
		CARTAO_CREDITO,
		BOLETO
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pagto", length = 20, nullable = false)
	private TipoPagamento tipoPagto;
	
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
