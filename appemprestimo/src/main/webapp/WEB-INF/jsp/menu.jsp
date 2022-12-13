<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<nav class="navbar navbar-expand-sm bg-light navbar-light">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active" href="/">Home</a>
				</li>

				<c:if test="${not empty user}">
					<li class="nav-item"><a class="nav-link" href="/Usuario/lista">Usuário</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/Livro/lista">Livro</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="/MaterialDigital/lista">Material Digital</a></li>
					<li class="nav-item"><a class="nav-link" href="/Revista/lista">Revista</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/Produto/lista">Produto</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="/Emprestimo/lista">Emprestimo</a></li>
					<li class="nav-item"><a class="nav-link" href="/Solicitante/lista">Solicitante</a>
					</li>
				</c:if>
			</ul>

			<ul class="navbar-nav">
				<c:if test="${empty user}">
					<li class="nav-item"><a class="nav-link" href="/Usuario">Signup</a></li>					
					<li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
				</c:if>
				<c:if test="${not empty user}">
				<li class="nav-item"><a class="nav-link" href="/logout">Logout,${user.nome}</a></li>
				</c:if>
			</ul>
		</div>
	</nav>
</html>