package br.com.caelum.leilao.dominio;

import org.junit.Assert;
import org.junit.Test;

public class MediaLancesTest {

	@Test
	public void deveTrazerMedia() {

		Leilao leilao = new Leilao("Media");
		Usuario usuario = new Usuario("Maria");

		leilao.propoe(new Lance(usuario, 100.00));
		leilao.propoe(new Lance(usuario, 500.00));
		leilao.propoe(new Lance(usuario, 50.00));

		Avaliador avaliador = new Avaliador();
		Double media = avaliador.getMediaLances(leilao);

		Assert.assertEquals(216.666, media, 0.001);

	}

}
