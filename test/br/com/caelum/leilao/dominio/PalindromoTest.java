package br.com.caelum.leilao.dominio;

import org.junit.Assert;
import org.junit.Test;

public class PalindromoTest {

	@Test
	public void TestaPalindromo() {
		String fraseCorreta = "Anotaram a data da maratona";
		String fraseErrada = "Anotaram a hora da maratona";

		Palindromo palindromo = new Palindromo();

		boolean resultadoBom = palindromo.ehPalindromo(fraseCorreta);
		boolean resultadoRuim = palindromo.ehPalindromo(fraseErrada);

		Assert.assertTrue(resultadoBom);
		Assert.assertFalse(resultadoRuim);
	}
}
