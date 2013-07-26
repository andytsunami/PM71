package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatematicaMalucaTest {
	
	@Test
	public void deveTestarConta(){
		MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
		
		assertEquals(33, matematicaMaluca.contaMaluca(11));
		assertEquals(160, matematicaMaluca.contaMaluca(40));
		assertEquals(10, matematicaMaluca.contaMaluca(5));
		assertEquals(90, matematicaMaluca.contaMaluca(30));
		assertEquals(20, matematicaMaluca.contaMaluca(10));
		
	}

}
