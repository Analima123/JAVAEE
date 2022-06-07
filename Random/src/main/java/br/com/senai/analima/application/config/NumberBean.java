package br.com.senai.analima.application.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

// Usado para retirar o Warning na tela 
@SuppressWarnings("serial")


// Define o nome que o BEAN será chamado na página XHTML
@Named

// Define o tempo de vida do ESCOPO, no caso o REQUESTSCOPED ficará "vivo" durante a requisição HTTP, ou seja, após a mostra do resultado,tudo será excluido e será gerada uma nova requisição caso a página seja acionada novamente.
@RequestScoped

// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class NumberBean implements Serializable {
	
	private static Random random = new Random();

	private Integer qtde;
	private Integer min;
	private Integer max;
	
	 // Instância uma lista de objetos de números
	private List<Integer> numeros = new ArrayList<>();

	// Método "GERAR"
	public String gerar() {
		
		
		// Imprime sequência de números de acordo com a quantidade escolhida, podendo ser de 0 a 5 números, inteiros aleatórios entre o valor MAX E MIN
		
		for (int i = 0; i < qtde; i++) {
			int n = random.nextInt(max - min) + min + 1;
			
		// Logo em seguida, os números são adicionados na lista "NÚMEROS"
			numeros.add(n);
		}
		
		return null;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public List<Integer> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<Integer> numeros) {
		this.numeros = numeros;
	}
}
