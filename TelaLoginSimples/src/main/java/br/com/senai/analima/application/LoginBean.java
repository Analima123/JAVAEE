package br.com.senai.analima.application;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


// Define o nome que o BEAN será chamado na página XHTML
@Named("loginb") 

// Define o tempo de vida do ESCOPO, no caso o REQUESTSCOPED ficará "vivo" durante a requisição HTTP, ou seja, após a mostra do resultado,tudo será excluido e será gerada uma nova requisição caso a página seja acionada novamente.
@RequestScoped

// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class LoginBean implements Serializable{

	private String nome;
	private String senha;
	
	
	
	
	@PostConstruct
	public void onCreate() {
		System.out.println("Bean criado");
	}
	
	
	@PreDestroy
	public void onDestroy () {
		System.out.println("Bean será destruído");
	}

	
	// Validação de LOGIN
	// equals usado para comparar objetos/String
	public String doLogin() {
		if ("abc".equals(nome) && "123".equals(senha)) {
			return "sucesso";
		}
		
		return null;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
