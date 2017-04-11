package cursostrus;

import com.opensymphony.xwork2.ActionSupport;


public class HelloWorld extends ActionSupport {
  private String mensagem = "Olá Mundo Struts";

public String getMensagem() {
	return mensagem;
}

@Override
public String execute() throws Exception {
    mensagem += " - " + new java.util.Date();	
 
	return super.execute();
}
  
  
  
}
