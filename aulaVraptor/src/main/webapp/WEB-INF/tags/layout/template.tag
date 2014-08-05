<%@ tag pageEncoding="UTF-8"%>

<%@ attribute name="cssEspecificos" 	fragment="true" 	required="false" %>
<%@ attribute name="scriptsEspecificos" fragment="true" 	required="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8" />
	<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
	<title>Pós Java - Vraptor</title>
	<meta name="description" content="" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
	
	<!-- Bootstrap -->
    <link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet" />
    <link href="<c:url value="/static/css/jquery-ui.min.css"/>" rel="stylesheet" />
    <!-- Curso -->
    <link href="<c:url value="/static/css/style.css"/>" rel="stylesheet" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

	<jsp:invoke fragment="cssEspecificos"></jsp:invoke>
</head>
<body>


<div role="navigation" class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="#" class="navbar-brand">Clientes Vraptor</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<c:url value=""/>">Home</a></li>
            <li><a href="<c:url value="/clientes"/>">Clientes</a></li>
            <li><a href="<c:url value="/categorias"/>">Categorias</a></li>
            <li><a href="<c:url value="/produtos"/>">Produtos</a></li>
            <li><a href="<c:url value="/pedidos"/>">Pedidos</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
	
	<div class="container">
		<div class="row">		
			<jsp:doBody />
		</div>
		<footer>
	        <p>&copy; UTFPR 2014</p>
	    </footer>
    </div> <!-- /container -->
    	
		<script src="<c:url value="/static/js/jquery-2.1.1.min.js"/>"></script>
		<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
		<script src="<c:url value="/static/js/jquery-ui.min.js"/>"></script>
				
		<jsp:invoke fragment="scriptsEspecificos"></jsp:invoke>
</body>
</html>
