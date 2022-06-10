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

import br.com.senai.analima.jpa.ejbbean.TarefaBean;
import br.com.senai.analima.model.Tarefa;


// Usado para retirar o Warning na tela 
@SuppressWarnings("serial")


// Define o nome que o BEAN será chamado na página XHTML
@Named("form")


// Define o tempo de vida do ESCOPO, no caso o REQUESTSCOPED ficará "vivo" durante a requisição HTTP, ou seja, após a mostra do resultado,tudo será excluido e será gerada uma nova requisição caso a página seja acionada novamente.
@RequestScoped

// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class FormBean implements Serializable {
	
	
//EJB é um framework do Java EE. Eles são executados em um container EJB no lado do servidor. A principal característica do EJB é a rapidez em desenvolver soluções, pois, ele fornece um conjunto de componentes prontos, o que torna o desenvolvimento eficiente.
	@EJB

	
	private TarefaBean tarefaBean;

	//A anotação @Inject nos permite definir um ponto de injeção que é injetado durante a instanciação do bean
	
	private FacesContext context;

	private UIComponent searchInputText;
	
	private Integer tarefaId;
	
	private Tarefa tarefa;
	
	// Métodos vindos do TAREFABEAN
	
	public void gravar(AjaxBehaviorEvent event) {
		if(tarefa.getId()==null) {
			tarefaBean.inserir(tarefa);
		}else {
			tarefaBean.atualizar(tarefa);
		}		
	}
	
	public void pesquisar(AjaxBehaviorEvent event) {
		tarefa = tarefaBean.carregar(tarefaId);
		
		if(tarefa == null) {
			
			// O usuário insere um número de ID e será verificado se a ID existe no banco, caso contrário irá aparecer a mensagem abaixo
			context.addMessage(searchInputText.getClientId(context),
					new FacesMessage("Tarefa não encontrada"));
		}
		tarefaId = null;		
	}
	
	public void excluir(AjaxBehaviorEvent event) {
		tarefaBean.excluir(tarefa);
		tarefa = null;
	}
	public Tarefa getTarefa() {
		if(tarefa==null) {
			tarefa = new Tarefa();
		}
		return tarefa;
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
