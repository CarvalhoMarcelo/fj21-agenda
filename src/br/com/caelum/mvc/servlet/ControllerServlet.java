package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

@SuppressWarnings("serial")
@WebServlet ("/mvc")
public class ControllerServlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String nomeDaClasse = "br.com.caelum.mvc.logica." + req.getParameter("logica");
		
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			@SuppressWarnings("deprecation")
			Logica logica = (Logica) classe.newInstance();						
						
			String pagina = logica.executa(req, resp);			
			RequestDispatcher rd = req.getRequestDispatcher(pagina);			
			rd.forward(req, resp);						
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}	
}
