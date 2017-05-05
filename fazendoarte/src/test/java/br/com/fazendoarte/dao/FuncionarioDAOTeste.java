package br.com.fazendoarte.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fazendoarte.domain.Funcionario;
import br.com.fazendoarte.domain.Pessoa;

public class FuncionarioDAOTeste {
	@Test
	@Ignore
	public void salvar() throws ParseException{
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		System.out.println("Funcionario Encontrado");
		System.out.println("Nome " + pessoa.getNome());
		System.out.println("CPF " + pessoa.getCpf());
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCarteiraTrabelho("AB2017-500");
		funcionario.setDataAdminssao(new SimpleDateFormat("dd/MM/yyyy").parse("03/05/2017"));
		funcionario.setPessoa(pessoa);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.salvar(funcionario);
		System.out.println("Funcionario Inserido");
		
	}

}
