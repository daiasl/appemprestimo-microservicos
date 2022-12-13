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
		<h2>Cadastramento de Materiais Digitais</h2>
		<form action="/MaterialDigital/Incluir" method="post">			
			<div class="mb-3 mt-3">
				<label>Doi:</label> <input type="text" class="form-control"
				    placeholder="Entre com o código DOI" name="doi">
			</div>
			<div class="mb-3 mt-3">
				<label>Ano:</label> <input type="number" class="form-control"
					placeholder="Entre com o ano" name="ano">
			</div>
			<div class="mb-3 mt-3">
				<label>Volume:</label> <input type="number" class="form-control"
					placeholder="Entre com o número do volume" name="volume">
			</div>			
			<div class="mb-3 mt-3">
				<label>LinkDoi:</label> <input type="text" class="form-control"
					placeholder="Entre com o link DOI" name="linkDoi">
			</div>
			<c:import url="/WEB-INF/jsp/Produto/cadastro.jsp"/>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>
</body>
</html>