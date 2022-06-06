package br.com.senai.analima.model;

public class Estado {
	
	private String sigla;
	private String estado;
	
	public Estado() {

	}
		
	
	public Estado(String sigla, String estado) {
		super();
		this.sigla = sigla;
		this.estado = estado;
		
		
		
	}
	
	
	

		
		
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
	
	
