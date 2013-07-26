package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

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

		assertEquals(10.00, avaliador.getMenorDeTodos(), 0.0001);
		assertEquals(500.00, avaliador.getMaiorDeTodos(), 0.0001);
	}

	@Test
	public void deveEntenderLeilaoComUmUnicoLance() {

		Usuario usuario = new Usuario("André");
		Leilao leilao = new Leilao("Carro do Flaiton");
		leilao.propoe(new Lance(usuario, 200.00));

		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);

		assertEquals(200.00, avaliador.getMaiorDeTodos(), 0.0001);
		assertEquals(200.00, avaliador.getMenorDeTodos(), 0.0001);

	}

	@Test
	public void deveEntenderLeilaoComValoresAleatorios() {
		Usuario usuario = new Usuario("Deadpool");
		Leilao leilao = new Leilao("chimichangas");
		leilao.propoe(new Lance(usuario, 200.00));
		leilao.propoe(new Lance(usuario, 450.00));
		leilao.propoe(new Lance(usuario, 120.00));
		leilao.propoe(new Lance(usuario, 700.00));
		leilao.propoe(new Lance(usuario, 630.00));
		leilao.propoe(new Lance(usuario, 230.00));

		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);

		assertEquals(120.00, avaliador.getMenorDeTodos(), 0.0001);
		assertEquals(700.00, avaliador.getMaiorDeTodos(), 0.0001);
	}
}
