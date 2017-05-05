package br.com.fazendoarte.dao;

import org.junit.Test;

import br.com.fazendoarte.domain.Cidade;
import br.com.fazendoarte.domain.Pessoa;

public class PessoaDAOTeste {
	@Test
	public void salvar(){
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade1 = cidadeDAO.buscar(1L);
		Cidade cidade3 = cidadeDAO.buscar(3L);
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setCelular("(13)12345-1234");
		pessoa1.setCep("17000-000");
		pessoa1.setCidade(cidade1);
		//pessoa1.setComplemento(complemento);
		pessoa1.setCpf("111111111");
		pessoa1.setEmail("algumacoisa@dominio");
		pessoa1.setNome("Alberto Silva");
		pessoa1.setRg("11111-11");
		pessoa1.setRua("Primeira Rua");
		pessoa1.setTelefone("(13)12345-1234");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setCelular("(21)12345-1234");
		pessoa2.setCep("17000-000");
		pessoa2.setCidade(cidade3);
		pessoa2.setComplemento("complemento");
		pessoa2.setCpf("1111111111");
		pessoa2.setEmail("algumacoisa@dominio");
		pessoa2.setNome("Alberto Silva");
		pessoa2.setRg("11111-11");
		pessoa2.setRua("Segunda Rua");
		pessoa2.setTelefone("(21)12345-1234");
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa1);
		pessoaDAO.salvar(pessoa2);
	}

}
