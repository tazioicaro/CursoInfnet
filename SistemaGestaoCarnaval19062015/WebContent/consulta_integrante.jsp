<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.Set,model.negocio.Integrante" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SGC - Gestão de Carnaval</title>
</head>

<h3></h3>
<h4>${mensagem}</h4>
<body style=" background-color: silver">

<fieldset style="background-color: SteelBlue;">
<legend>${titulo}</legend>


		<div align="center" style="padding:1%;  background-color:gray;">
			
			<h3> Integrantes cadastrado para a nossa escola de samba</h3>
			
			<table
		style="color: #004080; font-size: 10px; font-family: Tahoma, Verdana, Arial, Sans-Serif;;"
		border="1" bordercolor="gray" cellpadding="5">
		<thead>
			<tr
				style="color: #004080; font-size: 12px; font-family: Tahoma, Verdana, Arial, Sans-Serif; font-weight: bold">
				<th>Cod.</th>
				<th>Nome</th>
				<th>e-mail</th>				
				<th colspan="2">Editar</th>
			</tr>
		</thead>
				
				<%
		String style = "'color: navy; text-align: center; font-size:small;'";
		Set<Integrante> integrantes = (Set<Integrante>)request.getAttribute("integrantes");
		for(Integrante integrante: integrantes){
		%>
		<tr style=<%=style %>>
			<td><%=integrante.getId()%></td>
			<td><%=integrante.getNome()%></td>
			<td><%=integrante.getEmail()%></td>		
			<td><a href='Controlador?opc=editarIntegrante&codigo=<%=integrante.getId()%>'>Atualizar</a></td>
			<td><a href='Controlador?opc=excluirIntegrante&codigo=<%=integrante.getId()%>'>Excluir</a></td>
		</tr>
		<%} %>
		</table>
		<br><hr>
		<input type="submit" value="Cadastrar Integrante" onclick="location.href='Controlador?opc=editarIntegrante'">
		</div>
		</fieldset>

</body>
</html>