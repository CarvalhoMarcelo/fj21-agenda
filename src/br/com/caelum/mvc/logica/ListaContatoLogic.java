package br.com.caelum.mvc.logica;


import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class ListaContatoLogic implements Logica {
	public String executa (HttpServletRequest req, HttpServletResponse resp) {
		List<Contato> lista;
		try {
			lista = new ContatoDao((Connection) req.getAttribute("connectionFilter")).getLista();
			req.setAttribute("contatos", lista);			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return "/WEB-INF/jsp/lista-contatos.jsp";
	}
	
	
}
