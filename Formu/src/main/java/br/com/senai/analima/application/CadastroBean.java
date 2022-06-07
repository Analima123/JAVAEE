package br.com.senai.analima.application;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.senai.analima.model.Estado;
import br.com.senai.analima.model.Interesse;
import br.com.senai.analima.listas.Lista;
import br.com.senai.analima.model.Endereco;
import br.com.senai.analima.model.Pessoa;
import br.com.senai.analima.model.Telefone;

// Define o nome que o BEAN será chamado na página XHTML, no caso o nome será "cadastro"
@Named("cadastro")

// O Escopo ficará vivo enquanto a sessão estiver viva. A sessão ficará viva enquanto o navegador não for fechado ou ao ter um time out definido
@SessionScoped

// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class CadastroBean implements Serializable {

	private Pessoa pessoa;

	// Pega os atributos do objeto pessoa, se o objeto "pessoa" ainda não existir, será criado e retornado
	public Pessoa getPessoa() {
		if (pessoa == null) {
			pessoa = new Pessoa();
			pessoa.setEnderecoResidencial(new Endereco());
			pessoa.getEnderecoResidencial().setEstado(new Estado());
			pessoa.setEnderecoComercial(new Endereco());
			pessoa.getEnderecoComercial().setEstado(new Estado());
			pessoa.setTelefoneResidencial(new Telefone());
			pessoa.setTelefoneCelular(new Telefone());
			pessoa.setTelefoneComercial(new Telefone());
		}
		return pessoa;
	}

	// Seta o objeto "pessoa" dentro de Pessoa 
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	// Pega os atributos e retorna a lista de ESTADOS
	public List<Estado> getEstados() {
		return Lista.ESTADOS;
	}
	
	// Pega os atributos e retorna a lista de INTERESSES
	public List<Interesse> getInteresses() {
		return Lista.INTERESSES;
	}
}
