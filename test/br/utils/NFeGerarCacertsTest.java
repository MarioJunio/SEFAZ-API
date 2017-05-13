package br.utils;

import org.junit.Test;

import br.com.nc.config.NFeCacerts;
import br.com.nc.model.NFAmbiente;

public class NFeGerarCacertsTest {

	@Test
	public void gerarCacerts() {
		NFeCacerts.gerar(NFAmbiente.PRODUCAO);
	}
}
