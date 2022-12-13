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

		<h3>Cadastramento de Livros</h3>
		
		<h4><a href="/Livro">Novo cadastro</a></h4>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Isbn</th>
					<th>Volume</th>
					<th>Edicao</th>
					<th>AnoPublicacao</th>
					<th>NomeAutor</th>
					<th>Titulo</th>
					<th>Estante</th>
					<th>CodigoBarras</th>
					<th>QtdDisponiveis</th>
					<th>QtdExemplares</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="l" items="${listagem}">
					<tr>
						<td>${l.id}</td>
						<td>${l.isbn}</td>
						<td>${l.volume}</td>
						<td>${l.edicao}</td>
						<td>${l.anoPublicacao}</td>
						<td>${l.nomeAutor}</td>
						<td>${l.titulo}</td>
						<td>${l.estante}</td>
						<td>${l.codigoBarras}</td>
						<td>${l.qtdDisponiveis}</td>
						<td>${l.qtdExemplares}</td>
						<td><a href="/Livro/${l.id}/Excluir">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>