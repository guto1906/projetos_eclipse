package br.com.fazendoarte.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import br.com.fazendoarte.domain.Cliente;
import br.com.fazendoarte.domain.Pessoa;

public class ClienteDAOTeste {

	@Test
	public void salvar() throws ParseException {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa1 = pessoaDAO.buscar(1L);
		Pessoa pessoa2 = pessoaDAO.buscar(2L);

		Cliente cliente1 = new Cliente();
		cliente1.setDataCadastro(new Date());
		cliente1.setLiberado(true);
		cliente1.setPessoa(pessoa1);

		Cliente cliente2 = new Cliente();
		cliente2.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("22/04/2017"));
		cliente2.setLiberado(false);
		cliente2.setPessoa(pessoa2);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente1);
		clienteDAO.salvar(cliente2);
	}

}
