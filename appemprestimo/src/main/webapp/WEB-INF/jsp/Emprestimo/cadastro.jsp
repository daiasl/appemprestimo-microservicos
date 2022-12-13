<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>AppEmprestimo</title>
</head>
<body>
	<c:set var="ativaBotao" value=""/>
	<c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container mt-3">
		<h2>Cadastramento de Empr�stimos</h2>
		<form action="/Emprestimo/Incluir" method="post">			
			<div class="mb-3 mt-3">
				<label>Data de Devolu��o:</label> <input type="datetime-local"
					class="form-control" placeholder="Entre com a data de devolu��o"
					name="dataDevolucao">
			</div>
			<div class="mb-3">
				<c:if test="${not empty solicitantes}"> 
					<label>Solicitante:</label> 
					<select name="solicitante" class="form-control" id="sel1">
						<c:forEach var="s" items="${solicitantes}">					
							<option value="${s.id}" >${s.nome}</option>						
						</c:forEach>
					</select>
				</c:if>
				<c:if test="${empty solicitantes}"> 
					<label>N�o existem solicitantes cadastrados!</label>
					<c:set var="ativaBotao" value="disabled"/>				
				</c:if>
			</div>
			<div class="mb-3">
				<c:if test="${not empty produtos}">
					<label>Produtos:</label>
					<c:forEach var="p" items="${produtos}">
						<div class="checkbox">
							<label><input type="checkbox" name="produtos" value="${p.id}">${p.titulo}</label>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty produtos}"> 
					<label>N�o existem produtos cadastrados!</label>
					<c:set var="ativaBotao" value="disabled"/>				
				</c:if>
			</div>
			<button ${ativaBotao} type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>
</body>
</html>