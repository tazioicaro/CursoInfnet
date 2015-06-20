<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body style="background-color: silver; color: navy;">
<h3> Usuário: ${usuarioLogado.nome}</h3>
<h4> Perfil: ${usuarioLogadoTipo}</h4>
<br>
<div style="float: left; width: 20%">
<fieldset style="background-color: SteelBlue;padding-top: 10px;height: auto;width: 400px;">
<legend style="font-family: sans-serif; font-size: 20px; color: navy;" > Menu Escola </legend>
<div style="background-color:gray;">
<hr>
<ul>
	<li style="list-style: square;"><a href="Controlador?opc=editarIntegrante" style="font-family: sans-serif; color: navy; font-size: 14px;" target="corpo">Cadastrar Integrante</a></li>
	<li style="list-style: square;"><a href="Controlador?opc=consultarIntegrante" style="font-family: sans-serif; color: navy; font-size: 14px;" target="corpo">Consultar Integrante</a></li>
	<li style="list-style: square;"><a href="Controlador?opc=editarEnsaio" style="font-family: sans-serif; color: navy; font-size: 14px;" target="corpo">Cadastrar Ensaios</a></li>	
<li style="list-style: square;"><a href="Controlador?opc=consultarEnsaio" style="font-family: sans-serif; color: navy; font-size: 14px;" target="corpo">Consultar Ensaios</a></li>	
</ul>
</div>
</fieldset>
</div>

</body>
</html>