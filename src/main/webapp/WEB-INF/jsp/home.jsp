<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>AppVenda</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active" href="/">AppVenda</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/vendedor/lista">Vendedores</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/produto/lista">Produtos</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/bebida/lista">Bebidas</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/jogo/lista">Jogos</a>
				</li>
			</ul>
			<c:if test="${not empty listagem}">
				<form class="d-flex" action="/${rota}/pesquisar">
					<input class="form-control me-2" type="text" name="campoBusca"
						placeholder="Search" aria-label="Search" />
					<button class="btn btn-primary" type="submit">Search</button>
				</form>
			</c:if>
		</div>
	</nav>

	<div class="container mt-3">

		<span class="badge rounded-pill bg-primary">Vendedor:
			${qtdeVendedor}</span> <span class="badge rounded-pill bg-secondary">Produto:
			${qtdeProduto}</span> <span class="badge rounded-pill bg-success">Bebidas:
			${qtdeBebida}</span> <span class="badge rounded-pill bg-danger">Jogos:
			${qtdeJogo}</span>

		<c:if test="${not empty listagem}">
			<h2>AppVenda</h2>
			<p>Gestão de vendas de produtos:</p>
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th>${titulo}</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${listagem}">
						<tr>
							<td>${item}</td>
							<td><a href="/${rota}/${item.id}/excluir">excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty listagem}">
			<form action="/informacao/incluir" method="post" class="mt-2 mb-2">
				<div class="row">
					<div class="col">
						<input type="text" class="form-control"
							placeholder="Entre com o campo" name="campo" />
					</div>
					<div class="col">
						<input type="text" class="form-control"
							placeholder="Entre com a descrição" name="descricao" />
					</div>
					<div class="col">
						<button class="btn btn-primary" type="submit">Cadastrar</button>
					</div>
				</div>
			</form>

			<c:if test="${not empty informacoes}">
				<table class="table">
					<thead class="table-dark">
						<tr>
							<th>Informações:</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${informacoes}">
							<tr>
								<td>${item}</td>
								<td><a href="/informacao/${item.id}/excluir">excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</c:if>


		<c:if test="${not empty objeto}">
			<hr />
			<div class="alert alert-success">
				<strong>Sucesso!</strong> ${objeto}
			</div>
		</c:if>
	</div>
</body>
</html>