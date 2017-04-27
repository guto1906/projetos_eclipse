package br.com.fazendoarte.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fazendoarte.domain.Cidade;
import br.com.fazendoarte.domain.Estado;

public class CidadeDAOTeste {

	// Criar um metodo salvar para testar
	@Test
	@Ignore
	public void salvar() {
		// localizar os objetos cidades que são as chaves estrangeiras
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado1 = estadoDAO.buscar(1L);
		Estado estado2 = estadoDAO.buscar(3L);
		Estado estado3 = estadoDAO.buscar(2L);

		// criar uma cidade e utilizar o seu respectivo estado localizado
		Cidade cidade1 = new Cidade();
		cidade1.setNome("Praia Grande");
		cidade1.setEstado(estado1);
		Cidade cidade2 = new Cidade();
		cidade2.setNome("Belo Horizonte");
		cidade2.setEstado(estado2);
		Cidade cidade3 = new Cidade();
		cidade3.setNome("Rio de Janeiro");
		cidade3.setEstado(estado3);

		// utilizar o metodo salvar do CidadeDAO para salvar as cidades
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade1);
		cidadeDAO.salvar(cidade2);
		cidadeDAO.salvar(cidade3);

		System.out.println("Encerra o salvar");
	}

	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();
		for (Cidade cidade : resultado) {
			System.out.println(cidade.getNome()+"-"+cidade.getEstado().getSigla());
		}
		System.out.println("Encerra o Listar");
	}

	@Test
	@Ignore
	public void Buscar() {
		Long codigo = 1L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		if (cidade != null) {
			System.out.println(cidade.getNome()+"-"+cidade.getEstado().getSigla());
		} else {
			System.err.println("Registro não encontrado");
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		if (cidade != null) {
			cidadeDAO.excluir(cidade);
		} else {
			System.err.println("Registro não encontrado");
		}
	}

	@Test
	public void editar() {
		Long codigoCidade = 2L;
		Long codigoEstado = 5L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);		
		if (cidade != null) {
			EstadoDAO estadoDAO = new EstadoDAO();
			Estado estado = estadoDAO.buscar(codigoEstado);
			cidade.setNome("Brasilândia");
			cidade.setEstado(estado);
			cidadeDAO.editar(cidade);
		} else {
			System.err.println("Registro não encontrado");
		}
	}

}
