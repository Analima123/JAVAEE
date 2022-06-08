package br.com.senai.analima.application.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import br.com.senai.analima.application.model.Despesas;

// Usado para retirar o Warning na tela 
@SuppressWarnings("serial")

// Define o nome que o BEAN será chamado na página XHTML, no caso será chamado de "tabela"
@Named("tabela")

//O Escopo ficará vivo enquanto a sessão estiver viva, ou seja, a sessão ficará viva enquanto o navegador não for fechado ou ao ter um time out definido
@SessionScoped 

// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class TabelaBean implements Serializable {
	
	// Lista de objetos despesa
	private List<Despesas> despesas = new ArrayList<>();

	//Insere uma nova despesa e deixa o edit desabilitado, logo em seguida, salva a despesa na lista
	public String inserir() {	
	Despesas desp = new Despesas(); 
	desp.setEdit(true);
	despesas.add(desp);
		return null;
	}
	
	public String excluir(Despesas despesa) {	
	despesas.remove(despesa);
		return null;
	}
	
	public String editar(Despesas despesa) {	
	 despesa.setEdit(true);
		return null;
	}
	
	//Grava a despesa e deixa o edit habilitado
	public String gravar(Despesas despesa) {	
	 despesa.setEdit(false);
		return null;
	}
	
	public List<Despesas> getDespesas() {
		return despesas;
		
	} 

	
	}
	
	
