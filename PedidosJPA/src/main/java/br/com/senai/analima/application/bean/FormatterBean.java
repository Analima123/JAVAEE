package br.com.senai.analima.application.bean;


import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

// Define o nome que o BEAN será chamado na página XHTML
@Named

// São criados apenas uma vez, e cada objeto que depende da classe compartilha a mesma instância
// Útil para compartilhar contexto em todo o aplicativo ou como otimização de desempenho
@ApplicationScoped


// A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador, sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como ele estava no momento da sua serialização.
public class FormatterBean implements Serializable {

	//Método utilizado para transformar os valores em moeda brasileira
	private static final Locale LOCALE_BR = new Locale("pt", "BR");
	
	public String formatarMoeda(double valor) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(LOCALE_BR);
		return nf.format(valor);
	}
}
