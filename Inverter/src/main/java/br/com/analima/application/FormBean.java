package br.com.analima.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;



// Define o nome que o BEAN será chamado na página XHTML
@Named

// Define o tempo de vida do ESCOPO, no caso o REQUESTSCOPED ficará "vivo" durante a requisição HTTP, ou seja, após a mostra do resultado,tudo será excluido e será gerada uma nova requisição caso a página seja acionada novamente.
@RequestScoped

// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class FormBean implements Serializable {

	private String texto;
	private String textoInvertido;
	
	
	public String inverter() {
		// Inverte o texto e direciona o usuário para a tela onde estava inicialmente 
		textoInvertido = new StringBuilder(texto).reverse().toString();
		return null;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTextoInvertido() {
		return textoInvertido;
	}

	public void setTextoInvertido(String textoInvertido) {
		this.textoInvertido = textoInvertido;
	}
}
