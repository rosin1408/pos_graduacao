<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página de teste</title>
</head>
<body>
	Olá Pós em Java UTFPR - Roberto Rosin
	<br/>
	${teste}
	
	<form action="valorView">
		<input name="cliente.codigo" id="codigo" type="text"/>
		<input name="cliente.nome" id="nome" type="text"/>
		
		<input type="submit" value="Enviar Servidor"/>
	</form>
</body>
</html>