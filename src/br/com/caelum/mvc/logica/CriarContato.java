package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CriarContato implements Logica{
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		return "WEB-INF/jsp/adiciona-contato.jsp";
	}

}
