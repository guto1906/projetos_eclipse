package br.com.fazendoarte.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.fazendoarte.dao.FabricanteDAO;
import br.com.fazendoarte.dao.ProdutoDAO;
import br.com.fazendoarte.domain.Fabricante;
import br.com.fazendoarte.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {
	Produto produto;
	List<Produto> produtos;
	List<Fabricante> fabricantes;
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	
	@PostConstruct
	public void listar(){
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar();
			
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao carregar lista de Produtos");
			e.printStackTrace();
		}
		
	}
	
	public void novo(){
		produto = new Produto();
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();
			
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao carregar lista de Fabricantes");
			e.printStackTrace();
		}
		
	}
	
	public void salvar(){
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.merge(produto);
			novo();
			listar();
			
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao salvar Produto");
			e.printStackTrace();
		}
		
	}
	
	public void editar(ActionEvent evento){
		produto = (Produto) evento.getComponent().getAttributes().get("produtoEditar");
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();
			
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao carregar lista de Fabricantes");
			e.printStackTrace();
		}
		
	}
	
	public void excluir(ActionEvent evento){
		produto = (Produto) evento.getComponent().getAttributes().get("produtoExcluir");
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produto);
			listar();
			
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao salvar Produto");
			e.printStackTrace();
		}
	}

}
