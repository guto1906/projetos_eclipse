package br.com.fazendoarte.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.fazendoarte.dao.CidadeDAO;
import br.com.fazendoarte.dao.EstadoDAO;
import br.com.fazendoarte.domain.Cidade;
import br.com.fazendoarte.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {
	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();

		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao carregar lista de cidades");
			e.printStackTrace();
		}

	}

	public void novo() {
		cidade = new Cidade();		
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao carregar lista de estados");	
			e.printStackTrace();
		}
	}
	
	public void salvar() {
			
		try {
						
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.merge(cidade);
			novo();
			listar();
			
			Messages.addGlobalInfo("Cidade salva com sucesso");			
			
			
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao salvar cidade");
			e.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento){
		cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeExcluir"); 
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.excluir(cidade);
			listar();
			Messages.addGlobalInfo("Cidade excluída com sucesso");
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao excluir a cidade");
			e.printStackTrace();
		}		
	}
	
	public void editar(ActionEvent evento){
		cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeEditar");		
		try {
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao editar o Estado");	
			e.printStackTrace();
		}
		
	}

}
