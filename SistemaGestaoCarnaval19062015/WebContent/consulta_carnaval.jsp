<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="model.negocio.CarnavalTO" %>
 <%@ page import="java.util.Set" %>
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
			
			<h3> Carnavais Cadastrados</h3>
			
			<table
		style="color: #004080; font-size: 10px; font-family: Tahoma, Verdana, Arial, Sans-Serif;;"
		border="1" bordercolor="gray" cellpadding="5">
		<thead>
			<tr
				style="color: #004080; font-size: 12px; font-family: Tahoma, Verdana, Arial, Sans-Serif; font-weight: bold">
				<th>id</th>
				<!-- <th>idEscola</th> -->
				
				<th>Carnaval</th>
				<th>DescricaoGrupo</th>
				<th>Ano</th>
				<th colspan="2">Editar</th>
			</tr>
		</thead>
				
				<%
									String style = "'color: navy; text-align: center; font-size:small;'";
										Set<CarnavalTO> carnavais = (Set<CarnavalTO>)request.getAttribute("carnavais");
										for(CarnavalTO carnaval: carnavais){
								%>
			<tr style=<%=style %>>
				<td><%=carnaval.getId()%></td>
				<%-- <td><%=carnaval.getIdEscola()%></td> --%>
				<td><%=carnaval.getCarnaval()%></td>
				<td><%=carnaval.getDescricaoGrupo()	 %></td>
				<td><%=carnaval.getAno()%></td>
				<td><a href='Controlador?opc=editarCarnaval&codigo=<%=carnaval.getId()%>'>Atualizar</a></td>
				<td><a href='Controlador?opc=excluirCarnaval&codigo=<%=carnaval.getId()%>'>Excluir</a></td>
			</tr>
		<%} %>
		</table>
		<br><hr>
		<input type="submit" value="Cadastrar Carnaval" onclick="location.href='Controlador?opc=editarCarnaval'">
		</div>
		</fieldset>

</body>
</html>
