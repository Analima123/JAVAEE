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


@Stateless
public class PedidoBean {

	@PersistenceContext
	private EntityManager em;
	
	public List<Pedido> listar() {
		return em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
	}
	
	public void pagar(Integer pedidoId, String tipo) {
		TipoPagamento tipoPagamento = TipoPagamento.valueOf(tipo);
		Pedido pedido = em.find(Pedido.class, pedidoId);
		
		Pagamento pagamento = new Pagamento();
		pagamento.setTipoPagto(tipoPagamento);
		em.persist(pagamento);
		
		pedido.setPagamento(pagamento);
	}
	
	public void excluir(Integer pedidoId) {
		Pedido pedido = em.find(Pedido.class, pedidoId);
		em.remove(pedido);
	}
	
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

