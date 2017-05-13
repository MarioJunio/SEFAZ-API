package br.com.nc.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import br.com.nc.model.NFAmbiente;

public class NFeCacerts {

	private static final int TIMEOUT_WS = 30;
	private static final char DIR_SEPARATOR = File.separatorChar;

	public static String CACERTS_FILE = System.getProperty("java.home") + DIR_SEPARATOR + "lib" + DIR_SEPARATOR + "security" + DIR_SEPARATOR + "cacerts";

	public static void gerar(NFAmbiente ambiente) {
		gerarCadeia(ambiente, "changeit");
	}

	public static void gerar(NFAmbiente ambiente, String senha) {
		gerarCadeia(ambiente, senha);
	}

	/**
	 * Obtem a cadeia de certificados dos Web Services da SEFAZ de acordo com o ambiente
	 * 
	 * @param ambiente
	 *            produção ou homologação
	 * @param caminhoArquivo
	 *            caminho do JKS
	 * @param senha
	 *            do JKS
	 */
	private static void gerarCadeia(NFAmbiente ambiente, String senha) {

		List<String> urls = new ArrayList<>();

		if (ambiente == NFAmbiente.PRODUCAO) {

			urls.add("nfe.sefaz.am.gov.br");
			urls.add("nfe.sefaz.ba.gov.br");
			urls.add("nfe.sefaz.ce.gov.br");
			urls.add("nfe.sefaz.go.gov.br");
			urls.add("nfe.fazenda.mg.gov.br");
			urls.add("sistemas.sefaz.ma.gov.br");
			urls.add("nfe.fazenda.ms.gov.br");
			urls.add("nfe.fazenda.ms.gov.br");
			urls.add("nfe.sefaz.mt.gov.br");
			urls.add("nfe.sefaz.pe.gov.br");
			urls.add("nfe.fazenda.pr.gov.br");
			urls.add("cad.sefazrs.rs.gov.br");
			urls.add("nfe.fazenda.sp.gov.br");
			urls.add("www.sefazvirtual.fazenda.gov.br");
			urls.add("cad.svrs.rs.gov.br");
			urls.add("www.svc.fazenda.gov.br");
			urls.add("nfe.svrs.rs.gov.br");
			urls.add("www.nfe.fazenda.gov.br");
			urls.add("www1.nfe.fazenda.gov.br");

		} else if (ambiente == NFAmbiente.HOMOLOGACAO) {

			urls.add("homnfe.sefaz.am.gov.br");
			urls.add("hnfe.sefaz.ba.gov.br");
			urls.add("nfeh.sefaz.ce.gov.br");
			urls.add("homolog.sefaz.go.gov.br");
			urls.add("hnfe.fazenda.mg.gov.br");
			urls.add("sistemas.sefaz.ma.gov.br");
			urls.add("homologacao.nfe.ms.gov.br");
			urls.add("homologacao.sefaz.mt.gov.br");
			urls.add("nfehomolog.sefaz.pe.gov.br");
			urls.add("homologacao.nfe.fazenda.pr.gov.br");
			urls.add("nfe-homologacao.sefazrs.rs.gov.br");
			urls.add("homologacao.nfe.fazenda.sp.gov.br");
			urls.add("hom.sefazvirtual.fazenda.gov.br");
			urls.add("nfe-homologacao.svrs.rs.gov.br");
			urls.add("hom.svc.fazenda.gov.br");
			urls.add("nfe-homologacao.svrs.rs.gov.br");
			urls.add("hom.nfe.fazenda.gov.br");
		}

		gerarCacerts(urls, senha);
	}

