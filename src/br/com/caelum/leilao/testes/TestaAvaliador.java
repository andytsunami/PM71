package br.com.caelum.leilao.testes;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class TestaAvaliador {
	public static void main(String[] args) {
		Usuario usuario = new Usuario("José");
		Leilao leilao = new Leilao("Playsation 3");

		leilao.propoe(new Lance(usuario, 100.00));
		leilao.propoe(new Lance(usuario, 500.00));
		leilao.propoe(new Lance(usuario, 200.00));
		leilao.propoe(new Lance(usuario, 10.00));
		leilao.propoe(new Lance(usuario, 300.00));

		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
	}

}
