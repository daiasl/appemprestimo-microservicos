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
	<c:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container mt-3">
		<c:if test="${not empty mensagem}">
			<div class="alert ${tipo}">
				<strong>Informação</strong> ${mensagem}
			</div>
		</c:if>

		<h3>Cadastramento de Produtos</h3>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Titulo</th>
					<th>Estante</th>
					<th>CodigoBarras</th>
					<th>QtdDisponiveis</th>
					<th>QtdExemplares</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${listagem}">
					<tr>
						<td>${p.id}</td>
						<td>${p.titulo}</td>
						<td>${p.estante}</td>
						<td>${p.codigoBarras}</td>
						<td>${p.qtdDisponiveis}</td>
						<td>${p.qtdExemplares}</td>
						<td><a href="/Produto/${p.id}/Excluir">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>