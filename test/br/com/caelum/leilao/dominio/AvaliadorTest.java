package br.com.caelum.leilao.dominio;

import org.junit.Assert;
import org.junit.Test;

public class AvaliadorTest {
	@Test
	public void ordemCrescenteTest() {
		Usuario usuario = new Usuario("José");
		Leilao leilao = new Leilao("Playsation 3");

		leilao.propoe(new Lance(usuario, 100.00));
		leilao.propoe(new Lance(usuario, 500.00));
		leilao.propoe(new Lance(usuario, 200.00));
		leilao.propoe(new Lance(usuario, 10.00));
		leilao.propoe(new Lance(usuario, 300.00));

		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);

		Assert.assertEquals(10.00, avaliador.getMenorDeTodos(), 0.0001);
		Assert.assertEquals(500.00, avaliador.getMaiorDeTodos(), 0.0001);
	}
}