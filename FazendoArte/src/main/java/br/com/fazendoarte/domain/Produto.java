package br.com.fazendoarte.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Produto extends GenericDomain {
	@Column(length = 50, nullable = false)
	private String descricao;
	@Column(nullable = false)
	private Short quanditade;
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal preco;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Fabricante fabricante;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getQuanditade() {
		return quanditade;
	}

	public void setQuanditade(Short quanditade) {
		this.quanditade = quanditade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

}
