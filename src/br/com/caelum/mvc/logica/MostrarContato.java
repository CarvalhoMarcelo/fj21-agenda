package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class MostrarContato implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		Connection conn = (Connection) req.getAttribute("connectionFilter");
		ContatoDao dao;
		List<Contato> lista = new ArrayList<Contato>();
		try {			
			dao = new ContatoDao(conn);
			lista = dao.mostra(Long.parseLong(req.getParameter("id")));			
		    req.setAttribute("contato", lista);		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "WEB-INF/jsp/mostra-contato.jsp";
	}
}
