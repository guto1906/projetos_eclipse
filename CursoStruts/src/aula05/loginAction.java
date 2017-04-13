package aula05;

import com.opensymphony.xwork2.ActionSupport;

import util.ControleLogin;
import util.Funcionario;

public class loginAction extends ActionSupport {
	private static final String GERENTE = "gerente";
	private static final String DESENVOLVEDOR = "desenvolvedor";
	private static final String DIRETOR = "diretor";	
	private String login;
	private String senha;
	private Funcionario funcionario;
	private String mensagemErro;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public String getMensagemErro() {
		return mensagemErro;
	}
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}
	@Override
	public String execute() throws Exception {
		funcionario = ControleLogin.recuperarPorLogin(login);
		if(funcionario == null || !funcionario.getSenha().equals(senha)){
			mensagemErro = "Login ou senha não Existe!!";
			return INPUT;
		} else{
			switch (funcionario.getTipo()) {
			case Funcionario.TIPO_DESENVOLVEDOR: return DESENVOLVEDOR;
			case Funcionario.TIPO_DIRETOR: return DIRETOR;
			case Funcionario.TIPO_GERENTE: return GERENTE;
			default:
				mensagemErro = "Tipo não existente";
				return INPUT;
			}
		}
	}
	
	
	

}
