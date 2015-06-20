<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style=" background-color: silver">

<h3>${mensagem}</h3>
<fieldset style="background-color: SteelBlue;">
<legend>Login</legend>
	
		<div align="center"
			style="float: inherit; background-color: gray;">
			
			<form action="Controlador" method="post">
			<input type="hidden" name="opc" value="controlaAcessos">

				<h3>nome</h3>
				<input type="text" name="nome">
				<h3>senha</h3>
				<input type="password" name="senha">	
				
				<br><hr>		

				<input type="submit" value="Entrar">
			</form>
			<br><br>
			<a href="Controlador?opc=cadastrarTorcedor">Torcedor, cadastre-se aqui...</a>
		</div>
		</fieldset>
		
		
		</body>
</html>