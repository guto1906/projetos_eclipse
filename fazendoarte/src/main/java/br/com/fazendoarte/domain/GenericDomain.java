package br.com.fazendoarte.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//ocultar o warnig
@SuppressWarnings("serial")
//informa que a classe não é uma tabela
//mas será utilizada por outras
@MappedSuperclass
public class GenericDomain implements Serializable {
	//informa que o atributo é uma chave primaria
	@Id
	//para ser gerada pelo banco
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	

}
