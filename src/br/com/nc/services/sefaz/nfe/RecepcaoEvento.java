package br.com.nc.services.sefaz.nfe;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import br.com.nc.entity.sefaz.nfe.recepcaoevento.TEnvEvento;
import br.com.nc.entity.sefaz.nfe.recepcaoevento.TEvento;
import br.com.nc.entity.sefaz.nfe.recepcaoevento.TEvento.InfEvento;
import br.com.nc.entity.sefaz.nfe.recepcaoevento.TEvento.InfEvento.DetEvento;
import br.com.nc.entity.sefaz.nfe.recepcaoevento.TRetEnvEvento;
import br.com.nc.model.NFAmbiente;
import br.com.nc.model.ResNFeManifestDest;
import br.com.nc.model.SefazWsUrl;
import br.com.nc.model.TipoEventoManifestDest;
import br.com.nc.stubs.recepcaoevento.RecepcaoEventoStub;
import br.com.nc.stubs.recepcaoevento.RecepcaoEventoStub.NfeRecepcaoEventoResult;
import br.com.nc.utils.Dates;
import br.com.nc.utils.Utils;

public class RecepcaoEvento extends Service {

	private final String VERSAO = "1.00";

	private NFAmbiente ambiente;
	private String cOrgao;
	private String cnpj;
	private List<ResNFeManifestDest> listNFe;
	
	public RecepcaoEvento(NFAmbiente ambiente, String cOrgao) {
		this.ambiente = ambiente;
		this.cOrgao = cOrgao;
	}
	
	// Criado para testes
	public RecepcaoEvento(NFAmbiente ambiente, String cOrgao, String cnpj, ResNFeManifestDest chNFeManifestDest) {
		this.ambiente = ambiente;
		this.cOrgao = cOrgao;
		this.cnpj = cnpj;
		listNFe = new ArrayList<>();
		listNFe.add(chNFeManifestDest);
	}

	// Criado para testes
	public RecepcaoEvento(NFAmbiente ambiente, String cOrgao, String cnpj, List<ResNFeManifestDest> listChNFeManifestDest) {
		this.ambiente = ambiente;
		this.cOrgao = cOrgao;
		this.cnpj = cnpj;
		listNFe = listChNFeManifestDest;
	}
	
	public static RecepcaoEvento getInstance(NFAmbiente ambiente, String cOrgao) {
		return new RecepcaoEvento(ambiente, cOrgao);
	}
	
	public static RecepcaoEvento getInstance(NFAmbiente ambiente, String cOrgao, String cnpj, ResNFeManifestDest chNFeManifestDest) {
		return new RecepcaoEvento(ambiente, cOrgao, cnpj, chNFeManifestDest);
	}

	public static RecepcaoEvento getInstance(NFAmbiente ambiente, String cOrgao, String cnpj, List<ResNFeManifestDest> listNFe) {
		return new RecepcaoEvento(ambiente, cOrgao, cnpj, listNFe);
	}

