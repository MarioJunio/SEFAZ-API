package br.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import br.com.nc.entity.sefaz.nfe.nfedistdfe.ResNFe;
import br.com.nc.entity.sefaz.nfe.nfedistdfe.RetDistDFeInt;
import br.com.nc.entity.sefaz.nfe.nfedistdfe.RetDistDFeInt.LoteDistDFeInt.DocZip;
import br.com.nc.entity.sefaz.nfe.nfedistdfe.TNfeProc;
import br.com.nc.holder.ConsDistDFeHolder;
import br.com.nc.holder.ConsDistDFeHolder.SituacaoNFe;
import br.com.nc.holder.ConsDistDFeHolder.TipoNF;
import br.com.nc.model.NFAmbiente;
import br.com.nc.security.SSL;
import br.com.nc.services.sefaz.nfe.DistDFe;
import br.com.nc.utils.Utils;

public class NFeDistDFeTestExec {

	@Test
	public void consultarDistDFe() throws JAXBException {

		// String certificadoFisico = "/Users/MarioJ/Desktop/hp-logistica.pfx";
		String apelidoCertificado = "HP LOGISTICA LTDA ME:15107846000100";
		// String senhaCertificado = "20151972";
		NFAmbiente ambiente = NFAmbiente.HOMOLOGACAO;

		/*
		 * Carrega certificado A1 AppConfig config = new AppConfig(cacerts, certificadoParaSSL, senhaCertificado, ambiente);
		 * config.carregarCertificado();
		 */

		try {

			DistDFe nfeDistDfe = DistDFe.getInstance(ambiente);

			SSL.apply(apelidoCertificado);
			String retXml = (String) nfeDistDfe.enviar(
					"<?xml version=\"1.0\" encoding=\"UTF-8\"?><distDFeInt versao=\"1.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><tpAmb>" + ambiente.getCodigo()
							+ "</tpAmb><cUFAutor>31</cUFAutor><CNPJ>15107846000100</CNPJ><distNSU><ultNSU>000000000000000</ultNSU></distNSU></distDFeInt>");
			RetDistDFeInt retDistDFeInt = nfeDistDfe.parseXMLRetorno(retXml);

			if (retDistDFeInt.getCStat().equals("138")) {

				Map<String, ConsDistDFeHolder> mapDistDFe = new HashMap<>();
				// List<ConsDistDFeHolder> listDistDFeHolder = new ArrayList<>();

//				System.out.println(String.format("Status: %s\nMotivo: %s", retDistDFeInt.getCStat(), retDistDFeInt.getXMotivo()));
//				System.out.println(String.format("Ult, Max NSU %s, %s", retDistDFeInt.getUltNSU(), retDistDFeInt.getMaxNSU()));

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");

				for (DocZip lote : retDistDFeInt.getLoteDistDFeInt().getDocZip()) {

					String xml = nfeDistDfe.unzip(lote.getValue());
//					System.out.println(String.format("NSU %s, Schema %s, Value %s", lote.getNSU(), lote.getSchema(), xml));

					ConsDistDFeHolder holder = new ConsDistDFeHolder();

					if (lote.getSchema().equalsIgnoreCase("procNFe_v3.10.xsd")) {

						TNfeProc parseProcNFe = nfeDistDfe.parseProcNFe(xml);

						holder.setResumo(false);
						holder.setChNFe(parseProcNFe.getProtNFe().getInfProt().getChNFe());
						holder.setNomeEmitente(parseProcNFe.getNFe().getInfNFe().getEmit().getXNome());
						holder.setDataEmissao(dateFormat.parse(parseProcNFe.getNFe().getInfNFe().getIde().getDhEmi()));
						holder.setTipoNf(
								parseProcNFe.getNFe().getInfNFe().getIde().getTpNF().equals(String.valueOf(TipoNF.ENTRADA.ordinal())) ? TipoNF.ENTRADA : TipoNF.SAIDA);
						holder.setValor(new BigDecimal(parseProcNFe.getNFe().getInfNFe().getTotal().getICMSTot().getVNF()));
						holder.setDataRecebimento(dateFormat.parse(parseProcNFe.getProtNFe().getInfProt().getDhRecbto()));

						if (parseProcNFe.getProtNFe().getInfProt().getCStat().equals("100"))
							holder.setSituacaoNFe(SituacaoNFe.AUTORIZADO);
						else if (parseProcNFe.getProtNFe().getInfProt().getCStat().equals("110"))
							holder.setSituacaoNFe(SituacaoNFe.DENEGADO);

					} else if (lote.getSchema().equalsIgnoreCase("resNFe_v1.00.xsd")) {

						ResNFe resNFe = nfeDistDfe.parseResNFe(xml);
						holder.setResumo(true);
						holder.setChNFe(resNFe.getChNFe());
						holder.setNomeEmitente(resNFe.getXNome());
						holder.setDataEmissao(dateFormat.parse(resNFe.getDhEmi()));
						holder.setTipoNf(resNFe.getTpNF().equals(String.valueOf(TipoNF.ENTRADA.ordinal())) ? TipoNF.ENTRADA : TipoNF.SAIDA);
						holder.setValor(new BigDecimal(resNFe.getVNF()));
						holder.setDataRecebimento(Utils.isEmpty(resNFe.getDhRecbto()) ? null : dateFormat.parse(resNFe.getDhRecbto()));
						holder.setSituacaoNFe(resNFe.getCSitNFe().equals("1") ? SituacaoNFe.AUTORIZADO : SituacaoNFe.DENEGADO);
					}

					// listDistDFeHolder.add(holder);

					// adiciona holder da NFe
					Optional<ConsDistDFeHolder> optDistDFeHolder = Optional.ofNullable(mapDistDFe.get(holder.getChNFe()));

					// se encontrar a NFe mapeada para sua chave, então é necessário verificar é um XML resumo ou completo da NFe
					// caso contrário adicione o XML no mapa
					if (optDistDFeHolder.isPresent()) {

						// NFe encontrada
						ConsDistDFeHolder distDFe = optDistDFeHolder.get();

						// se a NFe ja incluida for um resumo, e a NFe a ser adicionado não for resumo, então deve substituir o elemento
						// caso contrario não adicionar pois já foi adicionada a NFe completa
						if (distDFe.isResumo() && !holder.isResumo()) {
							mapDistDFe.put(holder.getChNFe(), holder);
						}

					} else {
						mapDistDFe.put(holder.getChNFe(), holder);
					}
				}

				// System.out.println("Total de notas encontradas: " + listDistDFeHolder.size());
				//
				// int c = 0;
				// for (ConsDistDFeHolder holder : listDistDFeHolder) {
				//
				// if (holder.isResumo()) {
				//
				// for (ConsDistDFeHolder holder2 : listDistDFeHolder) {
				//
				// if (holder.equals(holder2) && !holder2.isResumo()) {
				// c++;
				// }
				// }
				// }
				//
				// }

				// System.out.println("Total de notas duplicadas que foram encontradas: " + c);

				mapDistDFe.values().forEach(holder -> {
					System.out.printf("Chave NFe: %s \t %s - Resumo: (%s)\n", holder.getChNFe(), holder.getNomeEmitente(), holder.isResumo() ? "Sim" : "Nao");
				});

				System.out.println("Total de notas após remover duplicadas: " + mapDistDFe.keySet().size());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
