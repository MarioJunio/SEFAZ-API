package br.com.nc.security;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.nc.model.CertificateDetails;
import br.com.nc.security.Certificados.Tipo;

public class Assinatura {

	private static final String TAG_EVENTO = "evento";
	private static final String TAG_INFEVENTO = "infEvento";
	private static final String TAG_INFINUT = "infInut";
	private static final String TAG_INFCANC = "infCanc";
	private static final String TAG_NFE = "NFe";
	private static final String TAG_INFNFE = "infNFe";

	X509Certificate certificate;
	private PrivateKey privateKey;
	private KeyInfo keyInfo;

	private Assinatura(String alias) throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException, Exception {

		CertificateDetails certDetails = Certificados.getCertificateByAlias(Tipo.KEYSTORE, alias);

		if (certDetails != null) {
			this.certificate = certDetails.getCertificate();
			this.privateKey = certDetails.getPrivateKey();
		} else {
			throw new Exception("Certificado: " + alias + " não encontrado");
		}
	}

	private Assinatura(X509Certificate certificate, PrivateKey privateKey) {
		this.certificate = certificate;
		this.privateKey = privateKey;
	}

	private Assinatura(String certificado, String senha) throws Exception {

		// loadCertificate(certificado, senha);
		CertificateDetails certificateDetails = Certificados.getCertificateA1(certificado, senha);

		if (certificateDetails != null) {
			this.certificate = certificateDetails.getCertificate();
			this.privateKey = certificateDetails.getPrivateKey();
		} else {
			throw new Exception("Certificado não encontrado");
		}
	}
	
	public static Assinatura getInstance(String certAlias) throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException, Exception {
		return new Assinatura(certAlias);
	}

	public static Assinatura getInstance(CertificateDetails cert) {
		return new Assinatura(cert.getCertificate(), cert.getPrivateKey());
	}

	public static Assinatura getInstance(String certificado, String senha) throws Exception {
		return new Assinatura(certificado, senha);
	}

	public String assinarInfEvento(String xml) throws SAXException, IOException, ParserConfigurationException, NoSuchAlgorithmException,
			InvalidAlgorithmParameterException, MarshalException, XMLSignatureException, TransformerException {

		final String ID_ATTRIBUTE = "Id";

		Document document = createDocumentFactory(xml);
		XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
		List<Transform> listTransform = signatureFactory(signatureFactory);

		this.loadKeyInfo(signatureFactory);

		// obtem os nôs <evento>
		NodeList nodeList = document.getElementsByTagName(TAG_EVENTO);

		// itera sobre os nôs encontrados
		for (int i = 0; i < nodeList.getLength(); i++) {

			// obtem nô <evento> na posição 'i'
			Node node = nodeList.item(i);
			
			NodeList childNodes = node.getChildNodes();

			// itera sobre os nôs filhos até encontrar <infEvento>
			for (int k = 0; k < childNodes.getLength(); k++) {

				Node childNode = childNodes.item(k);

				// se for 'infEvento'
				if (childNode.getNodeName().equals(TAG_INFEVENTO) && childNode.getNodeType() == Node.ELEMENT_NODE) {

					// configura atributo Id para ser realmente o Id
					Element e = (Element) childNode;
					e.setIdAttribute(ID_ATTRIBUTE, true);

					// obtem o valor da tag Id
					String id = e.getAttribute(ID_ATTRIBUTE);

					// referencia do xml, ou seja, os dados a serem assinados
					Reference ref = signatureFactory.newReference("#" + id, signatureFactory.newDigestMethod(DigestMethod.SHA1, null), listTransform, null, null);

					SignedInfo si = signatureFactory.newSignedInfo(
							signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null),
							signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Arrays.asList(ref));

					// cria signature para assinar o xml e adicionar a tag <Signature>
					XMLSignature signature = signatureFactory.newXMLSignature(si, keyInfo);

					// contexto de assinatura
					DOMSignContext dsc = new DOMSignContext(privateKey, node);

					signature.sign(dsc);
				}
			}
		}

