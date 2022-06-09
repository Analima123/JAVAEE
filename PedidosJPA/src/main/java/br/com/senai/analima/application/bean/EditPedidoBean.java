package br.com.senai.analima.application.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.senai.analima.application.ejb.ClienteBean;
import br.com.senai.analima.application.ejb.PedidoBean;
import br.com.senai.analima.application.ejb.ProdutoBean;
import br.com.senai.analima.application.model.Cliente;
import br.com.senai.analima.application.model.Produto;

// Define o nome que o BEAN será chamado na página XHTML
@Named

// Define o tempo de vida do ESCOPO, no caso o REQUESTSCOPED ficará "vivo" durante a requisição HTTP, ou seja, após a mostra do resultado,tudo será excluido e será gerada uma nova requisição caso a página seja acionada novamente.
@RequestScoped


// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class EditPedidoBean implements Serializable {
	
//Lógica de negócios	
//EJB é um framework do Java EE. Eles são executados em um container EJB no lado do servidor. A principal característica do EJB é a rapidez em desenvolver soluções, pois, ele fornece um conjunto de componentes prontos, o que torna o desenvolvimento eficiente.
	@EJB
	private PedidoBean pedidoBean;
	
	@EJB
	private ProdutoBean produtoBean;
	
	@EJB
	private ClienteBean clienteBean;
	
	private List<Cliente> clientes;
	private List<Produto> produtos;
	
	private Integer selectedClienteId;
	private Integer[] selectedProdutosIds;
	
	
	// No @PostConstruct método, o bean é totalmente inicializado e você pode usar as dependências.
	// Precisa ser executado após a injeção de dependência ser executada para executar qualquer inicialização.
	@PostConstruct
	public void init() {
		clientes = clienteBean.listar();
		produtos = produtoBean.listar();
	}
	
	public String cadastrarPedido() throws Exception {
		pedidoBean.cadastrar(selectedClienteId, selectedProdutosIds);	
		return "pedidos?faces-redirect=true";
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Integer getSelectedClienteId() {
		return selectedClienteId;
	}

	public void setSelectedClienteId(Integer selectedClienteId) {
		this.selectedClienteId = selectedClienteId;
	}

	public Integer[] getSelectedProdutosIds() {
		return selectedProdutosIds;
	}

	public void setSelectedProdutosIds(Integer[] selectedProdutosIds) {
		this.selectedProdutosIds = selectedProdutosIds;
	}
}
