package aula04;

import java.util.Date;
import com.opensymphony.xwork2.ActionSupport;

public class CalcularIdade extends ActionSupport {
	private String nmNome;
	private Date dtNacimento;
	private int idade;
	public String getNmNome() {
		return nmNome;
	}
	public void setNmNome(String nmNome) {
		this.nmNome = nmNome;
	}
	public Date getDtNacimento() {
		return dtNacimento;
	}
	public void setDtNacimento(Date dtNacimento) {
		this.dtNacimento = dtNacimento;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	@Override
	public String execute() throws Exception {
		idade = 35;
		return SUCCESS;
	}
	
	
	

}