	@Override
	public String criarXMLRequisicao() throws Exception {

		TEnvEvento envEvento = new TEnvEvento();
		envEvento.setVersao(VERSAO);
		envEvento.setIdLote("1");
		// envEvento.getEvento().add(evento);

		for (ResNFeManifestDest chNFe : listNFe) {

			DetEvento detEvento = new DetEvento();
			detEvento.setVersao(VERSAO);

			// verifica qual o tipo de evento
			if (chNFe.getTipoEvento() == TipoEventoManifestDest.ConfirmacaoDaOperacao)
				detEvento.setDescEvento("Confirmacao da Operacao");
			else if (chNFe.getTipoEvento() == TipoEventoManifestDest.CienciaDaOperacao)
				detEvento.setDescEvento("Ciencia da Operacao");
			else if (chNFe.getTipoEvento() == TipoEventoManifestDest.DesconhecimentoDaOperacao)
				detEvento.setDescEvento("Desconhecimento da Operacao");
			else if (chNFe.getTipoEvento() == TipoEventoManifestDest.OperacaoNaoRealizada)
				detEvento.setDescEvento("Operacao nao Realizada");
			else
				throw new Exception("Tipo de evento: " + chNFe.getTipoEvento().name() + " não é valido!");

			// verifica se a justificativa foi informada em evento: Operacao nao Realizada
			if (chNFe.getTipoEvento() == TipoEventoManifestDest.OperacaoNaoRealizada) {

				if (!Utils.isEmpty(chNFe.getxJust()))
					detEvento.setXJust(chNFe.getxJust());
				else
					throw new Exception("Para o evento: Operação não Realizada, deve ser informado a justificativa!");
			}

			InfEvento infEvento = new InfEvento();

			// '91' para ambiente nacional
			infEvento.setCOrgao(cOrgao);
			infEvento.setTpAmb(ambiente.getCodigo());
			infEvento.setCNPJ(cnpj);
			infEvento.setChNFe(chNFe.getChNFe());
			infEvento.setDhEvento(Dates.formatDateUTC(new Date()));
			infEvento.setTpEvento(chNFe.getTipoEvento().getCodigo());
			infEvento.setNSeqEvento("1");
			infEvento.setVerEvento(VERSAO);
			infEvento.setId("ID" + infEvento.getTpEvento() + infEvento.getChNFe() + "0" + infEvento.getNSeqEvento());
			infEvento.setDetEvento(detEvento);

			TEvento evento = new TEvento();
			evento.setVersao(VERSAO);
			evento.setInfEvento(infEvento);

			envEvento.getEvento().add(evento);
		}

		JAXBContext jaxbContext = JAXBContext.newInstance("br.com.nc.entity.sefaz.nfe.recepcaoevento");
		Marshaller marshaller = jaxbContext.createMarshaller();

		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);

		StringWriter sw = new StringWriter();
		marshaller.marshal(envEvento, sw);

		return montarXmlRequisicao(sw.toString());
	}

	@Override
	public TRetEnvEvento parseXMLRetorno(String xmlRetorno) throws JAXBException {

		xmlRetorno = xmlRetorno.replaceAll(" xmlns=\"http://www.portalfiscal.inf.br/nfe\"", "");

		// cria contexto do JAXB, define o pacote onde está o factory do bean que representa o xml de resposta
		JAXBContext context = JAXBContext.newInstance("br.com.nc.entity.sefaz.nfe.recepcaoevento");
		Unmarshaller unmarshaller = context.createUnmarshaller();

		TRetEnvEvento retEnvEvento = (TRetEnvEvento) unmarshaller.unmarshal(new StringReader(xmlRetorno));

		// retorna o bean de resposta
		return retEnvEvento;
	}

	@Override
	public Object enviar() throws Exception {
		// TODO: Não implementado, pois é utilizado xml assinado pelo certificado digital
		return null;
	}

	@Override
	public String enviar(String xml) throws Exception {

		URL url = new URL(SefazWsUrl.AN.getRecepcaoEvento(ambiente));

		OMElement ome = AXIOMUtil.stringToOM(xml);

		RecepcaoEventoStub.NfeDadosMsg dadosMsg = new RecepcaoEventoStub.NfeDadosMsg();
		dadosMsg.setExtraElement(ome);

		RecepcaoEventoStub.NfeCabecMsg cabecMsg = new RecepcaoEventoStub.NfeCabecMsg();
		cabecMsg.setCUF(cOrgao);
		cabecMsg.setVersaoDados(this.VERSAO);

		RecepcaoEventoStub.NfeCabecMsgE cabecMsgE = new RecepcaoEventoStub.NfeCabecMsgE();
		cabecMsgE.setNfeCabecMsg(cabecMsg);

		RecepcaoEventoStub stub = new RecepcaoEventoStub(url.toString());
		NfeRecepcaoEventoResult nfeRecepcaoEvento = stub.nfeRecepcaoEvento(dadosMsg, cabecMsgE);

		return nfeRecepcaoEvento.getExtraElement().toString();
	}

}
