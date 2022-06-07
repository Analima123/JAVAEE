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
	
	
	
	
	private String page;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	

// Se a informação escolhida for igual ao nome da página, ela será retornada	
public String goTo() {
	
	if ("a".equals(page)) {
		
		return "page_a";
		
	
// Se a informação escolhida for igual ao nome da página, ela será retornada		
}else if ("b".equals(page)) {

	return "page_b";
	

//Recarrega a mesma página
}else {
	return null;

	
}
}

}
