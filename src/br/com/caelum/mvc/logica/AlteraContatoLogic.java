package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AlteraContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		Connection conn = (Connection) req.getAttribute("connectionFilter");
		Contato contato = new Contato();		
		Date data;		
		ContatoDao dao;
		
		try {
			dao = new ContatoDao(conn);
			contato.setId(Long.parseLong(req.getParameter("id")));
			contato.setNome(req.getParameter("nome"));
			contato.setEndereco(req.getParameter("endereco"));
			contato.setEmail(req.getParameter("email"));

			data = new SimpleDateFormat("dd/MM/yyy").parse(req.getParameter("dataNascimento"));
			Calendar cal = Calendar.getInstance();
			cal.setTime(data);		
			contato.setDataNascimento(cal);

			dao.altera(contato);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}				
		return "mvc?logica=ListaContatoLogic";
	}	
	
}
