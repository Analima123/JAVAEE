package br.com.senai.analima.application.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import br.com.senai.analima.application.model.Despesas;
import br.com.senai.analima.jpa.ejbbean.ComandosBean;

// Usado para retirar o Warning na tela 
@SuppressWarnings("serial") 

// Define o nome que o BEAN será chamado na página XHTML, no caso será chamado de "TABELA"
@Named("tabela")



@SessionScoped 


// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class TabelaBean implements Serializable{
	
	// Responsável por criar a lista de despesas
	private List<Despesas> despesas = new ArrayList<>();
	private String user;
	private String senha;
	
	String data1;
	String desc1;
	Double Valor1;
	String produtos;
	
	// A variável "a" será responsável por renderizar a tabela do usuário
	
	// Se a variável receber "true", significa que será renderizando na tela
	
	// Se a variável receber "false", significa que não será renderizado na tela
	
	Boolean a = false; 
	
	
	private Despesas despesas1;

	//Lógica de negócios	
	//EJB é um framework do Java EE. Eles são executados em um container EJB no lado do servidor. A principal característica do EJB é a rapidez em desenvolver soluções, pois, ele fornece um conjunto de componentes prontos, o que torna o desenvolvimento eficiente.
	
	@EJB
	private ComandosBean comandosBean;
	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public Double getValor1() {
		return Valor1;
	}

	public void setValor1(Double valor1) {
		Valor1 = valor1;
	}
	
	public String getProdutos() {
		return produtos;
	}

	public void setProdutos(String produtos) {
		this.produtos = produtos;
	}
	
	
	
	
// O método "gravarBanco", "ExcluirBanco" e "EditarBanco" estão recebendo os métodos vindos da classe "comandosBean".
// O "d" representa o objeto "despesa"
	
	public void gravarBanco(Despesas d) {
		comandosBean.inserir(d);
		
	}
	
	public void ExcluirBanco(Despesas d) {
		comandosBean.excluir(d);
		
	}
	public void EditarBanco(Despesas d) {
		comandosBean.atualizar(d);
		
	}
	
	
	
	public String inserir(String data,String desc,Double Valor) {
		
		
		// Criando uma instância com a classe "Despesas" com os parâmetros data, desc e valor que receberão as informações
		
		Despesas d = new Despesas(data,desc,Valor);
		d.setEdit(true);
		
		a =true;
		
		// Adicionando as informações na lista
		
		despesas.add(d);
		data1 = null;
		desc1 = null;
		Valor1= null;
		
		// Responsável por enviar as informações no banco de dados
		
		gravarBanco(d);
		
		return null;

	}
	
	// Exclui as despesas da lista e banco
	
	public String excluir(Despesas despesa) {
		despesas.remove(despesa);
		ExcluirBanco(despesa);
		return null;
	}
	
	// Ao receber true, será possível editar as informações que já foram inseridas
	public String editar(Despesas despesa) {
		// Informando que a variável "edit" será true, o que significa que o usuário poderá editar as suas informações
		despesa.setEdit(true); 
		EditarBanco(despesa);
		return null;
	}
	
	
	public String gravar (Despesas despesa) {
		despesa.setEdit(false);
		//Validando se já existe ou não um objeto
		//Caso não existir= inserir um novo objeto
		//Caso existir= Atualizar os dados do objeto
		if(despesa.getId()==null) {
			comandosBean.inserir(despesa);
		}else {
			comandosBean.atualizar(despesa);
		}
		return null;
	}
	
	public List<Despesas> getDespesas() {
		
		return despesas;
	}
	
	// Responsável por fazer a validação da existência de um objeto
	// Caso contrário será inserido um novo objeto
	
	public Despesas getDespesas1() {
		
		if(despesas1==null) {
			despesas1 = new Despesas();
		}
		return despesas1;
	}

	public Boolean getA() {
		return a;
	}

	public void setA(Boolean a) {
		this.a = a;
	}

	// Faz a validação de login e senha 
	public String doLogin() {
		//Fazendo a validação no login e senha
		if("abc".equals(user) && "123".equals(senha)) {
			return "despesas";	
		}
		return null;
	}
	
}
