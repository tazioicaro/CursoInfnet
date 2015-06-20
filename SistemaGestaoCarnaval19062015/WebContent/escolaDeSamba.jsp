<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div style="background-color: activecaption;">
		<div align="center" style="position:inherit; padding:1%; float: left; width: 30%; height: 20%; background-color:blue;">
			<h3>Cadastrar Integrantes</h3>
			<form action="ControlaAdministrador" method="post">
				
				<h4>nome</h4>
				<input type="text" name="nome">

				<h4>e-mail</h4>
				<input type="text" name="email">
			
				<h4>senha</h4>
				<input type="text" name="senha">
		
				<br><hr>
				
				<input type="submit" value="Cadastrar">
			</form>		
		</div>
		
		<div align="center" style="position:inherit; padding:2%;  float: right; width: 30%;  background-color: gray;">
			<h3>Cadastar Ensaios</h3>
			<form action="ControlaAcesso" method="post">
				
				<h4>Nome</h4>
				<input type="text" name="nome" >
			
				<h4>local</h4>
				<input type="text" name="local" >
				
			    <h4>Horario</h4>
				<input type="text" name="horario" >
		
				<br><hr>				
				<input type="submit" value="Cadastrar">
			</form>		
		</div>
	</div>

</body>
</html>