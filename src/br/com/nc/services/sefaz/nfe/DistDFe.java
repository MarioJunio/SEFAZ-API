package br.com.nc.services.sefaz.nfe;

import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import br.com.nc.entity.sefaz.nfe.nfedistdfe.ResNFe;
import br.com.nc.entity.sefaz.nfe.nfedistdfe.RetDistDFeInt;
import br.com.nc.entity.sefaz.nfe.nfedistdfe.TNfeProc;
import br.com.nc.model.NFAmbiente;
import br.com.nc.model.SefazWsUrl;
import br.com.nc.stubs.nfedistribuicaodfe.NFeDistribuicaoDFeStub;
import br.com.nc.stubs.nfedistribuicaodfe.NFeDistribuicaoDFeStub.NfeDistDFeInteresseResponse;
import br.com.nc.utils.GzipUtils;

public class DistDFe extends Service {

	private URL url;

	private DistDFe(URL url) {
		this.url = url;
	}

	public static DistDFe getInstance(NFAmbiente ambiente) throws MalformedURLException {
		return new DistDFe(new URL(SefazWsUrl.AN.getNFeDistribuicaoDFe(ambiente)));
	}

	@Override
	public String criarXMLRequisicao() throws JAXBException {
		// TODO: Não foi criado teste unitário
		return null;
	}

	@Override
	public RetDistDFeInt parseXMLRetorno(String xmlRetorno) throws JAXBException {

		xmlRetorno = xmlRetorno.replace("xmlns=\"http://www.portalfiscal.inf.br/nfe\"", "");

		// cria contexto do JAXB, define o pacote onde está o factory do bean que representa o xml de resposta
		JAXBContext context = JAXBContext.newInstance(RetDistDFeInt.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		// realizar o unmarshaller, ou seja, transforma xml em um bean
		RetDistDFeInt retDistDFeInt = (RetDistDFeInt) unmarshaller.unmarshal(new StringReader(xmlRetorno));

		// retorna o bean de resposta
		return retDistDFeInt;
	}

	public TNfeProc parseProcNFe(String xml) throws JAXBException {

		// cria contexto do JAXB, define o pacote onde está o factory do bean que representa o xml de resposta
		JAXBContext context = JAXBContext.newInstance("br.com.nc.entity.sefaz.nfe.nfedistdfe");
		Unmarshaller unmarshaller = context.createUnmarshaller();

		// realizar o unmarshaller, ou seja, transforma xml em um bean
		@SuppressWarnings("unchecked")
		JAXBElement<TNfeProc> jaxbNFeProc = (JAXBElement<TNfeProc>) unmarshaller.unmarshal(new StringReader(xml));

		// retorna o bean de resposta
		return jaxbNFeProc.getValue();
	}
	
	public ResNFe parseResNFe(String xml) throws JAXBException {

		// cria contexto do JAXB, define o pacote onde está o factory do bean que representa o xml de resposta
		JAXBContext context = JAXBContext.newInstance("br.com.nc.entity.sefaz.nfe.nfedistdfe");
		Unmarshaller unmarshaller = context.createUnmarshaller();

		// realizar o unmarshaller, ou seja, transforma xml em um bean
		ResNFe resNFe = (ResNFe) unmarshaller.unmarshal(new StringReader(xml));

		// retorna o bean de resposta
		return resNFe;
	}
	
	
	@Override
	public RetDistDFeInt enviar() throws Exception {

		String xmlRequisicao = criarXMLRequisicao();

		OMElement ome = AXIOMUtil.stringToOM(xmlRequisicao);

		NFeDistribuicaoDFeStub.NfeDadosMsg_type0 dadosMsg = new NFeDistribuicaoDFeStub.NfeDadosMsg_type0();
		dadosMsg.setExtraElement(ome);

		NFeDistribuicaoDFeStub.NfeDistDFeInteresse nfeDistDFeInteresse = new NFeDistribuicaoDFeStub.NfeDistDFeInteresse();
		nfeDistDFeInteresse.setNfeDadosMsg(dadosMsg);

		NFeDistribuicaoDFeStub stub = new NFeDistribuicaoDFeStub(url.toString());
		NfeDistDFeInteresseResponse response = stub.nfeDistDFeInteresse(nfeDistDFeInteresse);

		return parseXMLRetorno(response.getNfeDistDFeInteresseResult().getExtraElement().toString());
	}

	@Override
	public Object enviar(String xml) throws Exception {

		OMElement ome = AXIOMUtil.stringToOM(xml);

		NFeDistribuicaoDFeStub.NfeDadosMsg_type0 dadosMsg = new NFeDistribuicaoDFeStub.NfeDadosMsg_type0();
		dadosMsg.setExtraElement(ome);

		NFeDistribuicaoDFeStub.NfeDistDFeInteresse nfeDistDFeInteresse = new NFeDistribuicaoDFeStub.NfeDistDFeInteresse();
		nfeDistDFeInteresse.setNfeDadosMsg(dadosMsg);

		NFeDistribuicaoDFeStub stub = new NFeDistribuicaoDFeStub(url.toString());
		NfeDistDFeInteresseResponse response = stub.nfeDistDFeInteresse(nfeDistDFeInteresse);

		return response.getNfeDistDFeInteresseResult().getExtraElement().toString();
	}

	public String unzip(byte[] xmlB64Ziped) throws Exception {

		// descompacta os bytes, e retorna o texto claro
		return GzipUtils.decompress(xmlB64Ziped);
	}

}
