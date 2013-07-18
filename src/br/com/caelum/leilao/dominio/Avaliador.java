package br.com.caelum.leilao.dominio;

public class Avaliador {

	double maiorDeTodos = Double.NEGATIVE_INFINITY;
	double menorDeTodos = Double.POSITIVE_INFINITY;

	public void avalia(Leilao leilao) {

		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() > maiorDeTodos)
				maiorDeTodos = lance.getValor();
			if (lance.getValor() < menorDeTodos)
				menorDeTodos = lance.getValor();
		}

	}

	public double getMaiorDeTodos() {
		return maiorDeTodos;
	}

	public double getMenorDeTodos() {
		return menorDeTodos;
	}

	public Double getMediaLances(Leilao leilao) {

		int i = 0;
		double soma = 0;

		for (Lance lance : leilao.getLances()) {
			soma += lance.getValor();
			i++;
		}
		return soma / i;
	}

}
