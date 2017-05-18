package br.com.fazendoarte.dao;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.fazendoarte.domain.Fabricante;
import br.com.fazendoarte.domain.Produto;

public class ProdutoDAOTeste {
	@Test
	public void salvar(){
		Long codigoFabricante1 = 1L;
		//Long codigoFabricante2 = 2L;
		Long codigoFabricante3 = 3L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante1 = fabricanteDAO.buscar(codigoFabricante1);
		//Fabricante fabricante2 = fabricanteDAO.buscar(codigoFabricante2);
		Fabricante fabricante3 = fabricanteDAO.buscar(codigoFabricante3);
		
		
		
		Produto produto1 = new Produto();
		produto1.setDescricao("Massa de Biscuit Preta");
		produto1.setFabricante(fabricante3);
		produto1.setPreco(new BigDecimal("10.50"));
		produto1.setQuanditade(new Short("8"));
		
		Produto produto2 = new Produto();
		produto2.setDescricao("Tinta Óleo");
		produto2.setFabricante(fabricante1);
		produto2.setPreco(new BigDecimal("15.66"));
		produto2.setQuanditade(new Short("10"));
		
		Produto produto3 = new Produto();
		produto3.setDescricao("Pincel nº 8");
		produto3.setFabricante(fabricante1);
		produto3.setPreco(new BigDecimal("7.98"));
		produto3.setQuanditade(new Short("10"));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto1);
		produtoDAO.salvar(produto2);
		produtoDAO.salvar(produto3);
	}

}
