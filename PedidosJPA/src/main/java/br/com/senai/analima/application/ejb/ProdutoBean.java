package br.com.senai.analima.application.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.analima.application.model.Produto;


// São criados apenas uma vez, e cada objeto que depende da classe compartilha a mesma instância
// Útil para compartilhar contexto em todo o aplicativo ou como otimização de desempenho

@Stateless



public class ProdutoBean {

	// Recurso responsável por realizar as operações de sincronismo com o banco de dados (inserir, remover, atualizar ou consultar - CRUD) e gerenciar o ciclo de vida das entidades.
	// Quando uma inserção no banco de dados é realizada, o EntityManager será o responsável
	@PersistenceContext
	private EntityManager em;
	
	public List<Produto> listar() {
		return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
	}
}
