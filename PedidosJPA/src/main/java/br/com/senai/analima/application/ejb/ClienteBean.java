package br.com.senai.analima.application.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.analima.application.model.Cliente;

// Utilizar Stateless quando não há necessidade de manter o estado dos valores
// Como a lista de produtos sempre será a mesma independete do cliente, usamos o Stateless
@Stateless

public class ClienteBean {

	@PersistenceContext
	
	//Recurso responsável por realizar as operações de sincronismo com o banco de dados (inserir, remover, atualizar ou consultar - CRUD) e gerenciar o ciclo de vida das entidades.
	//Quando uma inserção no banco de dados é realizada, o EntityManager será o responsável
	
	
	//Método Listar Clientes
	public List<Cliente> listar() {
		return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
	}
}
