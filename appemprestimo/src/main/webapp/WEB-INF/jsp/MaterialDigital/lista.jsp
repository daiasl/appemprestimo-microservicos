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
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<div class="container mt-3">
		<c:if test="${not empty mensagem}">
			<div class="alert ${tipo}">
			  <strong>Informação</strong> ${mensagem}
			</div>
		</c:if>
		
		<h3>Cadastramento de Material Digital</h3>
		
		<h4><a href="/MaterialDigital">Novo cadastro</a></h4>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>id</th>
					<th>Doi</th>
					<th>Ano</th>
					<th>Volume</th>
					<th>LinkDoi</th>
					<th>Titulo</th>
					<th>Estante</th>
					<th>CodigoBarras</th>
					<th>QtdDisponiveis</th>
					<th>QtdExemplares</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="m" items="${listagemMaterialDigital}">
					<tr>
						<td>${m.id}</td>
						<td>${m.doi}</td>
						<td>${m.ano}</td>
						<td>${m.volume}</td>
						<td>${m.linkDoi}</td>
						<td>${m.titulo}</td>
						<td>${m.estante}</td>
						<td>${m.codigoBarras}</td>
						<td>${m.qtdDisponiveis}</td>
						<td>${m.qtdExemplares}</td>
						<td><a href="/MaterialDigital/${m.id}/Excluir">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>