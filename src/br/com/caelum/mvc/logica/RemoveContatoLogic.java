package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;

public class RemoveContatoLogic implements Logica{
	public String executa(HttpServletRequest req, HttpServletResponse resp) {		
		Connection connection = (Connection) req.getAttribute("connectionFilter");
		ContatoDao dao;
		try {
			Long id = Long.parseLong(req.getParameter("id"));		
			dao = new ContatoDao(connection);
			dao.remove(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "mvc?logica=ListaContatoLogic";		
	}
}
