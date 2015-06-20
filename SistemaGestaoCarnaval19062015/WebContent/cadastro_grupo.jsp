<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de grupos</title>
</head>
<h4>${mensagem}</h4>
<body style=" background-color: silver">

<fieldset style="background-color: SteelBlue;">
<legend>${titulo}</legend>
		<div align="center" style="padding:1%; background-color:gray;">
			
			<form action="Controlador" method="post">
			<input type="hidden" name="opc" value="cadastrarGrupo">
				
				<h4>Grupo</h4>
				<input type="text" name="grupo" value="${grupo.grupo}">
		
				<br><hr>
				
				<input type="submit" name="Cadastrar" value="Cadastrar">								
			</form>	
			<br><hr>
			<input type="submit" value="Consultar ensaio" onclick="location.href='Controlador?opc=consultarEnsaio'">	
		</div>
		</fieldset>

</body>
</html>