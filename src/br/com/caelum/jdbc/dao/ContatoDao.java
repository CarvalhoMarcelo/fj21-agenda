package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	
	private Connection conn;
	
	public ContatoDao(Connection connection) throws SQLException {
//		this.conn = new ConnectionFactory().getConnection();
		this.conn = connection;
	}
		
	public void adiciona(Contato contato) {
		String sql = "insert into contatos(nome, endereco, email, dataNascimento) " +
	                 "values (?, ?, ?, ?)";		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEndereco());
			stmt.setString(3, contato.getEmail());			
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.execute();
			stmt.close();						
		}catch(SQLException e) {
			throw new RuntimeException (e);
		}		
	}
	
	public List<Contato> getLista() throws SQLException {
		String sql = "select * from contatos";
		List<Contato> lista = new ArrayList<Contato>();
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Contato contato = new Contato();
			
			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEndereco(rs.getString("endereco"));
			contato.setEmail(rs.getString("email"));
			
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataNascimento"));
			contato.setDataNascimento(data);	
			
			lista.add(contato);			
		}
		
		rs.close();
		stmt.close();		
				
		return lista;		
	}
	
	
	public void altera(Contato contato) throws SQLException {		
		String sql = "update contatos set nome=?, endereco=?, email=?, dataNascimento=? " +
					 "where id = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEndereco());
		stmt.setString(3, contato.getEmail());
		stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
		stmt.setLong(5, contato.getId());
		
		stmt.execute();
		stmt.close();		
	}
	
	
	public List<Contato> mostra(Long id) {
		String sql = "select * from contatos where id=?";		
		PreparedStatement stmt;
		Contato contato = new Contato();
		
		List<Contato> lista = new ArrayList<Contato>();		
		
		try {
			stmt = conn.prepareStatement(sql);			
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {				
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setEmail(rs.getString("email"));
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("dataNascimento"));				
				contato.setDataNascimento(cal);			
				
				lista.add(contato);		
				
			}			
			rs.close();
			stmt.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return lista;		
	}	
	
	
	public void remove(Long id)  {		
		String sql = "delete from contatos where id = ?";
		
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);		
			stmt.setLong(1, id);			
			stmt.execute();
			stmt.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}	
}
