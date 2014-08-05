<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<layout:template>
	<jsp:attribute name="scriptsEspecificos">
</jsp:attribute>
	<jsp:body>
	<div class="well">
		<form class="form-inline"
				action="<c:url value="/produtoss/pesquisar"/>">
			<div class="form-group">
				<label for="codigo">Código</label>
				<input name="codigo" id="codigo" value="${codigo}" />
			</div>
  			<div class="form-group">
				<label for="nome">Nome</label>
				<input name="nome" id="nome" value="${nome}" autocomplete="off" />
			</div>
  			<div class="form-group">
				<button type="submit" class="btn btn-primary">
				<span class="glyphicon glyphicon-search"></span> Pesquisar</button>
			</div>
		</form>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<a href="${linkTo[ProdutoController].form}" class="btn btn-success">
			<span class="glyphicon glyphicon-plus"></span> Novo</a>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Código</th>
						<th>Nome</th>
						<th>Valor</th>
						<th>Categoria</th>
						<th>Opções</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${produtoList}" var="produto">
						<tr>
							<td>${produto.codigo}</td>
							<td>${produto.nome}</td>
							<td>${produto.valor}</td>
							<td>${produto.categoria.nome}</td>
							<td width="20%">
								<form action="${linkTo[ProdutoController].remover(produto)}"
										method="post">
									<a href="${linkTo[ProdutoController].visualizar(produto)}" class="btn btn-link">
										<span class="glyphicon glyphicon-pencil"></span>
									</a>
									<button type="submit" name="_method" value="DELETE" class="btn btn-link">
										<span class="glyphicon glyphicon-trash"></span>
									</button>
									
								</form>
								
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</jsp:body>
</layout:template>