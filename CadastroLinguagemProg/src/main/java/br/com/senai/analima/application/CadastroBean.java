package br.com.senai.analima.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.senai.analima.model.Linguagem;

// Usado para retirar o Warning na tela 
@SuppressWarnings("serial")

// Define o tempo de vida do ESCOPO, no caso o REQUESTSCOPED ficará "vivo" durante a requisição HTTP, ou seja, após a mostra do resultado,tudo será excluido e será gerada uma nova requisição caso a página seja acionada novamente.
@RequestScoped

// Define o nome que o BEAN será chamado na página XHTML, no caso será chamado de "cadastro"
@Named("cadastro")


// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class CadastroBean implements Serializable{
	private String nome;
	private String email;
	private String senha1;
	private String senha2;
	private String sexo;
	private Boolean receberEmails;
	private String observacoes;
	
	//Vetores de linguagens
	private Integer[] linguagens;
	
	// LINGUAGENS = Constante, ou seja, valor não pode ser alterado durante a execução do código 
	public Linguagem[] getListaLinguagens() {
		return Linguagem.LINGUAGENS;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha1() {
		return senha1;
	}
	public void setSenha1(String senha1) {
		this.senha1 = senha1;
	}
	public String getSenha2() {
		return senha2;
	}
	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Boolean getReceberEmails() {
		return receberEmails;
	}
	public void setReceberEmails(Boolean receberEmails) {
		this.receberEmails = receberEmails;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Integer[] getLinguagens() {
		return linguagens;
	}
	public void setLinguagens(Integer[] linguagens) {
		this.linguagens = linguagens;
	}
	
	
	// Permite que as linguagens sejam apresentadas em uma única linha 
	public String getLinguagensAsString() {
		String str="";
		boolean first = true;
		for(Integer linguagem : linguagens) {
			
			if(!first) {
				str +=", ";
			}
			str += Linguagem.LINGUAGENS[linguagem].getNome();
			first = false;
		}
		return str;
	}
	
	

}
