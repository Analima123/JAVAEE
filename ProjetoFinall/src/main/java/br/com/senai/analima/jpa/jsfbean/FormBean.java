package br.com.senai.analima.jpa.jsfbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.senai.analima.application.model.Despesas;
import br.com.senai.analima.jpa.ejbbean.ComandosBean;


// Define o nome que o BEAN será chamado na página XHTML
@Named("form")

// Define o tempo de vida do ESCOPO, no caso o REQUESTSCOPED ficará "vivo" durante a requisição HTTP, ou seja, após a mostra do resultado,tudo será excluido e será gerada uma nova requisição caso a página seja acionada novamente.
@RequestScoped


// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class FormBean implements Serializable {
	
	
	
	//Lógica de negócios	
        //EJB é um framework do Java EE. Eles são executados em um container EJB no lado do servidor. A principal característica do EJB é a rapidez em desenvolver soluções, pois, ele fornece um conjunto de componentes prontos, o que torna o desenvolvimento eficiente.
	
	@EJB
	private ComandosBean comandosBean;


	@Inject
	private FacesContext context;
	
	private UIComponent searchInputText;
	
	private Integer tarefaId;
	
	private Despesas despesa1;
	
	// Grava despesa
	public void gravarr(AjaxBehaviorEvent event) {
		if(despesa1.getId()==null) {
			comandosBean.inserir(despesa1);
		}	
	}
	// Pesquisa despesa
	public void pesquisar(AjaxBehaviorEvent event) {
		despesa1 = comandosBean.carregar(tarefaId);
		
		if(despesa1 == null) {
			context.addMessage(searchInputText.getClientId(context),
					new FacesMessage("Despesa não encontrada"));
		}
		tarefaId = null;		
	}
	
	// Exclui despesa
	public void excluir(AjaxBehaviorEvent event) {
		comandosBean.excluir(despesa1);
		despesa1 = null;
	}
	public Despesas getDespesas() {
		if(despesa1==null) {
			despesa1 = new Despesas();
		}
		return despesa1;
	}

	public UIComponent getSearchInputText() {
		return searchInputText;
	}

	public void setSearchInputText(UIComponent searchInputText) {
		this.searchInputText = searchInputText;
	}

	public Integer getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(Integer tarefaId) {
		this.tarefaId = tarefaId;
	}
	
	
	
}
