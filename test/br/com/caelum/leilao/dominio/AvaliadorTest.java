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

		assertEquals(5, leilao.getLances().size(), 0.0001);
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

		assertEquals(1, leilao.getLances().size(), 0.0001);
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

		assertEquals(6, leilao.getLances().size(), 0.0001);
		assertEquals(120.00, avaliador.getMenorDeTodos(), 0.0001);
		assertEquals(700.00, avaliador.getMaiorDeTodos(), 0.0001);

	}

	@Test
	public void deveEntenderEmOrdemDecrescente() {
		Usuario usuario = new Usuario("maria");
		Leilao leilao = new Leilao("Cruzeiro de navio");

		leilao.propoe(new Lance(usuario, 400));
		leilao.propoe(new Lance(usuario, 300));
		leilao.propoe(new Lance(usuario, 200));
		leilao.propoe(new Lance(usuario, 100));

		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);

		assertEquals(4, leilao.getLances().size(), 0.0001);
		assertEquals(400, avaliador.getMaiorDeTodos(), 0.0001);
		assertEquals(100, avaliador.getMenorDeTodos(), 0.0001);

	}

	@Test
	public void deveEncontrarOsTresMaiores() {
		Usuario usuario = new Usuario("André");
		Leilao leilao = new Leilao("Carro do ano");

		leilao.propoe(new Lance(usuario, 300.00));
		leilao.propoe(new Lance(usuario, 100.00));
		leilao.propoe(new Lance(usuario, 500.00));
		leilao.propoe(new Lance(usuario, 200.00));
		leilao.propoe(new Lance(usuario, 600.00));

		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);

		assertEquals(3, avaliador.getTresMaiores().size(), 0.0001);
		assertEquals(600, avaliador.getTresMaiores().get(0).getValor(), 0.0001);
		assertEquals(500, avaliador.getTresMaiores().get(1).getValor(), 0.0001);
		assertEquals(300, avaliador.getTresMaiores().get(2).getValor(), 0.0001);

	}

	@Test
	public void deveTestarComApenasDoisLances() {
		Usuario usuario = new Usuario("André");
		Leilao leilao = new Leilao("casa na praia");

		leilao.propoe(new Lance(usuario, 800.00));
		leilao.propoe(new Lance(usuario, 200.00));

		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);

		assertEquals(2, avaliador.getTresMaiores().size(), 0.0001);
		assertEquals(800.00, avaliador.getTresMaiores().get(0).getValor(), 0.0001);
		assertEquals(200.00, avaliador.getTresMaiores().get(1).getValor(), 0.0001);
		

	}
	
	@Test
	public void deveTestarComLanceVazio(){
		Leilao leilao = new Leilao("Google");
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		assertEquals(0, avaliador.getTresMaiores().size(),0.0001);
	}

}
