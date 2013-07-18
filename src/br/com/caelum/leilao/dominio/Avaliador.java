package br.com.caelum.leilao.dominio;

public class Avaliador {

	public void avalia(Leilao leilao) {
		double maiorDeTodos = Double.NEGATIVE_INFINITY;
		double menorDeTodos = Double.POSITIVE_INFINITY;

		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() > maiorDeTodos)
				maiorDeTodos = lance.getValor();
			if (lance.getValor() < menorDeTodos)
				menorDeTodos = lance.getValor();
		}

		System.out.println(maiorDeTodos);
		System.out.println(menorDeTodos);

	}

}
