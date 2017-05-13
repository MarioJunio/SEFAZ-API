package br.com.nc.services.sefaz.nfe;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import br.com.nc.entity.sefaz.nfe.consstatserv.ObjectFactory;
import br.com.nc.entity.sefaz.nfe.consstatserv.TConsStatServ;
import br.com.nc.entity.sefaz.nfe.consstatserv.TRetConsStatServ;
import br.com.nc.model.NFAmbiente;
import br.com.nc.model.SefazWsUrl;
import br.com.nc.stubs.nfestatusservico2.NfeStatusServico2Stub;
import br.com.nc.stubs.nfestatusservico2.NfeStatusServico2Stub.NfeStatusServicoNF2Result;

public class ConsultaStatusServico extends Service {

	public final String VERSAO = "3.10";

	private NFAmbiente ambiente;
	private URL url;
	private String uf;

	private ConsultaStatusServico(NFAmbiente ambiente, URL url, String uf) {
		this.ambiente = ambiente;
		this.url = url;
		this.uf = uf;
	}

	public static ConsultaStatusServico getInstance(NFAmbiente ambiente, String uf) throws MalformedURLException {
		return new ConsultaStatusServico(ambiente, new URL(SefazWsUrl.valueOfCodigoUF(uf).getNfeStatusServico(ambiente)), uf);
	}

	/**
	 * Cria XML de consulta do status de serviço versão 3.10
	 * 
	 * @return XML completo para consulta do status de serviço
	 * @throws JAXBException
	 */
	public String criarXML() throws JAXBException {

		TConsStatServ consStatServ = new TConsStatServ();
		consStatServ.setCUF(this.uf);
		consStatServ.setTpAmb(this.ambiente.getCodigo());
		consStatServ.setVersao(this.VERSAO);
		consStatServ.setXServ("STATUS");

		JAXBContext context = JAXBContext.newInstance("br.com.nc.entity.sefaz.nfe.consstatserv");
		Marshaller marshaller = context.createMarshaller();
		JAXBElement<TConsStatServ> element = new ObjectFactory().createConsStatServ(consStatServ);

		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

		StringWriter sw = new StringWriter();
		marshaller.marshal(element, sw);

		StringBuilder sb = new StringBuilder();
		sb.append(getCabecalhoXML());
		sb.append(sw.toString());

		return sb.toString();
	}

	@Override
	public TRetConsStatServ enviar() throws Exception {

		try {

			String xmlRequisicao = criarXML();

			// transforma XML em um objeto que representa o XML, para ser manipulado pelo Axis2
			OMElement ome = AXIOMUtil.stringToOM(xmlRequisicao);

			// corpo da mensagem
			NfeStatusServico2Stub.NfeDadosMsg dadosMsg = new NfeStatusServico2Stub.NfeDadosMsg();
			dadosMsg.setExtraElement(ome);

			// cabeçalho da mensagem
			NfeStatusServico2Stub.NfeCabecMsg nfeCabecMsg = new NfeStatusServico2Stub.NfeCabecMsg();
			nfeCabecMsg.setCUF(this.uf);
			nfeCabecMsg.setVersaoDados(this.VERSAO);

			// seta cabeçalho da mensagem
			NfeStatusServico2Stub.NfeCabecMsgE nfeCabecMsgE = new NfeStatusServico2Stub.NfeCabecMsgE();
			nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);

			// cria stub para o serviço de status do serviço
			NfeStatusServico2Stub stub = new NfeStatusServico2Stub(url.toString());

			// envia requisição para o webservice, usando o corpo da mensagem e o cabeçalho criados anteriormente
			NfeStatusServicoNF2Result nfeStatusServicoNF2 = stub.nfeStatusServicoNF2(dadosMsg, nfeCabecMsgE);

			// obtem a resposta do webservice
			String xmlRetornado = nfeStatusServicoNF2.getExtraElement().toString();

			return parseXMLRetorno(xmlRetornado);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String criarXMLRequisicao() throws JAXBException {

		TConsStatServ consStatServ = new TConsStatServ();
		consStatServ.setCUF(this.uf);
		consStatServ.setTpAmb(this.ambiente.getCodigo());
		consStatServ.setVersao(this.VERSAO);
		consStatServ.setXServ("STATUS");

		JAXBContext context = JAXBContext.newInstance("br.com.nc.entity.sefaz.nfe.consstatserv");
		Marshaller marshaller = context.createMarshaller();
		JAXBElement<TConsStatServ> element = new ObjectFactory().createConsStatServ(consStatServ);

		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

		StringWriter sw = new StringWriter();
		marshaller.marshal(element, sw);

		StringBuilder sb = new StringBuilder();
		sb.append(getCabecalhoXML());
		sb.append(sw.toString());

		return sb.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public TRetConsStatServ parseXMLRetorno(String xmlRetorno) throws JAXBException {

		// cria contexto do JAXB, define o pacote onde está o factory do bean que representa o xml de resposta
		JAXBContext context = JAXBContext.newInstance("br.com.nc.entity.sefaz.nfe.consstatserv");
		Unmarshaller unmarshaller = context.createUnmarshaller();

		// realizar o unmarshaller, ou seja, transforma xml em um bean
		JAXBElement<TRetConsStatServ> element = (JAXBElement<TRetConsStatServ>) unmarshaller.unmarshal(new StringReader(xmlRetorno));

		// retorna o bean de resposta
		return element.getValue();
	}

	@Override
	public String enviar(String xml) throws Exception {
		
		// transforma XML em um objeto que representa o XML, para ser manipulado pelo Axis2
		OMElement ome = AXIOMUtil.stringToOM(xml);

		// corpo da mensagem
		NfeStatusServico2Stub.NfeDadosMsg dadosMsg = new NfeStatusServico2Stub.NfeDadosMsg();
		dadosMsg.setExtraElement(ome);

		// cabeçalho da mensagem
		NfeStatusServico2Stub.NfeCabecMsg nfeCabecMsg = new NfeStatusServico2Stub.NfeCabecMsg();
		nfeCabecMsg.setCUF(this.uf);
		nfeCabecMsg.setVersaoDados(this.VERSAO);

		// seta cabeçalho da mensagem
		NfeStatusServico2Stub.NfeCabecMsgE nfeCabecMsgE = new NfeStatusServico2Stub.NfeCabecMsgE();
		nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);

		// cria stub para o serviço de status do serviço
		NfeStatusServico2Stub stub = new NfeStatusServico2Stub(url.toString());

		// envia requisição para o webservice, usando o corpo da mensagem e o cabeçalho criados anteriormente
		NfeStatusServicoNF2Result nfeStatusServicoNF2 = stub.nfeStatusServicoNF2(dadosMsg, nfeCabecMsgE);

		// obtem a resposta do webservice
		return nfeStatusServicoNF2.getExtraElement().toString();
	}
}
