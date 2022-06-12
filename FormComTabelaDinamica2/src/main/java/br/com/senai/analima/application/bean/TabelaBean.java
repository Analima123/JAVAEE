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


@SuppressWarnings("serial") //tira anuncios de advert�ncia
@Named("tabela")
@SessionScoped //tempo de vida da p�gina, o "session" mant�m os dados enquanto o navegador estiver aberto
public class TabelaBean implements Serializable{
	//Criando uma Lista com todos os objetos
	private List<Despesas> despesas = new ArrayList<>();
	
	//Vari�veis que ir� receber as informa��es do formul�rio e ir� enviar para a classe "Despesas"
	private String user;
	private String senha;
	
	String data1;
	String desc1;
	Double Valor1;
	String produtos;
	//a variável "a" será uma variável que será responsável por renderizar a tabela do usuário
	//Se a variável estiver "true", significa que será renderizando na tela
	//Se a variável estiver "false", significa que não será renderizado na tela
	Boolean a = false; 
	//Está variável é responsável por verificar se já foi criado um objeto ou não
	private Despesas despesas1;
	//
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
	
	
	
//O método "gravarBanco", "ExcluirBanco" e "EditarBanco" estão recebendo os métodos que estão na classe "comandosBean".
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
		//Criando uma instância com a classe "Despesas" e mandando as informações das variáveis data1, desc1 e valor1 
		Despesas d = new Despesas(data,desc,Valor);
		d.setEdit(true);
		//Informando que a tabela será renderizada na tela
		a =true;
		//Adicionando na lista
		despesas.add(d);
		data1 = null;
		desc1 = null;
		Valor1= null;
		//Mandando as informações no Banco de Dados
		gravarBanco(d);
		
		return null;

	}
	
	public String excluir(Despesas despesa) {
		//removendo o objeto da lista 
		despesas.remove(despesa);
		//Removendo o objeto do Banco de Dados
		ExcluirBanco(despesa);
		return null;
	}
	
	public String editar(Despesas despesa) {
		//Informando que a variável "edit" será true, o que significa que o usuário poderá editar as suas informações
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
	
	public Despesas getDespesas1() {
		//Validando se já existe ou não um objeto
		//Caso não existir, fazer uma nova instância
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

	public String doLogin() {
		//Fazendo a validação no login e senha
		if("willian".equals(user) && "admin".equals(senha)) {
			return "despesas";	
		}
		return null;
	}
	
}
