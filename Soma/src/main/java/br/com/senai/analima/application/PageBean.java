package br.com.senai.analima.application;


import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


// Usado para retirar o Warning na tela 
@SuppressWarnings("serial")

// Define o nome que o BEAN será chamado na página XHTML
@Named
	
// Define o tempo de vida do ESCOPO, no caso o REQUESTSCOPED ficará "vivo" durante a requisição HTTP, ou seja, após a mostra do resultado,tudo será excluido e será gerada uma nova requisição caso a página seja acionada novamente.
@RequestScoped

// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class PageBean implements Serializable {

	private Integer valor1;
	private Integer valor2;
	private Integer valor3;
	private Integer resultado;
	
	// Soma os valores, armazena no atributo da classe e leva o usuário pra tela 'result'
	public String somar() {
		
		resultado = valor1 + valor2 + valor3;
		return "result";
	}

	public Integer getValor1() {
		return valor1;
	}

	public void setValor1(Integer valor1) {
		this.valor1 = valor1;
	}

	public Integer getValor2() {
		return valor2;
	}

	public void setValor2(Integer valor2) {
		this.valor2 = valor2;
	}

	public Integer getValor3() {
		return valor3;
	}

	public void setValor3(Integer valor3) {
		this.valor3 = valor3;
	}

	public Integer getResultado() {
		return resultado;
	}

	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}
}
