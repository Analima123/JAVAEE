package br.com.senai.analima.application.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


// As classes Java que representam os dados a serem armazenados no SGBD são chamadas de Entidades (Entity).
@Entity


// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class Pedido implements Serializable {

	// Primary key da tabela
	@Id
	
	// JPA passará a utilizar a geração de chave primária do banco de dados ao qual a aplicação está conectada.
	@GeneratedValue
	private Integer id;
	
	// Definir nome da coluna
	@Column(name = "valor_total")
	private Double valorTotal;
	
	
	// No JPA, a anotação @Temporal resolve um dos principais problemas de converter os valores de data e hora do objeto Java para o tipo de banco de dados compatível e recuperar de volta para o aplicativo.
	// Armazenar apenas o valor da data (não a hora) na coluna da tabela do banco de dados.
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date data;

	// Relacionamento de cardinalidade um para um
	@OneToOne
	@JoinColumn(name = "pagamento_id")
	private Pagamento pagamento;
	
	// Relacionamento de cardinalidade muitos para um
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	// Relacionamento de cardinalidade muitos para muitos
	
	// EAGER --> É imediato (ou seja, antes de nossa exigência chegar, estamos buscando desnecessariamente o registro)
	// ---- EXEMPLO --- > Portanto, se você tem "Course" e tem "List<Student>", todos os alunos são buscados no banco de dados no momento em que "Course" são buscados.
	@ManyToMany(fetch = FetchType.EAGER)
	
	// Junção das tabelas pedido e produto, pegando a coluna referência 
	@JoinTable(name = "pedido_produto", 
		joinColumns = @JoinColumn(name = "pedido_id"),
		inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produto> produtos = new ArrayList<Produto>();

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", valorTotal=" + valorTotal + ", data="
				+ data + "]";
	}
}
