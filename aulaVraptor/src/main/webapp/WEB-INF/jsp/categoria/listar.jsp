<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<layout:template>
<jsp:attribute name="scriptsEspecificos">
<script type="text/javascript">
	$("#nome").autocomplete({
		source : '<c:url value="/categorias/busca.json"/>',
		minLength : 2,
		dataType : "json",
		select : function(event, ui) {
			$("#nome").val(ui.item.nome);
			//$("#codigo").val(ui.item.codigo);
			return false;
		}
	}).data("ui-autocomplete")._renderItem = function(ul, item) {
		return $("<li></li>").data("item.autocomplete", item).append(
				"<a>" + item.nome + "</a>").appendTo(ul);
	}
</script>
</jsp:attribute>
	<jsp:body>
	
	<div class="well">
		<div class="form-inline">
			<form action="<c:url value="/categorias/pesquisar"/>">
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
				<div class="form-group">
					<a href="${linkTo[CategoriaController].listar}">
						<button type="button" class="btn btn-primary" formmethod="get">
						<span class="glyphicon glyphicon-refresh"></span> Limpar</button>
					</a>
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<a href="${linkTo[CategoriaController].form}" class="btn btn-success">
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
						<th>Opções</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categoriaList}" var="categoria">
						<tr>
							<td>${categoria.codigo}</td>
							<td>${categoria.nome}</td>
							<td width="20%">
								<form action="${linkTo[CategoriaController].remover(categoria)}"
										method="post">
									<a href="${linkTo[CategoriaController].visualizar(categoria)}" class="btn btn-link">
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