package br.com.nc.security;

import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;

import org.apache.commons.httpclient.protocol.Protocol;

import br.com.nc.config.NFeCacerts;
import br.com.nc.model.CertificateDetails;
import br.com.nc.security.Certificados.Tipo;

public class SSL {
	
	// porta padrão de conexão utilizando SSL
	public static final int SSL_PORT = 443;
	
	private static CertificateDetails certificateDet;
	private static String nfeCacerts = NFeCacerts.CACERTS_FILE;
	
	/**
	 * Carrega o certificado A1, que está localizado na máquina do usuário
	 * @param certPath Caminho do certificado
	 * @param passwd Senha do senha certificado
	 * @throws Exception
	 */
	public static void apply(String certPath, String passwd) throws Exception {
		certificateDet = Certificados.getCertificateA1(certPath, passwd);
		apply();
	}
	
	/**
	 * Carrega o certificado por meio de seu nome(alias)
	 * @param certAlias Nome do certificado a ser carregado
	 * @throws NoSuchAlgorithmException
	 * @throws UnrecoverableEntryException
	 * @throws KeyStoreException
	 * @throws Exception
	 */
	public static void apply(String certAlias) throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException, Exception {
		certificateDet = Certificados.getCertificateByAlias(Tipo.KEYSTORE, certAlias);
		apply();
	}
	
	/**
	 * Carrega o certificado e configura o SSL(TLS)
	 */
	private static void apply() {
		
		if (certificateDet != null) {
			SecureSocketFactory socketFactoryDinamico = new SecureSocketFactory(certificateDet.getCertificate(), certificateDet.getPrivateKey(), nfeCacerts);
			
			Protocol protocol = new Protocol("https", socketFactoryDinamico, SSL_PORT);
			Protocol.registerProtocol("https", protocol);
		} else {
			throw new IllegalStateException("Não foi possível carregar o certificado para ser usado no SSL");
		}
	}

}
