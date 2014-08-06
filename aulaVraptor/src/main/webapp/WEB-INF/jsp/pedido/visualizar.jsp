<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<layout:template>
<jsp:attribute name="scriptsEspecificos">
	<script type="text/javascript">
		$("#categoria").autocomplete({
			source : '<c:url value="/categorias/busca.json"/>',
			minLength : 2,
			dataType : "json",
			select : function(event, ui) {
				$("#categoria").val(ui.item.nome);
				$("#codigoCategoria").val(ui.item.codigo);
				return false;
			}
		}).data("ui-autocomplete")._renderItem = function(ul, item) {
			return $("<li></li>").data("item.autocomplete", item).append(
					"<a>" + item.nome + "</a>").appendTo(ul);
		}
	</script>
</jsp:attribute>
<jsp:body>
	<c:forEach var="error" items="${errors}">
	    ${error.category} - ${error.message}<br />
	</c:forEach>
	<form class="form-horizontal" action="${linkTo[ProdutoController].alterar(produto)}" method="post">
		<fieldset>
			<!-- Form Name -->
			<legend>Alterar Produto</legend>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-xs-3 control-label" for="nome">Nome:</label>
				<div class="col-xs-6">
					<input id="nome" name="produto.nome" placeholder="" value="${produto.nome}"
						class="form-control input-md"  type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-3 control-label" for="nome">Valor:</label>
				<div class="col-xs-6">
					<input id="nome" name="produto.valor" placeholder="" value="${produto.valor}"
						class="form-control input-md"  type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-3 control-label" for="categoria">Categoria:</label>
				<div class="col-xs-6">
					<input id="categoria" placeholder="" value="${produto.categoria.nome}"
						class="form-control input-md" type="text">
				</div>
			</div>
			<!-- Button -->
			<div class="form-group">
				<label class="col-xs-3 control-label" for="save"></label>
				<div class="col-xs-8">
					<button type="submit" name="_method" class="btn btn-primary" value="PUT">Salvar</button>
				</div>
			</div>
		</fieldset>
		<input type="hidden" name="produto.categoria.codigo" id="codigoCategoria" value="${produto.categoria.codigo}"/>
	</form>
</jsp:body>
</layout:template>