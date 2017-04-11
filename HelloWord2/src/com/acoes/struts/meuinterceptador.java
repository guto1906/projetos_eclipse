package com.acoes.struts;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class meuinterceptador extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String output = "Pre-Processando";
		System.out.println(output);
		
		String result = invocation.invoke();
		output = "Pos Processando";
		System.out.println(output);
		
		return result;
	}

}
