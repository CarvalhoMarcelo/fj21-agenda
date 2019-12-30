<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Agenda - Lista de Contatos</title>
	</head>
	<body>
		<%-- 	<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"/> --%>
	
		<c:import url="cabecalho.jsp"></c:import>
		<a href="mvc?logica=CriarContato">Adicionar Novo Contato</a>
		<br>	
		<p></p>
		<br>
		<table border=1>	
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Endereco</th>
				<th>Email</th>
				<th>Data de Nascimento</th>
			</tr>
			<c:forEach var="contato" items="${contatos}" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? 'e4e4e4' : 'ffffff' }">
					<td>${contato.id}</td>
					<td>${contato.nome}</td>
					<td>${contato.endereco}</td>
					<td>
						<c:if test="${not empty contato.email}">						
							<a href="mailto:${contato.email}">${contato.email}</a>					
						</c:if>
						<c:if test="${empty contato.email}">					
							EMAIL NÃO PREENCHIDO					
						</c:if>					
					</td>
					<td>
						<fmt:formatDate value="${contato.dataNascimento.time}"
							pattern="dd/MM/yyyy"/>
					</td>					
					<td>
						<input type="hidden" name="id" value="${contato.id}"/>
						<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Excluir</a>
					</td>
					<td>
						<a href="mvc?logica=MostrarContato&id=${contato.id}">Alterar</a>
					</td>	
				</tr>		
			</c:forEach>	
		</table>
		<c:import url="rodape.jsp"></c:import>
		
	</body>
</html>