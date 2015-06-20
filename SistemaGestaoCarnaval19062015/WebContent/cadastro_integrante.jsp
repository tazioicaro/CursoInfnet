<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Escola de Samba</title>
</head>
<h4>${mensagem}</h4>
<body style=" background-color: silver">

<fieldset style="background-color: SteelBlue;">
<legend>${titulo}</legend>
		<div align="center" style="padding:1%; background-color:gray;">
			
			<form action="Controlador" method="post">
			<input type="hidden" name="opc" value="cadastrarIntegrante">
			<input type="hidden" name="id" value="${integrante.id}">
				
				<h4>Nome</h4>
				<input type="text" name="nome" value="${integrante.nome}">

				<h4>E-mail</h4>
				<input type="text" name="email" value="${integrante.email}">
			
				<h4>Senha</h4>
				<input type="text" name="senha" value="${integrante.senha}">
		
				<br><hr>
				
				<input type="submit" name="Cadastrar"value="Cadastrar/Editar">								
			</form>	
			<br><hr>
			<input type="submit" value="Consultar integrantes" onclick="location.href='Controlador?opc=consultarIntegrante'">	
		</div>
		</fieldset>

</body>
</html>