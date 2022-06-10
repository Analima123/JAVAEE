package br.com.senai.analima.jpa.ejbbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.analima.model.Tarefa;


// Utilizar Stateless quando não há necessidade de manter o estado dos valores
@Stateless


public class TarefaBean {
	
// Recurso responsável por realizar as operações de sincronismo com o banco de dados (inserir, remover, atualizar ou consultar - CRUD) e gerenciar o ciclo de vida das entidades.
// Quando uma inserção no banco de dados é realizada, o EntityManager será o responsável
	
	@PersistenceContext
	
	
	private EntityManager em;
	
	//Persist insere as tarefas no banco de dados
	public void inserir(Tarefa tarefa) {
		em.persist(tarefa);
	}
	// Merge sobrescreve os dados de "tarefa"
	public void atualizar(Tarefa tarefa) {
		em.merge(tarefa);
	}
	// Exclui os dados de "tarefa"
	public void excluir(Tarefa tarefa) {
		tarefa = carregar(tarefa.getId());
		em.remove(tarefa);
	}
	// Carrega as tarefas e logo depois as procura pelo ID
	public Tarefa carregar(int id) {
		//find procura o valor
		return em.find(Tarefa.class, id);
	}
}
