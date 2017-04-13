package util;

import java.util.HashMap;
import java.util.Map;

public class ControleLogin {
	private static Map<String, Funcionario> funcionarios = new HashMap<String, Funcionario>();
	static{
		//monta o banco de dados
		
		Funcionario f = new Funcionario("Zezinho", "zezinho", "123", Funcionario.TIPO_GERENTE);
		funcionarios.put(f.getLogin(), f);
		f = new Funcionario("Luizinho", "luizinho", "123", Funcionario.TIPO_DIRETOR);
		funcionarios.put(f.getLogin(), f);
		f = new Funcionario("Huguinho", "huguinho", "123", Funcionario.TIPO_DESENVOLVEDOR);
		funcionarios.put(f.getLogin(), f);
		f = new Funcionario("Robertinho", "robertinho", "123", Funcionario.TIPO_DESENVOLVEDOR);
		funcionarios.put(f.getLogin(), f);
		f = new Funcionario("Manequinho", "manequinho", "123", Funcionario.TIPO_GERENTE);
		funcionarios.put(f.getLogin(), f);
	}
	//obtem um funcionario por login
	public static Funcionario recuperarPorLogin(String login){
		return funcionarios.get(login);
	}

}
