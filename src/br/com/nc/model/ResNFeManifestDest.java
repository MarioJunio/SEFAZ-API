package br.com.nc.model;

public class ResNFeManifestDest {

	private String chNFe;
	private TipoEventoManifestDest tipoEvento;
	private String xJust;

	public ResNFeManifestDest(String chNFe, TipoEventoManifestDest tipoEvento, String xJust) {
		super();
		this.chNFe = chNFe;
		this.tipoEvento = tipoEvento;
	}

	public String getChNFe() {
		return chNFe;
	}

	public void setChNFe(String chNFe) {
		this.chNFe = chNFe;
	}

	public TipoEventoManifestDest getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEventoManifestDest tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getxJust() {
		return xJust;
	}

	public void setxJust(String xJust) {
		this.xJust = xJust;
	}

}
