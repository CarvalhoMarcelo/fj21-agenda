<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="agenda" %>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Agenda - Mostra Contato</title>
		
		<script src="resources/js/jquery.js"></script>
		<script src="resources/js/jquery-ui.js"></script>
		<link href="resources/css/jquery.css" rel="stylesheet"/>		
		
		<style>		
			label {
			  padding: 12px 12px 12px 0;
			  display: inline-block;
			}		
			.col-25 {
			  float: left;
			  width: 15%;
			  margin-top: 6px;
			}			
			.col-75 {
			  float: left;
			  width: 85%;
			  margin-top: 6px;
			}			
			#nome{
				width: 50%;
			}
			input[name=endereco]{
				width: 50%;
			}			
			#email{
				width: 50%;
			}						
			input[type=submit] {
			  background-color: #4CAF50;
			  color: white;
			  padding: 12px 20px;
			  border: none;
			  border-radius: 4px;
			  cursor: pointer;
			  float: left;
			}			
			input[type=submit]:hover {
			  background-color: #45a049;
			}			
			/* Clear floats after the columns */
			.row:after {
			  content: "";
			  display: table;
			  clear: both;
			}		
		</style>		
		
		
	</head>
	<body>
		<c:import url="cabecalho.jsp"></c:import>
		
		<form action="mvc?logica=AlteraContatoLogic" method="post">			
			<c:forEach var="contato" items="${contato}">			
				<h3>Alterar Contato: ${contato.id}</h3><br>			
				<input type="hidden" name="id" id="id" value="${contato.id}"/>					
				
				<div class="row">			
					<div class="col-25">
						<label for="nome">Nome:</label>				
					</div>
					<div class="col-75">
						<input type="text" id="nome" name="nome" placeholder="Nome" value="${contato.nome}"/>
					</div>
				</div>	
				<div class="row">	
					<div class="col-25">
						<label for="endereco">Endereço:</label>				
					</div>
					<div class="col-75">
						<input type="text" id="endereco" name="endereco" placeholder="Endereco" value="${contato.endereco}"/>
					</div>
				</div>
				<div class="row">			
					<div class="col-25">
						<label for="email">Email:</label>				
					</div>
					<div class="col-75">
						<input type="text" id="email" name="email" placeholder="Email" value="${contato.email}"/>
					</div>		
				</div>
				<div class="row">	
					<div class="col-25">
						<label for="dataNascimento">Data de Nascimento:</label>				
					</div>
					<div class="col-75">
						<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" var="minhaData"/>
						<agenda:campoData identificador="dataNascimento" completar="off"  data="${minhaData}"></agenda:campoData>
<%-- 						<input type="hidden" name="dataNascimento" value="${minhaData}"/>			 --%>
					</div>							
				</div>				
			</c:forEach>
			<br>			
			<input type="submit" value="Gravar"/>	
		</form>		
		
		<c:import url="rodape.jsp"></c:import>
		
	</body>
</html>