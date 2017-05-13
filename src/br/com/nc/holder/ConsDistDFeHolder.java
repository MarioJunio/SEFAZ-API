package br.com.nc.holder;

import java.math.BigDecimal;
import java.util.Date;

public class ConsDistDFeHolder {

	public enum TipoNF {
		ENTRADA("Entrada"), SAIDA("Saída");

		private String descricao;

		private TipoNF(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}

	}

	public enum SituacaoNFe {
		AUTORIZADO("Autorizado"), DENEGADO("Denegado"), CANCELADO("Cancelado");

		private String descricao;

		private SituacaoNFe(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}

	}

	private boolean resumo;
	private String chNFe;
	private String nomeEmitente;
	private Date dataEmissao;
	private TipoNF tipoNf;
	private BigDecimal valor;
	private Date dataRecebimento;
	private SituacaoNFe situacaoNFe;

	public String getChNFe() {
		return chNFe;
	}

	public void setChNFe(String chNFe) {
		this.chNFe = chNFe;
	}

	public String getNomeEmitente() {
		return nomeEmitente;
	}

	public void setNomeEmitente(String nomeEmitente) {
		this.nomeEmitente = nomeEmitente;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public TipoNF getTipoNf() {
		return tipoNf;
	}

	public void setTipoNf(TipoNF tipoNf) {
		this.tipoNf = tipoNf;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public SituacaoNFe getSituacaoNFe() {
		return situacaoNFe;
	}

	public void setSituacaoNFe(SituacaoNFe situacaoNFe) {
		this.situacaoNFe = situacaoNFe;
	}

	public boolean isResumo() {
		return resumo;
	}

	public void setResumo(boolean resumo) {
		this.resumo = resumo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chNFe == null) ? 0 : chNFe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsDistDFeHolder other = (ConsDistDFeHolder) obj;
		if (chNFe == null) {
			if (other.chNFe != null)
				return false;
		} else if (!chNFe.equals(other.chNFe))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConsDistDFeHolder [resumo=" + resumo + ", chNFe=" + chNFe + ", nomeEmitente=" + nomeEmitente + ", dataEmissao=" + dataEmissao + ", tipoNf=" + tipoNf
				+ ", valor=" + valor + ", dataRecebimento=" + dataRecebimento + ", situacaoNFe=" + situacaoNFe + "]";
	}

}
