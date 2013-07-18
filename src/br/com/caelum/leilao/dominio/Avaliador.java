package br.com.caelum.leilao.dominio;

public class Avaliador {

	double maiorDeTodos = Double.NEGATIVE_INFINITY;
	double menorDeTodos = Double.POSITIVE_INFINITY;
	double media = 0;

	public void avalia(Leilao leilao) {
		double soma = 0;

		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() > maiorDeTodos)
				maiorDeTodos = lance.getValor();
			if (lance.getValor() < menorDeTodos)
				menorDeTodos = lance.getValor();
			soma += lance.getValor();
		}
		this.media = soma / leilao.getLances().size();
	}

	public double getMaiorDeTodos() {
		return maiorDeTodos;
	}

	public double getMenorDeTodos() {
		return menorDeTodos;
	}

	public Double getMediaLances() {

		return this.media;
	}

}
