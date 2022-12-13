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
		<h2>Cadastramento de Livros</h2>
		<form action="/Livro/Incluir" method="post">		
			<div class="mb-3 mt-3">
				<label>Isbn:</label> <input type="text" class="form-control"
				    placeholder="Entre com o código ISBN" name="isbn">
			</div>
			<div class="mb-3 mt-3">
				<label>Volume:</label> <input type="number" class="form-control"
					placeholder="Entre com o número do volume" name="volume">
			</div>	
			<div class="mb-3 mt-3">
				<label>Edição:</label> <input type="number" class="form-control"
					placeholder="Entre com o número da edição" name="edicao">
			</div>
			<div class="mb-3 mt-3">
				<label>Ano de Publicação:</label> <input type="number" class="form-control"
					placeholder="Entre com o ano" name="anoPublicacao">
			</div>					
			<div class="mb-3 mt-3">
				<label>Nome do Autor:</label> <input type="text" class="form-control"
					placeholder="Entre com o nome do autor" name="nomeAutor">
			</div>
			<c:import url="/WEB-INF/jsp/Produto/cadastro.jsp"/>			
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>
</body>
</html>