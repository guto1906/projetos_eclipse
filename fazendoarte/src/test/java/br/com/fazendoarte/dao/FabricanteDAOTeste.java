package br.com.fazendoarte.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fazendoarte.domain.Fabricante;

public class FabricanteDAOTeste {
	// Criar um metodo salvar para testar
	@Test
	@Ignore
	public void salvar() {
		// criar um Fabricante
		Fabricante fabricante1 = new Fabricante();
		fabricante1.setDescricao("ABCD");
		Fabricante fabricante2 = new Fabricante();
		fabricante2.setDescricao("EFGH");
		Fabricante fabricante3 = new Fabricante();
		fabricante3.setDescricao("IJKLM");
		// criar um Fabricante dao
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante1);
		fabricanteDAO.salvar(fabricante2);
		fabricanteDAO.salvar(fabricante3);

		System.out.println("Encerra o salvar");
	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();
		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
		System.out.println("Encerra o Listar");
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 7L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		if (fabricante != null) {
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		} else {
			System.err.println("Registro não encontrado");
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		if (fabricante != null) {
			fabricanteDAO.excluir(fabricante);
		} else {
			System.err.println("Registro não encontrado");
		}
	}

	@Test
	public void editar() {
		Long codigo = 5L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		if (fabricante != null) {
			fabricante.setDescricao("#$%&");
			fabricanteDAO.editar(fabricante);
		} else {
			System.err.println("Registro não encontrado");
		}
	}

}
