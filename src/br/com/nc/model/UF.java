package br.com.nc.model;

public enum UF {

	AN("91"), MG("31");

	private String codigo;

	UF(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return this.codigo;
	}
}
