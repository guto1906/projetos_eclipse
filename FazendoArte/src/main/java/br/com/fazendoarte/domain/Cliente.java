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
public class Cliente extends GenericDomain {
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	@Column(nullable = false)
	private Boolean liberado;
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	

}
