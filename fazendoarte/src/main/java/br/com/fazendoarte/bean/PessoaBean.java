package br.com.fazendoarte.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.fazendoarte.dao.EstadoDAO;
import br.com.fazendoarte.dao.PessoaDAO;
import br.com.fazendoarte.domain.Cidade;
import br.com.fazendoarte.domain.Estado;
import br.com.fazendoarte.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {
	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> pessoas;
	private List<Cidade> cidades;
	private List<Estado> estados;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {

		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();

		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao carregar lista de pessoas");
			e.printStackTrace();
		}

	}

	public void novo() {
		pessoa = new Pessoa();

		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao carregar lista de Estados");
			e.printStackTrace();
		}

		cidades = new ArrayList<Cidade>();

	}

	public void salvar() {

	}

	public void excluir(ActionEvent evento) {

	}

	public void editar(ActionEvent evento) {

	}

}
