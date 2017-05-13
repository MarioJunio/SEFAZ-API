package br.com.nc.model;

public enum TipoEventoManifestDest {

	ConfirmacaoDaOperacao("210200"), CienciaDaOperacao("210210"), DesconhecimentoDaOperacao("210220"), OperacaoNaoRealizada("210240");

	private String codigo;

	TipoEventoManifestDest(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return this.codigo;
	}

}
