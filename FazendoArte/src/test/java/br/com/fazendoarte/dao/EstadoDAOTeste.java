package br.com.fazendoarte.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fazendoarte.domain.Estado;

public class EstadoDAOTeste {
	// Criar um metodo salvar para testar
	@Test
	@Ignore
	public void salvar() {
		// criar um estado
		Estado estado1 = new Estado();
		estado1.setNome("São Paulo");
		estado1.setSigla("SP");

		Estado estado2 = new Estado();
		estado2.setNome("Rio de Janeiro");
		estado2.setSigla("RJ");

		Estado estado3 = new Estado();
		estado3.setNome("Minas Gerais");
		estado3.setSigla("MG");
		// criar um estado dao
		EstadoDAO e = new EstadoDAO();
		e.salvar(estado1);
		e.salvar(estado2);
		e.salvar(estado3);
		System.out.println("Encerra o salvar");
	}

	@Test
	public void listar() {
		// criar um estado
		Estado estado1 = new Estado();
		estado1.setNome("São Paulo");
		estado1.setSigla("SP");

		Estado estado2 = new Estado();
		estado2.setNome("Rio de Janeiro");
		estado2.setSigla("RJ");

		Estado estado3 = new Estado();
		estado3.setNome("Minas Gerais");
		estado3.setSigla("MG");
		// criar um estado dao
		EstadoDAO e = new EstadoDAO();
		e.salvar(estado1);
		e.salvar(estado2);
		e.salvar(estado3);

		List<Estado> resultado = e.listar();
		for (Estado estado : resultado) {
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
		System.out.println("Encerra o Listar");

	}

}
