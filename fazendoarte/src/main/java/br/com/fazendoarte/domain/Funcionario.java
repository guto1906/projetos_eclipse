package br.com.fazendoarte.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericDomain {
	@Column(nullable = false, length = 50)
	private String carteiraTrabelho;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAdminssao;
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	public String getCarteiraTrabelho() {
		return carteiraTrabelho;
	}

	public void setCarteiraTrabelho(String carteiraTrabelho) {
		this.carteiraTrabelho = carteiraTrabelho;
	}

	public Date getDataAdminssao() {
		return dataAdminssao;
	}

	public void setDataAdminssao(Date dataAdminssao) {
		this.dataAdminssao = dataAdminssao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
