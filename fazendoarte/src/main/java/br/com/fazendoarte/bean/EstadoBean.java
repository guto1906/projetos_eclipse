package br.com.fazendoarte.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.fazendoarte.dao.EstadoDAO;
import br.com.fazendoarte.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	private Estado estado;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

		} catch (Exception e) {
			Messages.addGlobalInfo(e.getMessage());
			e.printStackTrace();
		}

	}

	public void novo() {
		estado = new Estado();

	}

	public void salvar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);

			String msgsumaria = "Estado: " + estado.getNome() + " Sigla: " + estado.getSigla();
			/*
			 * String msgsdetalhada =
			 * "Estamos testando a menssagem do botão salvar"; FacesMessage
			 * menssagem = new FacesMessage(FacesMessage.SEVERITY_FATAL,
			 * msgsumaria, msgsdetalhada); FacesContext contexto =
			 * FacesContext.getCurrentInstance(); contexto.addMessage(null,
			 * menssagem);
			 */
			Messages.addGlobalInfo(msgsumaria);
			novo();
			listar();
		} catch (Exception e) {
			Messages.addGlobalInfo(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento){		
		estado = (Estado) evento.getComponent().getAttributes().get("estadoExcluir");
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);

			String msgsumaria = "Estado: " + estado.getNome() + " Sigla: " + estado.getSigla() + "Excluido";
			//String msgsumaria = "Estado Excluido";
			/*
			 * String msgsdetalhada =
			 * "Estamos testando a menssagem do botão salvar"; FacesMessage
			 * menssagem = new FacesMessage(FacesMessage.SEVERITY_FATAL,
			 * msgsumaria, msgsdetalhada); FacesContext contexto =
			 * FacesContext.getCurrentInstance(); contexto.addMessage(null,
			 * menssagem);
			 */
			Messages.addGlobalInfo(msgsumaria);
			listar();
		} catch (Exception e) {
			Messages.addGlobalInfo(e.getMessage());
			e.printStackTrace();
		}		
	}
	
	public void editar(ActionEvent evento){		
		estado = (Estado) evento.getComponent().getAttributes().get("estadoEditar");				
	}

}
