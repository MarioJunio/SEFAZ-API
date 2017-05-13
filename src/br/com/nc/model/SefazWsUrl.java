package br.com.nc.model;

public enum SefazWsUrl {

	AM("") {

		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeAutorizacao"
					: "https://nfe.sefaz.am.gov.br/services2/services/NfeAutorizacao";
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao"
					: "https://nfe.sefaz.am.gov.br/services2/services/NfeRetAutorizacao";
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeConsulta2"
					: "https://nfe.sefaz.am.gov.br/services2/services/NfeConsulta2";
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeStatusServico2"
					: "https://nfe.sefaz.am.gov.br/services2/services/NfeStatusServico2";
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/RecepcaoEvento"
					: "https://nfe.sefaz.am.gov.br/services2/services/RecepcaoEvento";
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/cadconsultacadastro2"
					: "https://nfe.sefaz.am.gov.br/services2/services/CadConsultaCadastro2";
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfe.sefaz.am.gov.br/services2/services/NfeInutilizacao2"
					: "https://nfe.sefaz.am.gov.br/services2/services/NfeInutilizacao2";
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfce.sefaz.am.gov.br/nfce-services-nac/services/NfeAutorizacao"
					: "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeAutorizacao";
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfce.sefaz.am.gov.br/nfce-services-nac/services/NfeRetAutorizacao"
					: "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeRetAutorizacao";
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? null : "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeConsulta2";
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfce.sefaz.am.gov.br/nfce-services-nac/services/NfeStatusServico2"
					: "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeStatusServico2";
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfce.sefaz.am.gov.br/nfce-services/services/RecepcaoEvento"
					: "https://nfe.sefaz.am.gov.br/services2/services/RecepcaoEvento";
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homnfce.sefaz.am.gov.br/nfce-services-nac/services/NfeInutilizacao2"
					: "https://nfce.sefaz.am.gov.br/nfce-services/services/NfeInutilizacao2";
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			throw new UnsupportedOperationException("Nao suportado ainda");
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.AM };
		}
	},
	AN("91") {
		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx"
					: "https://www.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx";
		}

		@Override
		public String getNfeAutorizacao(NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfeRetAutorizacao(NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfeConsultaProtocolo(NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfeStatusServico(NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getConsultaCadastro(NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfeInutilizacao(NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceAutorizacao(NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceRetAutorizacao(NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceConsultaProtocolo(NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceStatusServico(NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceRecepcaoEvento(NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceInutilizacao(NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx"
					: "https://www.nfe.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx";
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx"
					: "https://www1.nfe.fazenda.gov.br/NFeDistribuicaoDFe/NFeDistribuicaoDFe.asmx";
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/NfeDownloadNF/NfeDownloadNF.asmx"
					: "https://www.nfe.fazenda.gov.br/NfeDownloadNF/NfeDownloadNF.asmx";
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] {};
		}
	},
	/**
	 * Links NFC-e segundo site: https://ciranda.me/tsdn/blog-da-tecnospeed/post/como-emitir-nfc-e-na-bahia
	 */
	BA("29") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NfeAutorizacao/NfeAutorizacao.asmx"
					: "https://nfe.sefaz.ba.gov.br/webservices/NfeAutorizacao/NfeAutorizacao.asmx";
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NfeRetAutorizacao/NfeRetAutorizacao.asmx"
					: "https://nfe.sefaz.ba.gov.br/webservices/NfeRetAutorizacao/NfeRetAutorizacao.asmx";
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NfeConsulta/NfeConsulta.asmx"
					: "https://nfe.sefaz.ba.gov.br/webservices/NfeConsulta/NfeConsulta.asmx";
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NfeStatusServico/NfeStatusServico.asmx"
					: "https://nfe.sefaz.ba.gov.br/webservices/NfeStatusServico/NfeStatusServico.asmx";
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/sre/recepcaoevento.asmx"
					: "https://nfe.sefaz.ba.gov.br/webservices/sre/recepcaoevento.asmx";
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/nfenw/CadConsultaCadastro2.asmx"
					: "https://nfe.sefaz.ba.gov.br/webservices/nfenw/CadConsultaCadastro2.asmx";
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.sefaz.ba.gov.br/webservices/NfeInutilizacao/NfeInutilizacao.asmx"
					: "https://nfe.sefaz.ba.gov.br/webservices/NfeInutilizacao/NfeInutilizacao.asmx";
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return SVRS.getNfceAutorizacao(ambiente);
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return SVRS.getNfceRetAutorizacao(ambiente);
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return SVRS.getNfceConsultaProtocolo(ambiente);
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return SVRS.getNfceStatusServico(ambiente);
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return SVRS.getNfceRecepcaoEvento(ambiente);
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return SVRS.getNfceInutilizacao(ambiente);
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			throw new UnsupportedOperationException("Nao suportado ainda");
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.BA };
		}
	},
	CE("23") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeAutorizacao?wsdl"
					: "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeAutorizacao?wsdl";
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeRetAutorizacao?wsdl"
					: "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeRetAutorizacao?wsdl";
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeConsulta2?wsdl"
					: "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeConsulta2?wsdl";
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeStatusServico2?wsdl"
					: "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeStatusServico2?wsdl";
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/RecepcaoEvento?wsdl"
					: "https://nfe.sefaz.ce.gov.br/nfe2/services/RecepcaoEvento?wsdl";
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/CadConsultaCadastro2?wsdl"
					: "https://nfe.sefaz.ce.gov.br/nfe2/services/CadConsultaCadastro2?wsdl";
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeInutilizacao2?wsdl"
					: "https://nfe.sefaz.ce.gov.br/nfe2/services/NfeInutilizacao2?wsdl";
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfceh.sefaz.ce.gov.br/nfce/services/NfeAutorizacao?WSDL" : null;
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfceh.sefaz.ce.gov.br/nfce/services/NfeRetAutorizacao?WSDL" : null;
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfceh.sefaz.ce.gov.br/nfce/services/NfeConsulta2?WSDL" : null;
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfceh.sefaz.ce.gov.br/nfce/services/NfeStatusServico2?WSDL" : null;
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfceh.sefaz.ce.gov.br/nfce/services/RecepcaoEvento?WSDL" : null;
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfceh.sefaz.ce.gov.br/nfce/services/NfeInutilizacao2?WSDL" : null;
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return AN.getNFeDistribuicaoDFe(ambiente);
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.CE };
		}
	},
	GO("52") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeAutorizacao?wsdl"
					: "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeAutorizacao?wsdl";
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeRetAutorizacao?wsdl"
					: "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeRetAutorizacao?wsdl";
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl"
					: "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl";
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl"
					: "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl";
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/RecepcaoEvento?wsdl"
					: "https://nfe.sefaz.go.gov.br/nfe/services/v2/RecepcaoEvento?wsdl";
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/CadConsultaCadastro2?wsdl"
					: "https://nfe.sefaz.go.gov.br/nfe/services/v2/CadConsultaCadastro2?wsdl";
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl"
					: "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl";
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeAutorizacao?wsdl"
					: "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeAutorizacao?wsdl";
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeRetAutorizacao?wsdl"
					: "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeRetAutorizacao?wsdl";
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl"
					: "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeConsulta2?wsdl";
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl"
					: "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeStatusServico2?wsdl";
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/RecepcaoEvento?wsdl"
					: "https://nfe.sefaz.go.gov.br/nfe/services/v2/RecepcaoEvento?wsdl";
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homolog.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl"
					: "https://nfe.sefaz.go.gov.br/nfe/services/v2/NfeInutilizacao2?wsdl";
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return AN.getNFeDistribuicaoDFe(ambiente);
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.GO };
		}
	},
	MA("21") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return SVAN.getNfeAutorizacao(ambiente);
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return SVAN.getNfeRetAutorizacao(ambiente);
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return SVAN.getNfeConsultaProtocolo(ambiente);
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return SVAN.getNfeStatusServico(ambiente);
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return SVAN.getRecepcaoEvento(ambiente);
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			return SVAN.getConsultaCadastro(ambiente);
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return SVAN.getNfeInutilizacao(ambiente);
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return SVRS.getNfceAutorizacao(ambiente);
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return SVRS.getNfceRetAutorizacao(ambiente);
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return SVRS.getNfceConsultaProtocolo(ambiente);
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return SVRS.getNfceStatusServico(ambiente);
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return SVRS.getNfceRecepcaoEvento(ambiente);
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return SVRS.getNfceInutilizacao(ambiente);
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return AN.getNFeDistribuicaoDFe(ambiente);
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.MA };
		}
	},
	MG("31") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeAutorizacao"
					: "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeAutorizacao";
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeRetAutorizacao"
					: "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeRetAutorizacao";
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2"
					: "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeConsulta2";
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeStatusServico2"
					: "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeStatus2";
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/RecepcaoEvento"
					: "https://nfe.fazenda.mg.gov.br/nfe2/services/RecepcaoEvento";
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/cadconsultacadastro2"
					: "https://nfe.fazenda.mg.gov.br/nfe2/services/cadconsultacadastro2";
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hnfe.fazenda.mg.gov.br/nfe2/services/NfeInutilizacao2"
					: "https://nfe.fazenda.mg.gov.br/nfe2/services/NfeInutilizacao2";
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return AN.getNFeDistribuicaoDFe(ambiente);
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.MG };
		}
	},
	MS("50") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeAutorizacao"
					: "https://nfe.fazenda.ms.gov.br/producao/services2/NfeAutorizacao";
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeRetAutorizacao"
					: "https://nfe.fazenda.ms.gov.br/producao/services2/NfeRetAutorizacao";
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeConsulta2"
					: "https://nfe.fazenda.ms.gov.br/producao/services2/NfeConsulta2";
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeStatusServico2"
					: "https://nfe.fazenda.ms.gov.br/producao/services2/NfeStatusServico2";
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/RecepcaoEvento"
					: "https://nfe.fazenda.ms.gov.br/producao/services2/RecepcaoEvento";
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/CadConsultaCadastro2"
					: "https://nfe.fazenda.ms.gov.br/producao/services2/CadConsultaCadastro2";
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.ms.gov.br/homologacao/services2/NfeInutilizacao2"
					: "https://nfe.fazenda.ms.gov.br/producao/services2/NfeInutilizacao2";
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return AN.getNFeDistribuicaoDFe(ambiente);
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.MS };
		}
	},
	MT("51") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao?wsdl"
					: "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeAutorizacao?wsdl";
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao?wsdl"
					: "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeRetAutorizacao?wsdl";
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2?wsdl"
					: "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeConsulta2?wsdl";
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico2?wsdl"
					: "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeStatusServico2?wsdl";
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento?wsdl"
					: "https://nfe.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento?wsdl";
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro2?wsdl"
					: "https://nfe.sefaz.mt.gov.br/nfews/v2/services/CadConsultaCadastro2?wsdl";
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao2?wsdl"
					: "https://nfe.sefaz.mt.gov.br/nfews/v2/services/NfeInutilizacao2?wsdl";
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeAutorizacao?wsdl"
					: "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeAutorizacao?wsdl";
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeRetAutorizacao?wsdl"
					: "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeRetAutorizacao?wsdl";
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeConsulta2?wsdl"
					: "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeConsulta2?wsdl";
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeStatusServico2?wsdl"
					: "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeStatusServico2?wsdl";
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/RecepcaoEvento?wsdl"
					: "https://nfce.sefaz.mt.gov.br/nfcews/services/RecepcaoEvento?wsdl";
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.sefaz.mt.gov.br/nfcews/services/NfeInutilizacao2?wsdl"
					: "https://nfce.sefaz.mt.gov.br/nfcews/services/NfeInutilizacao2?wsdl";
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return AN.getNFeDistribuicaoDFe(ambiente);
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.MT };
		}
	},
	PA("15") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return SVAN.getNfeAutorizacao(ambiente);
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return SVAN.getNfeRetAutorizacao(ambiente);
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return SVAN.getNfeConsultaProtocolo(ambiente);
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return SVAN.getNfeStatusServico(ambiente);
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return SVAN.getRecepcaoEvento(ambiente);
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			return SVAN.getConsultaCadastro(ambiente);
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return SVAN.getNfeInutilizacao(ambiente);
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return SVRS.getNfceAutorizacao(ambiente);
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return SVRS.getNfceRetAutorizacao(ambiente);
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return SVRS.getNfceConsultaProtocolo(ambiente);
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return SVRS.getNfceStatusServico(ambiente);
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return SVRS.getNfceRecepcaoEvento(ambiente);
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return SVRS.getNfceInutilizacao(ambiente);
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return AN.getNFeDistribuicaoDFe(ambiente);
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			throw new UnsupportedOperationException("Nao suportado ainda");
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.PA };
		}
	},
	PE("26") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeAutorizacao?wsdl"
					: "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeAutorizacao?wsdl";
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeRetAutorizacao?wsdl"
					: "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeRetAutorizacao?wsdl";
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2"
					: "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeConsulta2";
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeStatusServico2"
					: "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeStatusServico2";
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/RecepcaoEvento"
					: "https://nfe.sefaz.pe.gov.br/nfe-service/services/RecepcaoEvento";
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro2"
					: "https://nfe.sefaz.pe.gov.br/nfe-service/services/CadConsultaCadastro2";
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfehomolog.sefaz.pe.gov.br/nfe-service/services/NfeInutilizacao2"
					: "https://nfe.sefaz.pe.gov.br/nfe-service/services/NfeInutilizacao2";
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfcehomolog.sefaz.pe.gov.br/nfce-ws/services/NfeAutorizacao"
					: "https://nfce.sefaz.pe.gov.br/nfce-ws/services/NfeAutorizacao";
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfcehomolog.sefaz.pe.gov.br/nfce-ws/services/NfeRetAutorizacao"
					: "https://nfce.sefaz.pe.gov.br/nfce-ws/services/NfeRetAutorizacao";
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfcehomolog.sefaz.pe.gov.br/nfce-ws/services/NfeConsulta2"
					: "https://nfce.sefaz.pe.gov.br/nfce-ws/services/NfeConsulta2";
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfcehomolog.sefaz.pe.gov.br/nfce-ws/services/NfeStatusServico2"
					: "https://nfce.sefaz.pe.gov.br/nfce-ws/services/NfeStatusServico2";
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfcehomolog.sefaz.pe.gov.br/nfce-ws/services/RecepcaoEvento"
					: "https://nfce.sefaz.pe.gov.br/nfce-ws/services/RecepcaoEvento";
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfcehomolog.sefaz.pe.gov.br/nfce-ws/services/NfeInutilizacao2"
					: "https://nfce.sefaz.pe.gov.br/nfce-ws/services/NfeInutilizacao2";
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return AN.getNFeDistribuicaoDFe(ambiente);
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.PE };
		}
	},
	PI("22") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return SVAN.getNfeAutorizacao(ambiente);
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return SVAN.getNfeRetAutorizacao(ambiente);
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return SVAN.getNfeConsultaProtocolo(ambiente);
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return SVAN.getNfeStatusServico(ambiente);
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return SVAN.getRecepcaoEvento(ambiente);
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			return SVAN.getConsultaCadastro(ambiente);
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return SVAN.getNfeInutilizacao(ambiente);
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return SVRS.getNfceAutorizacao(ambiente);
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return SVRS.getNfceRetAutorizacao(ambiente);
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return SVRS.getNfceConsultaProtocolo(ambiente);
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return SVRS.getNfceStatusServico(ambiente);
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return SVRS.getNfceRecepcaoEvento(ambiente);
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return SVRS.getNfceInutilizacao(ambiente);
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return AN.getNFeDistribuicaoDFe(ambiente);
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.PI };
		}
	},
	PR("41") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeAutorizacao3?wsdl"
					: "https://nfe.fazenda.pr.gov.br/nfe/NFeAutorizacao3?wsdl";
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeRetAutorizacao3?wsdl"
					: "https://nfe.fazenda.pr.gov.br/nfe/NFeRetAutorizacao3?wsdl";
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeConsulta3?wsdl"
					: "https://nfe.fazenda.pr.gov.br/nfe/NFeConsulta3?wsdl";
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeStatusServico3?wsdl"
					: "https://nfe.fazenda.pr.gov.br/nfe/NFeStatusServico3?wsdl";
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeRecepcaoEvento?wsdl"
					: "https://nfe.fazenda.pr.gov.br/nfe/NFeRecepcaoEvento?wsdl";
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/CadConsultaCadastro2?wsdl"
					: "https://nfe.fazenda.pr.gov.br/nfe/CadConsultaCadastro2?wsdl";
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.pr.gov.br/nfe/NFeInutilizacao3?wsdl"
					: "https://nfe.fazenda.pr.gov.br/nfe/NFeInutilizacao3?wsdl";
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeAutorizacao3?wsdl"
					: "https://nfce.fazenda.pr.gov.br/nfce/NFeAutorizacao3?wsdl";
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeRetAutorizacao3?wsdl"
					: "https://nfce.fazenda.pr.gov.br/nfce/NFeRetAutorizacao3?wsdl";
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeConsulta3?wsdl"
					: "https://nfce.fazenda.pr.gov.br/nfce/NFeConsulta3?wsdl";
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeStatusServico3?wsdl"
					: "https://nfce.fazenda.pr.gov.br/nfce/NFeStatusServico3?wsdl";
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeRecepcaoEvento?wsdl"
					: "https://nfce.fazenda.pr.gov.br/nfce/NFeRecepcaoEvento?wsdl";
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.pr.gov.br/nfce/NFeInutilizacao3?wsdl"
					: "https://nfce.fazenda.pr.gov.br/nfce/NFeInutilizacao3?wsdl";
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return AN.getNFeDistribuicaoDFe(ambiente);
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.PR };
		}
	},
	RS("43") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx"
					: "https://nfe.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx";
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx"
					: "https://nfe.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx";
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx"
					: "https://nfe.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx"
					: "https://nfe.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx"
					: "https://nfe.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx";
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx"
					: "https://cad.sefazrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx";
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx"
					: "https://nfe.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx";
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx"
					: "https://nfce.sefazrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx";
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx"
					: "https://nfce.sefazrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx";
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx"
					: "https://nfce.sefazrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx"
					: "https://nfce.sefazrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx"
					: "https://nfce.sefazrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx";
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx"
					: "https://nfce.sefazrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx";
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return AN.getNFeDistribuicaoDFe(ambiente);
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.RS };
		}
	},
	SP("35") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeautorizacao.asmx"
					: "https://nfe.fazenda.sp.gov.br/ws/nfeautorizacao.asmx";
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nferetautorizacao.asmx"
					: "https://nfe.fazenda.sp.gov.br/ws/nferetautorizacao.asmx";
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeconsulta2.asmx"
					: "https://nfe.fazenda.sp.gov.br/ws/nfeconsulta2.asmx";
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfestatusservico2.asmx"
					: "https://nfe.fazenda.sp.gov.br/ws/nfestatusservico2.asmx";
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/recepcaoevento.asmx"
					: "https://nfe.fazenda.sp.gov.br/ws/recepcaoevento.asmx";
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/cadconsultacadastro2.asmx"
					: "https://nfe.fazenda.sp.gov.br/ws/cadconsultacadastro2.asmx";
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx"
					: "https://nfe.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx";
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/nfeautorizacao.asmx"
					: "https://nfce.fazenda.sp.gov.br/ws/nfeautorizacao.asmx";
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/nferetautorizacao.asmx"
					: "https://nfce.fazenda.sp.gov.br/ws/nferetautorizacao.asmx";
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/nfeconsulta2.asmx"
					: "https://nfce.fazenda.sp.gov.br/ws/nfeconsulta2.asmx";
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/nfestatusservico2.asmx"
					: "https://nfce.fazenda.sp.gov.br/ws/nfestatusservico2.asmx";
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/recepcaoevento.asmx"
					: "https://nfce.fazenda.sp.gov.br/ws/recepcaoevento.asmx";
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfce.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx"
					: "https://nfce.fazenda.sp.gov.br/ws/nfeinutilizacao2.asmx";
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return AN.getNFeDistribuicaoDFe(ambiente);
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.SP };
		}
	},
	SVRS("") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx"
					: "https://nfe.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx";
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx"
					: "https://nfe.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx";
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx"
					: "https://nfe.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx"
					: "https://nfe.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx"
					: "https://nfe.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx";
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx"
					: "https://cad.svrs.rs.gov.br/ws/cadconsultacadastro/cadconsultacadastro2.asmx";
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfe-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx"
					: "https://nfe.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx";
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx"
					: "https://nfce.svrs.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx";
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx"
					: "https://nfce.svrs.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx";
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx"
					: "https://nfce.svrs.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx"
					: "https://nfce.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx"
					: "https://nfce.svrs.rs.gov.br/ws/recepcaoevento/recepcaoevento.asmx";
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://nfce-homologacao.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx"
					: "https://nfce.svrs.rs.gov.br/ws/nfeinutilizacao/nfeinutilizacao2.asmx";
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return AN.getNFeDistribuicaoDFe(ambiente);
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] { NFUnidadeFederativa.AC, NFUnidadeFederativa.AL, NFUnidadeFederativa.AP, NFUnidadeFederativa.DF, NFUnidadeFederativa.ES,
					NFUnidadeFederativa.PA, NFUnidadeFederativa.PB, NFUnidadeFederativa.RJ, NFUnidadeFederativa.RN, NFUnidadeFederativa.RO, NFUnidadeFederativa.RR,
					NFUnidadeFederativa.SC, NFUnidadeFederativa.SE, NFUnidadeFederativa.TO };
		}
	},
	SCAN("") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx"
					: "https://www.svc.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx";
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx"
					: "https://www.svc.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx";
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx"
					: "https://www.svc.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx";
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx"
					: "https://www.svc.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx";
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.svc.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx"
					: "https://www.svc.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx";
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			throw new UnsupportedOperationException("SCAN nao possui consulta cadastro");
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			throw new UnsupportedOperationException("SCAN nao possui NFe inutilizacao");
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return AN.getNFeDistribuicaoDFe(ambiente);
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] {};
		}
	},
	SVAN("") {
		@Override
		public String getNfeAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx"
					: "https://www.sefazvirtual.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx";
		}

		@Override
		public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx"
					: "https://www.sefazvirtual.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx";
		}

		@Override
		public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx"
					: "https://www.sefazvirtual.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx";
		}

		@Override
		public String getNfeStatusServico(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx"
					: "https://www.sefazvirtual.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx";
		}

		@Override
		public String getRecepcaoEvento(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx"
					: "https://www.sefazvirtual.fazenda.gov.br/RecepcaoEvento/RecepcaoEvento.asmx";
		}

		@Override
		public String getConsultaCadastro(final NFAmbiente ambiente) {
			throw new UnsupportedOperationException("SVAN nao possui consulta cadastro");
		}

		@Override
		public String getNfeInutilizacao(final NFAmbiente ambiente) {
			return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx"
					: "https://www.sefazvirtual.fazenda.gov.br/NfeInutilizacao2/NfeInutilizacao2.asmx";
		}

		@Override
		public String getNfceAutorizacao(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceRetAutorizacao(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceConsultaProtocolo(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceStatusServico(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceRecepcaoEvento(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getNfceInutilizacao(final NFAmbiente ambiente) {
			return null;
		}

		@Override
		public String getRecepcaoEventoAN(final NFAmbiente ambiente) {
			return AN.getRecepcaoEventoAN(ambiente);
		}

		@Override
		public String getNFeDistribuicaoDFe(final NFAmbiente ambiente) {
			return AN.getNFeDistribuicaoDFe(ambiente);
		}

		@Override
		public String getNfeDownloadNF(final NFAmbiente ambiente) {
			return AN.getNfeDownloadNF(ambiente);
		}

		@Override
		public NFUnidadeFederativa[] getUFs() {
			return new NFUnidadeFederativa[] {};
		}
	};
	
	private String codigo;
	
	SefazWsUrl(String codigo) {
		this.codigo = codigo;
	}

	public abstract String getNfeAutorizacao(final NFAmbiente ambiente);

	public abstract String getNfeRetAutorizacao(final NFAmbiente ambiente);

	public abstract String getNfeConsultaProtocolo(final NFAmbiente ambiente);

	public abstract String getNfeStatusServico(final NFAmbiente ambiente);

	public abstract String getRecepcaoEvento(final NFAmbiente ambiente);

	public abstract String getConsultaCadastro(final NFAmbiente ambiente);

	public abstract String getNfeInutilizacao(final NFAmbiente ambiente);

	public abstract String getNfceAutorizacao(final NFAmbiente ambiente);

	public abstract String getNfceRetAutorizacao(final NFAmbiente ambiente);

	public abstract String getNfceConsultaProtocolo(final NFAmbiente ambiente);

	public abstract String getNfceStatusServico(final NFAmbiente ambiente);

	public abstract String getNfceRecepcaoEvento(final NFAmbiente ambiente);

	public abstract String getNfceInutilizacao(final NFAmbiente ambiente);

	public abstract String getRecepcaoEventoAN(final NFAmbiente ambiente);

	public abstract String getNFeDistribuicaoDFe(final NFAmbiente ambiente);

	public abstract String getNfeDownloadNF(final NFAmbiente ambiente);

	public abstract NFUnidadeFederativa[] getUFs();

	public static SefazWsUrl valueOfCodigoUF(String uf) {

		for (final SefazWsUrl ufWS : SefazWsUrl.values()) {

			if (ufWS.name().equals(uf) || ufWS.getCodigo().equals(uf)) {
				return ufWS;
			}

		}

		throw new IllegalStateException(String.format("Não existe webservice mapeado para a UF %s\n", uf));
	}
	
	public String getCodigo() {
		return codigo;
	}
}