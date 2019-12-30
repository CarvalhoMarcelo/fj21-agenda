package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AdicionaContatoLogic implements Logica{
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		try {			
			Connection conn = (Connection) req.getAttribute("connectionFilter");
			ContatoDao dao = new ContatoDao(conn );
			Contato contato = new Contato();
			contato.setNome(req.getParameter("nome"));
			contato.setEndereco(req.getParameter("endereco"));
			contato.setEmail(req.getParameter("email"));
			
			String DataTexto = req.getParameter("dataNascimento");
			Calendar dataNascimento = null;					
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(DataTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
					
			contato.setDataNascimento(dataNascimento);
			
			dao.adiciona(contato);
			
		}catch (Exception e){
//			throw new RuntimeException (e);
			e.printStackTrace();
		}
				
		return "mvc?logica=ListaContatoLogic";
		
	}

}
