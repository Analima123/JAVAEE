package br.com.senai.analima.listas;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.analima.model.Estado;
import br.com.senai.analima.model.Interesse;


public class Lista {
	
// Uma constante é a alocação de uma espaço na memória para guardar um valor durante toda a execução de um programa ou então, durante a execução de um determinado Bloco de Instrução.
// A diferença entre CONSTANTE e VARIÁVEL, é que em nenhum momento a constante pode sofrer alteração de valor durante o seu tempo de execução
// Deve ser chamada com todas as letras MAIÚSCULAS, como no exemplo abaixo 
// Uma classe com o modificador "final" não pode ser estendida,não pode ter classes que herdam dela.



	public static final List<Estado>ESTADOS;
	public static final List<Interesse>INTERESSES;
		
	static {
		
		// A constante ESTADO, recebe o objeto Estado, com os parâmetros definidos na classe Estados: SIGLA E ESTADO 
		ESTADOS = new ArrayList<>();
		ESTADOS.add(new Estado("AC","ACRE"));
		ESTADOS.add(new Estado("AL","ALAGOAS"));
		ESTADOS.add(new Estado("AP","AMAPÁ"));
		ESTADOS.add(new Estado("AM","AMAZONAS"));
		ESTADOS.add(new Estado("BA","BAHIA"));
		ESTADOS.add(new Estado("CE","CEARÁ"));
		ESTADOS.add(new Estado("DF","DISTRITO FEDERAL"));
		ESTADOS.add(new Estado("ES","ESPÍRITO SANTO"));
		ESTADOS.add(new Estado("GO","GOIÁS"));
		ESTADOS.add(new Estado("MA","MARANHÃO"));
		ESTADOS.add(new Estado("MT","MATO GROSSO"));
		ESTADOS.add(new Estado("MS","MATO GROSSO DO SUL"));
		ESTADOS.add(new Estado("MG","MINAS GERAIS"));
		ESTADOS.add(new Estado("PA","PARÁ"));
		ESTADOS.add(new Estado("PB","PARAÍBA"));
		ESTADOS.add(new Estado("PR","PARANÁ"));
		ESTADOS.add(new Estado("PE","PERNAMBUCO"));
		ESTADOS.add(new Estado("PI","PIAUÍ"));
		ESTADOS.add(new Estado("RJ","RIO DE JANEIRO"));
		ESTADOS.add(new Estado("RN","RIO GRANDE DO NORTE"));
		ESTADOS.add(new Estado("RS","RIO GRANDE DO SUL"));
		ESTADOS.add(new Estado("RO","RONDÔNIA"));
		ESTADOS.add(new Estado("RR","RORAIMA"));
		ESTADOS.add(new Estado("SC","SANTA CATARINA"));
		ESTADOS.add(new Estado("SP","SÃO PAULO"));
		ESTADOS.add(new Estado("SE","SERGIPE"));
		ESTADOS.add(new Estado("TO","TOCANTINS"));
	
		
		
	}

	

			
	static  {
		
		// A constante INTERESSES, recebe o objeto Interesse, com os parâmetros definidos na classe Interesse: ID e ÁREA
		INTERESSES = new ArrayList<>();
		INTERESSES.add(new Interesse(1,"Esportes"));
		INTERESSES.add(new Interesse(2,"Música"));
		INTERESSES.add(new Interesse(3,"Artes Marciais"));
		INTERESSES.add(new Interesse(4,"Viagens"));
		INTERESSES.add(new Interesse(5,"Cinema"));
		INTERESSES.add(new Interesse(6,"Dança"));
	
	
	}


}
