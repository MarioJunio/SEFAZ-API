package br.com.nc.services.sefaz.nfe;

import javax.xml.bind.JAXBException;

public abstract class Service {

	protected String getCabecalhoXML() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	}

	public String montarXmlRequisicao(String xml) {

		StringBuilder sb = new StringBuilder();
		sb.append(getCabecalhoXML());
		sb.append(xml.replaceAll(":ns2|ns2:|xmlns:ns3=\"http://www.w3.org/2000/09/xmldsig#\"", ""));

		return sb.toString();
	}

	public abstract String criarXMLRequisicao() throws Exception;

	public abstract Object parseXMLRetorno(String xmlRetorno) throws JAXBException;

	public abstract Object enviar() throws Exception;

	public abstract Object enviar(String xml) throws Exception;
}
