<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body style="background-color: silver; color: navy;">
<h3> Usu�rio: ${usuarioLogado.nome}</h3>
<h4> Perfil: ${usuarioLogado.tipo}</h4>
<br>
<div style="float: left; width: 20%">
<fieldset style="background-color: SteelBlue;padding-top: 10px;height: auto;width: 400px;">
<legend style="font-family: sans-serif; font-size: 20px; color: navy;" > Menu Administra��o </legend>
<div style="background-color:gray;">
<hr>
<ul>
	
	<li style="list-style: square;"><a href="Controlador?opc=consultarEscola" style="font-family: sans-serif; color: navy; font-size: 14px;" target="corpo">Consultar Escola de Samba</a></li>
	<li style="list-style: square;"><a href="Controlador?opc=consultarTorcedor" style="font-family: sans-serif; color: navy; font-size: 14px;" target="corpo">Consultar Torcedor</a></li>
	
</ul>
</div>
</fieldset>
</div>

</body>
</html>