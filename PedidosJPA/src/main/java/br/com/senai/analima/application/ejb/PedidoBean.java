package br.com.senai.analima.application.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.analima.application.model.Cliente;
import br.com.senai.analima.application.model.Pagamento;
import br.com.senai.analima.application.model.Pedido;
import br.com.senai.analima.application.model.Produto;
import br.com.senai.analima.application.model.Pagamento.TipoPagamento;


// Utilizar Stateless quando não há necessidade de manter o estado dos valores
// Como a lista de produtos sempre será a mesma independete do cliente, usamos o Stateless

@Stateless

public class PedidoBean {

	
	//Recurso responsável por realizar as operações de sincronismo com o banco de dados (inserir, remover, atualizar ou consultar - CRUD) e gerenciar o ciclo de vida das entidades.
	//Quando uma inserção no banco de dados é realizada, o EntityManager será o responsável
	
	@PersistenceContext
	
	private EntityManager em;
	
	// Método listar pedidos
	// Os valores de pedido serão retirados do banco de dados
	public List<Pedido> listar() {
		return em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
	}
	
	// Método pagar
	// em.find --> Faz a procura diretamente no banco de dados
	// em.persist --> A persistência dos dados tem o objetivo de garantir que as informações serão armazenadas em um meio em que possam ser recuperadas de forma consistente

	public void pagar(Integer pedidoId, String tipo) {
		TipoPagamento tipoPagamento = TipoPagamento.valueOf(tipo);
		Pedido pedido = em.find(Pedido.class, pedidoId);
		
		Pagamento pagamento = new Pagamento();
		pagamento.setTipoPagto(tipoPagamento);
		em.persist(pagamento);
		
		pedido.setPagamento(pagamento);
	}
	
		// Método excluir
	public void excluir(Integer pedidoId) {
		Pedido pedido = em.find(Pedido.class, pedidoId);
		em.remove(pedido);
	}
	
		// Método cadastrar
	public void cadastrar(Integer clienteId, Integer[] produtosIds) throws Exception {
		Cliente cliente = em.find(Cliente.class, clienteId);
		
		Pedido pedido = new Pedido();
		pedido.setData(new Date());
		pedido.setCliente(cliente);
		em.persist(pedido);
		
		double valorTotal = 0;
		for (Integer produtoId : produtosIds) {
			Produto produto = em.find(Produto.class, produtoId);
			pedido.getProdutos().add(produto);
			valorTotal += produto.getValor();
		}
		
		pedido.setValorTotal(valorTotal);
	}
}

