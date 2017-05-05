package br.com.fazendoarte.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fazendoarte.domain.ItemVenda;
import br.com.fazendoarte.domain.Produto;
import br.com.fazendoarte.domain.Venda;

public class ItemVendaDAOTeste {
	@Test
	@Ignore
	public void salvar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto1 = produtoDAO.buscar(1L);
		Produto produto2 = produtoDAO.buscar(2L);
		Produto produto3 = produtoDAO.buscar(3L);
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(1L);
		
		ItemVenda itemVenda1 = new ItemVenda();
		itemVenda1.setProduto(produto1);
		itemVenda1.setQuantidade(new Short("10"));
		itemVenda1.setValorParcial(new BigDecimal("10.00"));
		itemVenda1.setVenda(venda);
		
		ItemVenda itemVenda2 = new ItemVenda();
		itemVenda2.setProduto(produto2);
		itemVenda2.setQuantidade(new Short("5"));
		itemVenda2.setValorParcial(new BigDecimal("8.00"));
		itemVenda2.setVenda(venda);
		
		ItemVenda itemVenda3 = new ItemVenda();
		itemVenda3.setProduto(produto3);
		itemVenda3.setQuantidade(new Short("7"));
		itemVenda3.setValorParcial(new BigDecimal("12.00"));
		itemVenda3.setVenda(venda);
		
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		itemVendaDAO.salvar(itemVenda1);
		itemVendaDAO.salvar(itemVenda2);
		itemVendaDAO.salvar(itemVenda3);
	}

}