		return getDocumentXML(document);
	}

	/**
	 * Assina o XML de envio da NFe
	 * 
	 * @param xml
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidAlgorithmParameterException
	 * @throws MarshalException
	 * @throws XMLSignatureException
	 * @throws TransformerException
	 */
	public String assinarEnvNfe(String xml) throws SAXException, IOException, ParserConfigurationException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			MarshalException, XMLSignatureException, TransformerException {

		final String ID_ATTRIBUTE = "Id";

		Document document = createDocumentFactory(xml);
		XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
		ArrayList<Transform> transformList = signatureFactory(signatureFactory);

		this.loadKeyInfo(signatureFactory);

		NodeList listNfe = document.getElementsByTagName(TAG_NFE);

		// itera sobre os nós <NFe> encontrados
		for (int i = 0; i < listNfe.getLength(); i++) {

			Node nodeNfe = listNfe.item(i);
			NodeList childNodes = nodeNfe.getChildNodes();

			// itera sobre os nós filhos
			for (int k = 0; k < childNodes.getLength(); k++) {
				Node item = childNodes.item(k);

				if (item.getNodeName().equals(TAG_INFNFE)) {

					if (item.getNodeType() == Node.ELEMENT_NODE) {

						Element e = (Element) item;
						e.setIdAttribute(ID_ATTRIBUTE, true);

						String id = e.getAttribute(ID_ATTRIBUTE);

						// referencia do xml, ou seja, os dados a serem assinados
						Reference ref = signatureFactory.newReference("#" + id, signatureFactory.newDigestMethod(DigestMethod.SHA1, null), transformList, null, null);

						SignedInfo si = signatureFactory.newSignedInfo(
								signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null),
								signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Arrays.asList(ref));

						// cria signature para assinar o xml e adicionar a tag <Signature>
						XMLSignature signature = signatureFactory.newXMLSignature(si, keyInfo);

						// contexto de assinatura
						DOMSignContext dsc = new DOMSignContext(privateKey, nodeNfe);

						signature.sign(dsc);
					}
				}
			}

		}

		return getDocumentXML(document);
	}

	/**
	 * Assinatura do XML de Envio de Lote da NF-e utilizando Certificado Digital A1.
	 * 
	 * @param xml
	 * @param certificado
	 * @param senha
	 * @return
	 * @throws Exception
	 * 
	 *             public String assinaEnviNFe(String xml) throws Exception {
	 * 
	 *             Document document = createDocumentFactory(xml);
	 * 
	 *             XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
	 * 
	 *             // especifica os algoritmos para canonicalizar os dados, e o modo de // assinatura que no caso será envelopado ArrayList
	 *             <Transform> transformList = signatureFactory(signatureFactory);
	 * 
	 *             this.loadKeyInfo(signatureFactory);
	 * 
	 *             for (int i = 0; i < document.getDocumentElement().getElementsByTagName(TAG_NFE).getLength(); i++) {
	 *             assinarNFe(signatureFactory, transformList, privateKey, keyInfo, document, i); }
	 * 
	 *             return getDocumentXML(document); }
	 */

	/**
	 * Assintaruda do XML de Cancelamento da NF-e utilizando Certificado Digital A1.
	 * 
	 * @param xml
	 * @param certificado
	 * @param senha
	 * @return
	 * @throws Exception
	 */
	public String assinaCancNFe(String xml, String certificado, String senha) throws Exception {
		return assinaCancelametoInutilizacao(xml, certificado, senha, TAG_INFCANC);
	}

	/**
	 * Assinatura do XML de Inutilizacao de sequenciais da NF-e utilizando Certificado Digital A1.
	 * 
	 * @param xml
	 * @param certificado
	 * @param senha
	 * @return
	 * @throws Exception
	 */
	public String assinaInutNFe(String xml, String certificado, String senha) throws Exception {
		return assinaCancelametoInutilizacao(xml, certificado, senha, TAG_INFINUT);
	}

	private void assinarNFe(XMLSignatureFactory fac, ArrayList<Transform> transformList, PrivateKey privateKey, KeyInfo ki, Document document, int indexNFe)
			throws Exception {

		final String ID_ATTRIBUTE = "Id";

		// obtem todas as tags <infNFe> do documento
		NodeList elements = document.getElementsByTagName("infNFe");

		// obtem a tag <infNFe> na posição 'indexNFe'
		org.w3c.dom.Element el = (org.w3c.dom.Element) elements.item(indexNFe);
		el.setIdAttribute(ID_ATTRIBUTE, true);

		// obtem o atributo 'Id' da tag <infNFe>
		String id = el.getAttribute(ID_ATTRIBUTE);

		// cria a tag <Reference> com URI = Id da tag <infNFe>, utilizando
		// método de Digest SHA1
		Reference ref = fac.newReference("#" + id, fac.newDigestMethod(DigestMethod.SHA1, null), transformList, null, null);

		// cria tag <SignedInfo>, utilizando método de canonicalizacao C14N
		// cria método de assinatura utilizando o SHA1
		// utilizando a referencia criada anteriormente
		SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null),
				fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));

		// cria tag <Signature> utilizando o SignedInfo criado anteriormente
		XMLSignature signature = fac.newXMLSignature(si, ki);

		// cria contexto de assiantura no DOM do XML, utilizando a chave privada
		// carregada do certificado, e busca os elementos da TAG <NFe>, obtendo
		// o elemento na posição 'indexNFe'
		DOMSignContext dsc = new DOMSignContext(privateKey, document.getDocumentElement().getElementsByTagName(TAG_NFE).item(indexNFe));

		// assina o conteudo da tag <NFe> de acordo com a referência criada e
		// utilizando as informações de assinatura
		signature.sign(dsc);
	}

	private String assinaCancelametoInutilizacao(String xml, String certificado, String senha, String tagCancInut) throws Exception {

		Document document = createDocumentFactory(xml);

		XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");

		ArrayList<Transform> transformList = signatureFactory(signatureFactory);
		loadCertificates(certificado, senha, signatureFactory);

		// obtem os nos do xml de inutilizacao
		NodeList elements = document.getElementsByTagName(tagCancInut);

		// obtem o primeiro elemento encontrado do nó
		org.w3c.dom.Element el = (org.w3c.dom.Element) elements.item(0);

		String id = el.getAttribute("Id");

		Reference ref = signatureFactory.newReference("#" + id, signatureFactory.newDigestMethod(DigestMethod.SHA1, null), transformList, null, null);

		SignedInfo si = signatureFactory.newSignedInfo(signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null),
				signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));

		XMLSignature signature = signatureFactory.newXMLSignature(si, keyInfo);

		DOMSignContext dsc = new DOMSignContext(privateKey, document.getFirstChild());
		signature.sign(dsc);

		return getDocumentXML(document);
	}

	private ArrayList<Transform> signatureFactory(XMLSignatureFactory signatureFactory) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {

		ArrayList<Transform> transformList = new ArrayList<Transform>();

		TransformParameterSpec tps = null;

		// assinatura modo envelopado
		Transform envelopedTransform = signatureFactory.newTransform(Transform.ENVELOPED, tps);

		// algoritmo a ser usado para canonicalizar os dados, esse algoritmo
		// serve para retirar as diferenças por exemplo espaço em branco, etc...
		Transform c14NTransform = signatureFactory.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);

		// adiciona a lista de transformação do <SignedInfo>
		transformList.add(envelopedTransform);
		transformList.add(c14NTransform);

		return transformList;
	}

	private Document createDocumentFactory(String xml) throws SAXException, IOException, ParserConfigurationException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);

		return factory.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));
	}

	/**
	 * Carrega o certificado digital
	 * 
	 * @param cert
	 *            nome do certificado
	 * @param password
	 *            senha do certificado
	 * @throws Exception
	 */
	private void loadCertificate(String cert, String password) throws Exception {

		// cria KeyStore, ou seja, o certificado no formato .pfx
		KeyStore ks = KeyStore.getInstance("pkcs12");

		try {
			// carrega certificado digital modelo A1, pode ser um arquivo com
			// extensão .pfx ou .cer
			ks.load(new FileInputStream(cert), password.toCharArray());
		} catch (IOException e) {
			throw new Exception("Senha do Certificado Digital incorreta ou Certificado inválido.");
		}

		KeyStore.PrivateKeyEntry pkEntry = null;

		Enumeration<String> aliasesEnum = ks.aliases();

		while (aliasesEnum.hasMoreElements()) {

			String alias = (String) aliasesEnum.nextElement();

			info("Certificado: " + alias);

			if (ks.isKeyEntry(alias)) {
				pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(alias, new KeyStore.PasswordProtection(password.toCharArray()));
				this.privateKey = pkEntry.getPrivateKey();
				break;
			}
		}

		// certificado digital
		this.certificate = (X509Certificate) pkEntry.getCertificate();

		info("Certificado carregado -> " + this.certificate.getSubjectDN().toString() + "\n\n");
	}

	/**
	 * Carrega as informações das chaves do certificado
	 */
	private void loadKeyInfo(XMLSignatureFactory xmlSignatureFactory) {

		// conteudo do certificado digital
		KeyInfoFactory keyInfoFactory = xmlSignatureFactory.getKeyInfoFactory();

		X509Data x509Data = keyInfoFactory.newX509Data(Arrays.asList(this.certificate));
		this.keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));
	}

	private void loadCertificates(String certificado, String senha, XMLSignatureFactory signatureFactory) throws Exception {

		InputStream entrada = new FileInputStream(certificado);

		// cria KeyStore, ou seja, o certificado no formato .pfx
		KeyStore ks = KeyStore.getInstance("pkcs12");

		try {
			// carrega certificado digital modelo A1, pode ser um arquivo com
			// extensão .pfx ou .cer
			ks.load(entrada, senha.toCharArray());
		} catch (IOException e) {
			throw new Exception("Senha do Certificado Digital incorreta ou Certificado inválido.");
		}

		KeyStore.PrivateKeyEntry pkEntry = null;

		Enumeration<String> aliasesEnum = ks.aliases();

		while (aliasesEnum.hasMoreElements()) {
			String alias = (String) aliasesEnum.nextElement();

			if (ks.isKeyEntry(alias)) {
				pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(alias, new KeyStore.PasswordProtection(senha.toCharArray()));
				privateKey = pkEntry.getPrivateKey();
				break;
			}
		}

		// certificado digital
		X509Certificate cert = (X509Certificate) pkEntry.getCertificate();
		info("SubjectDN: " + cert.getSubjectDN().toString());

		// conteudo do certificado digital
		KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();

		List<X509Certificate> x509Content = new ArrayList<X509Certificate>();
		x509Content.add(cert);

		X509Data x509Data = keyInfoFactory.newX509Data(x509Content);
		keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));
	}

	private String getDocumentXML(Document doc) throws TransformerException {

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();

		trans.transform(new DOMSource(doc), new StreamResult(os));

		return os.toString().replace(" standalone=\"no\"", "");
	}

	/**
	 * Log INFO.
	 * 
	 * @param info
	 */
	private static void info(String info) {
		System.out.println(info);
	}

}
