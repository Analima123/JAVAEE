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


@Named("cadastro")
@SessionScoped
public class CadastroBean implements Serializable {

	private Pessoa pessoa;

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

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Estado> getEstados() {
		return Lista.ESTADOS;
	}

	public List<Interesse> getInteresses() {
		return Lista.INTERESSES;
	}
}