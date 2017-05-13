package br.services;

import java.rmi.RemoteException;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;

import br.com.nc.entity.sefaz.nfe.consstatserv.TRetConsStatServ;
import br.com.nc.model.NFAmbiente;
import br.com.nc.security.SSL;
import br.com.nc.services.sefaz.nfe.ConsultaStatusServico;

public class ConsultaStatusServicoTestExec {

	@Test
	public void realizarConsulta() throws Exception {

		String certificadoParaSSL = "/Users/MarioJ/Desktop/mineracao.pfx";
		String senhaCertificado = "1234";
		NFAmbiente ambiente = NFAmbiente.HOMOLOGACAO;

		final String UF_MG = "31";

		ConsultaStatusServico consultaStatusServico = ConsultaStatusServico.getInstance(ambiente, UF_MG);

		try {
			SSL.apply(certificadoParaSSL, senhaCertificado);
			TRetConsStatServ resposta = consultaStatusServico.enviar();
			System.out.println(String.format("Status: %s\nMotivo: %s\n", resposta.getCStat(), resposta.getXMotivo()));
		} catch (RemoteException | XMLStreamException e) {
			e.printStackTrace();
		}

	}
}
