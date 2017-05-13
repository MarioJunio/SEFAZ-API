package br.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.nc.entity.sefaz.nfe.recepcaoevento.TRetEnvEvento;
import br.com.nc.model.ResNFeManifestDest;
import br.com.nc.model.NFAmbiente;
import br.com.nc.model.TipoEventoManifestDest;
import br.com.nc.model.UF;
import br.com.nc.security.Assinatura;
import br.com.nc.security.SSL;
import br.com.nc.services.sefaz.nfe.RecepcaoEvento;

public class NFeRecepcaoEventoTest {

	@Test
	public void enviarManifestDest() throws Exception {

		String certAlias = "HP LOGISTICA LTDA ME:15107846000100";
		NFAmbiente ambiente = NFAmbiente.HOMOLOGACAO;
		String cnpj = "15107846000100";

		List<ResNFeManifestDest> listNFeManifestDest = new ArrayList<>();
		ResNFeManifestDest nfe1 = new ResNFeManifestDest("31170422065841000110550020000004286000005514", TipoEventoManifestDest.ConfirmacaoDaOperacao, null);
		ResNFeManifestDest nfe2 = new ResNFeManifestDest("31170422065841000110550020000004226000005456", TipoEventoManifestDest.ConfirmacaoDaOperacao, null);

		listNFeManifestDest.add(nfe1);
		listNFeManifestDest.add(nfe2);

		RecepcaoEvento manifestDestTest = RecepcaoEvento.getInstance(ambiente, UF.AN.getCodigo(), cnpj, listNFeManifestDest);
		String xml = manifestDestTest.criarXMLRequisicao();

		Assinatura assinatura = Assinatura.getInstance(certAlias);
		String xmlAssinado = assinatura.assinarInfEvento(xml);

		System.out.println(xmlAssinado);
		
		SSL.apply(certAlias);
		String retXml = (String) manifestDestTest.enviar(xmlAssinado);

		TRetEnvEvento retEnvEvento = manifestDestTest.parseXMLRetorno(retXml);
		System.out.println(retEnvEvento.toString());

	}

}