	private static void gerarCacerts(List<String> urls, String senha) {

		try {

			/*
			 * File file = null;
			 * 
			 * if (Utils.isWindows()) {
			 * 
			 * file = new File(caminhoCacerts, CACERTS_FILE_NAME);
			 * 
			 * Path path = FileSystems.getDefault().getPath(caminhoCacerts, CACERTS_FILE_NAME); Boolean hidden = (Boolean)
			 * Files.getAttribute(path, "dos:hidden", LinkOption.NOFOLLOW_LINKS);
			 * 
			 * if (hidden != null && !hidden) { Files.setAttribute(path, "dos:hidden", Boolean.TRUE, LinkOption.NOFOLLOW_LINKS); }
			 * 
			 * } else { // TODO: Ao criar arquivo como oculto, é gerado uma exceção ao tentar gravar no arquivo file = new
			 * File(caminhoCacerts, CACERTS_FILE_NAME); }
			 * 
			 * // se não existir crie um novo arquivo if (!file.exists()) file.createNewFile();
			 */

			// File file = new File("NFeCacerts");
			//
			// if (file.isFile() == false) {
			//
			// char SEP = File.separatorChar;
			//
			// File dir = new File(System.getProperty("user.home"));
			// file = new File(dir, "NFeCacerts");
			//
			// if (file.isFile() == false) {
			// file = new File(dir, "cacerts");
			// }
			//
			// }

			File file = new File(CACERTS_FILE);

			// transforma senha em array de char
			char[] passphrase = senha.toCharArray();

			info("Carregando TrustStore(Cadeia de Certificados confiaveis): " + file);

			InputStream in = new FileInputStream(file);
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			ks.load(in, passphrase);
			in.close();

			for (String url : urls) {
				
				try {
					get(url, 443, ks);
				} catch (Exception e) {
					System.err.println(e.getMessage() + " - " + e.getCause());
				}
			}

			OutputStream out = new FileOutputStream(file);
			ks.store(out, passphrase);
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void get(String host, int port, KeyStore ks) throws Exception {

		SSLContext context = SSLContext.getInstance("TLS");
		TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		tmf.init(ks);
		X509TrustManager defaultTrustManager = (X509TrustManager) tmf.getTrustManagers()[0];
		SavingTrustManager tm = new SavingTrustManager(defaultTrustManager);
		context.init(null, new TrustManager[] { tm }, null);
		SSLSocketFactory factory = context.getSocketFactory();

		info("Opening connection to " + host + ":" + port + "...");
		SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
		socket.setSoTimeout(TIMEOUT_WS * 1000);
		try {
			info("Starting SSL handshake...");
			socket.startHandshake();
			socket.close();
			info("No errors, certificate is already trusted");
		} catch (SSLHandshakeException e) {
			/**
			 * PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification
			 * path to requested target Não tratado, pois sempre ocorre essa exceção quando o cacerts nao esta gerado.
			 */
		} catch (SSLException e) {
			e.printStackTrace();
			error(e.toString());
		}

		X509Certificate[] chain = tm.chain;
		if (chain == null) {
			info("Could not obtain server certificate chain");
		}

		info("Server sent " + chain.length + " certificate(s):");
		MessageDigest sha1 = MessageDigest.getInstance("SHA1");
		MessageDigest md5 = MessageDigest.getInstance("MD5");

		for (int i = 0; i < chain.length; i++) {

			X509Certificate cert = chain[i];
			sha1.update(cert.getEncoded());
			md5.update(cert.getEncoded());

			String alias = host + "-" + (i);
			ks.setCertificateEntry(alias, cert);
			info("Added certificate to keystore '" + CACERTS_FILE + "' using alias '" + alias + "'");
			System.out.println("\n");
		}
	}

	private static class SavingTrustManager implements X509TrustManager {

		private final X509TrustManager tm;
		private X509Certificate[] chain;

		SavingTrustManager(X509TrustManager tm) {
			this.tm = tm;
		}

		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[0];
		}

		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			throw new UnsupportedOperationException();
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			this.chain = chain;
			tm.checkServerTrusted(chain, authType);
		}
	}

	private static void info(String log) {
		System.out.println(log);
	}

	private static void error(String log) {
		System.err.println(log);
	}

}
