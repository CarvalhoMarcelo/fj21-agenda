package br.com.caelum.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.jdbc.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter{
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		try {
			Connection connection = new ConnectionFactory().getConnection();
			req.setAttribute("connectionFilter", connection);			
			chain.doFilter(req, resp);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
