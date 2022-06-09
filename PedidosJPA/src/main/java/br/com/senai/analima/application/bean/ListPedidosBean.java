package br.com.senai.analima.application.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.senai.analima.application.ejb.PedidoBean;
import br.com.senai.analima.application.model.Pedido;

// Define o nome que o BEAN será chamado na página XHTML
@Named

// Define o tempo de vida do ESCOPO, no caso o REQUESTSCOPED ficará "vivo" durante a requisição HTTP, ou seja, após a mostra do resultado,tudo será excluido e será gerada uma nova requisição caso a página seja acionada novamente.
@RequestScoped


// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class ListPedidosBean implements Serializable {

	
	//Lógica de negócios	
	//EJB é um framework do Java EE. Eles são executados em um container EJB no lado do servidor. A principal característica do EJB é a rapidez em desenvolver soluções, pois, ele fornece um conjunto de componentes prontos, o que torna o desenvolvimento eficiente.
	
	@EJB
	private PedidoBean pedidoBean;
	
	private List<Pedido> pedidos;
	
	// No @PostConstruct método, o bean é totalmente inicializado e você pode usar as dependências.
	// Precisa ser executado após a injeção de dependência ser executada para executar qualquer inicialização.
	
	@PostConstruct
	public void init() {
		pedidos = pedidoBean.listar();
	}

	//Lista de pedidos
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	//Método pagar pedido
	public String pagar(Integer pedidoId, String tipo) throws Exception  {
		pedidoBean.pagar(pedidoId, tipo);
		return "pedidos?faces-redirect=true";
	}

	//Método excluir pedido
	public String excluir(Integer pedidoId) {
		pedidoBean.excluir(pedidoId);
		return "pedidos?faces-redirect=true";
	}
}
