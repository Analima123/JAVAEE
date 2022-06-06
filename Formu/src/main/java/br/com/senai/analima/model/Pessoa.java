package br.com.senai.analima.model;

import java.util.Date;

public class Pessoa {
	
	private String nome;
	private String email;
	private Date dataNascimento;
	private Endereco enderecoResidencial;
	private Telefone telefoneResidencial;
	private Telefone telefoneComercial;
	private Telefone telefoneCelular;
	private String nomeEmpresa;
	private Endereco enderecoComercial;
	private String cargo;
	private Double salario;
	private Integer[] Interesses;
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Endereco getEnderecoResidencial() {
		return enderecoResidencial;
	}
	public void setEnderecoResidencial(Endereco enderecoResidencial) {
		this.enderecoResidencial = enderecoResidencial;
	}
	public Telefone getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(Telefone telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public Telefone getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(Telefone telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public Endereco getEnderecoComercial() {
		return enderecoComercial;
	}
	public void setEnderecoComercial(Endereco enderecoComercial) {
		this.enderecoComercial = enderecoComercial;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Integer[] getInteresses() {
		return Interesses;
	}
	public void setInteresses(Integer[] interesses) {
		Interesses = interesses;
	}
	public Telefone getTelefoneComercial() {
		return telefoneComercial;
	}
	public void setTelefoneComercial(Telefone telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	
	
}
