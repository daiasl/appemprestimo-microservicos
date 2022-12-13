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
		<h3>Cadastramento de Empréstimos</h3>
		
		<h4><a href="/Emprestimo">Novo cadastro</a></h4>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>id</th>
					<th>Data do Empréstimo</th>
					<th>Data de Devolução</th>
					<th>Solicitante</th>
					<th>Produtos</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${listagemEmprestimo}">
					<tr>
						<td>${e.id}</td>
						<td>${e.dataEmprestimo}</td>
						<td>${e.dataDevolucao}</td>
						<td>${e.solicitante.nome}</td>
						<td>${e.produtos.size()}</td>
						<td><a href="/Emprestimo/${e.id}/Excluir">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>