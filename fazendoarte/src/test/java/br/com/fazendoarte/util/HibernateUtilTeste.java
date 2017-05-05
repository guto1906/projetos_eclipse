package br.com.fazendoarte.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTeste {
	@Test
	public void conectar() {
		// Capturar uma sessao aberta
		Session sessao = HibernateUtil.getFabricadesessoes().openSession();
		// Fecha a sessao capturada
		sessao.close();
		// Fecha a sessao criada
		HibernateUtil.getFabricadesessoes().close();
	}

}
