<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.Set,model.negocio.Usuario" %>
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
			
			<h3> Torcedores da sua escola de samba </h3>
			
			<table
		style="color: #004080; font-size: 10px; font-family: Tahoma, Verdana, Arial, Sans-Serif;;"
		border="1" bordercolor="gray" cellpadding="5">
		<thead>
			<tr
				style="color: #004080; font-size: 12px; font-family: Tahoma, Verdana, Arial, Sans-Serif; font-weight: bold">
				<th>Codigo</th>
				<th>Nome</th>
				<th>E-mail</th>				
			</tr>
		</thead>
				
				<%
		String style = "'color: navy; text-align: center; font-size:small;'";
		Set<Usuario> torcedores = (Set<Usuario>)request.getAttribute("torcedores");
		for(Usuario torcedor: torcedores){
		%>
		<tr style=<%=style %>>
			<td><%=torcedor.getId()%></td>
			<td><%=torcedor.getNome()%></td>
			<td><%=torcedor.getEmail()%></td>
		</tr>
		<%} %>
		</table>
		<br><hr>
		</div>
		</fieldset>

</body>
</html>