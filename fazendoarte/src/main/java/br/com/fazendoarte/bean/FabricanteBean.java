package br.com.fazendoarte.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.fazendoarte.dao.FabricanteDAO;
import br.com.fazendoarte.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {
	private Fabricante fabricante;
	private List<Fabricante> fabricantes;
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	@PostConstruct
	public void listar() {

		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();

		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao Carregar lista de Fabricantes");
			e.printStackTrace();
		}

	}
	
	public void novo(){
		fabricante = new Fabricante();		
	}
	
	public void salvar(){
		
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.merge(fabricante);
			listar();
			novo();
			Messages.addGlobalInfo("Fabricante incluido com sucesso");

		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao incluir Fabricantes");
			e.printStackTrace();
		}
		
	}
	
	public void excluir(ActionEvent evento){
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteExcluir");
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.excluir(fabricante);
			listar();			
			Messages.addGlobalInfo("Fabricante excluido com sucesso");

		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao excluir Fabricante");
			e.printStackTrace();
		}
		
	}
	
	public void editar(ActionEvent evento){
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteEditar");	
	}

}
