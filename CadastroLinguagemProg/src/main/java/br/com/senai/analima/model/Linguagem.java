package br.com.senai.analima.model;


public class Linguagem {	
	
	private Integer id;
	private String nome;
	
// Uma constante é a alocação de uma espaço na memória para guardar um valor durante toda a execução de um programa ou então, durante a execução de um determinado Bloco de Instrução.
// A diferença entre CONSTANTE e VARIÁVEL, é que em nenhum momento a constante pode sofrer alteração de valor durante o seu tempo de execução
// Deve ser chamada com todas as letras MAIÚSCULAS, como no exemplo abaixo 
// Uma classe com o modificador "final" não pode ser estendida,não pode ter classes que herdam dela.
// [Nº] Representa a posição 
	
	public static final Linguagem[] LINGUAGENS;
	
	static {
		LINGUAGENS = new Linguagem[5];
		LINGUAGENS[0] = new Linguagem(1, "Java");
		LINGUAGENS[1] = new Linguagem(2, "IOS");
		LINGUAGENS[2] = new Linguagem(3, "C++");
		LINGUAGENS[3] = new Linguagem(4, "C#");
		LINGUAGENS[4] = new Linguagem(5, "PHP");		
	}

	public Linguagem(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
