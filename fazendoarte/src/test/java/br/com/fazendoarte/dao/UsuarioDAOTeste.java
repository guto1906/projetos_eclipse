package br.com.fazendoarte.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fazendoarte.domain.Pessoa;
import br.com.fazendoarte.domain.Usuario;

public class UsuarioDAOTeste {
	@Test
	@Ignore
	public void salvar(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		System.out.println("Usuario Encontrado");
		System.out.println("Nome " + pessoa.getNome());
		System.out.println("CPF " + pessoa.getCpf());
		
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);
		usuario.setSenha("1234");
		usuario.setTipo('A');
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		System.out.println("Usuario Cadastrado com sucesso");
		
	}

}
