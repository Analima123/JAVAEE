package br.com.senai.analima.jpa.ejbbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.analima.application.model.Despesas;

// Utilizar Stateless quando não há necessidade de manter o estado dos valores
@Stateless

public class ComandosBean {

// Recurso responsável por realizar as operações de sincronismo com o banco de dados (inserir, remover, atualizar ou consultar - CRUD) e gerenciar o ciclo de vida das entidades.
	
		@PersistenceContext
		private EntityManager em;
	
	
		
		public void inserir(Despesas despesas) {
			em.persist(despesas);
		}
		
		public void atualizar(Despesas despesas) {
			em.merge(despesas);
		}
		
		public void excluir(Despesas despesas) {
			despesas = carregar(despesas.getId());
			em.remove(despesas);
		}
		
		public Despesas carregar(int id) {
			return em.find(Despesas.class, id);
		}

	
	
}
