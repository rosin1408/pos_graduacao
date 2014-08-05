<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<layout:template>
	<c:forEach var="error" items="${errors}">
	    ${error.category} - ${error.message}<br />
	</c:forEach>
	<form class="form-horizontal" action="${linkTo[ClienteController].alterar(cliente)}" method="post">
		<input type="hidden" name="cliente.codigo" id="cliente-codigo" value="${cliente.codigo}"/>
		<fieldset>
			<!-- Form Name -->
			<legend>Alterar cliente</legend>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-xs-3 control-label" for="nome">Nome:</label>
				<div class="col-xs-6">
					<input id="nome" name="cliente.nome" placeholder="" value="${cliente.nome}"
						class="form-control input-md"  type="text">
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
	</form>
</layout:template>