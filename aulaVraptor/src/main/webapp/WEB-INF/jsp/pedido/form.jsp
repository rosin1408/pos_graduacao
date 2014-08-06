<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<layout:template>
<jsp:attribute name="scriptsEspecificos">
	<script type="text/javascript">
		$("#cliente").autocomplete({
			source : '<c:url value="/clientes/busca.json"/>',
			minLength : 2,
			dataType : "json",
			select : function(event, ui) {
				$("#cliente").val(ui.item.nome);
				$("#codigoCliente").val(ui.item.codigo);
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
	<form class="form-horizontal" action="${linkTo[PedidoController].adicionar}" method="post">
		<fieldset>
			<!-- Form Name -->
			<legend>Cadastro de Pedido</legend>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-xs-3 control-label" for="numero">Número:</label>
				<div class="col-xs-6">
					<input id="numero" name="pedido.numeroDocumento" placeholder=""
						class="form-control input-md" type="text" value="${pedido.numeroDocumento}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-3 control-label" for="data">Data:</label>
				<div class="col-xs-6">
					<input id="data" name="pedido.dataPedido" placeholder="" value="${pedido.dataPedido}"
						class="form-control input-md" type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-3 control-label" for="cliente">Cliente:</label>
				<div class="col-xs-6">
					<input id="cliente" name="pedido.cliente.nome" placeholder="" value="${pedido.cliente.nome}"
						class="form-control input-md" type="text">
				</div>
			</div>
			<!-- Button -->
			<div class="form-group">
				<label class="col-xs-3 control-label" for="save"></label>
				<div class="col-xs-8">
					<button id="save" name="save" class="btn btn-primary">Salvar</button>
				</div>
			</div>
		</fieldset>
		<input type="hidden" name="pedido.cliente.codigo" id="codigoCliente"  value="${pedido.cliente.codigo}"/>
	</form>
</jsp:body>
</layout:template>