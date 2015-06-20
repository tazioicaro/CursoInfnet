<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.Set" %>
    <%@ page import="java.util.Iterator" %>
    <%@ page import="model.negocio.CarnavalTO" %>
    <%@ page import="model.negocio.Grupo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de desfile</title>
</head>
<h4>${mensagem}</h4>
<body style=" background-color: silver">

<fieldset style="background-color: SteelBlue;">
<legend>${titulo}</legend>
		<div align="center" style="padding:1%; background-color:gray;">
			
			<form action="Controlador" method="post">
			<input type="hidden" name="opc" value="cadastrarCarnaval">
				
							    <%
				    	Set linhas = (Set)session.getAttribute("grupos");  
				          Iterator<Grupo> i = linhas.iterator();
				    %>
	<h4>Grupo</h4>			    		
   <select name="grupo">  
  <%
          while (i.hasNext()) {  
             Grupo grupo = i.next();
    %>  
      
      <option value=<%=grupo.getId()%> > <%=grupo.getGrupo()%> </option>
                                                                                
    <% } //fecha for  
    %>  
    </select>
        
				
			<%-- 	<h4>Descricao</h4>
				<input type="text" name="id_escola" value="${desfile.id_escola}"> --%>
				
				<h4>Carnaval</h4>
				<input type="text" name="carnaval" value="${carnaval.carnaval}">
				
				<h4>Ano</h4>
				<input type="text" name="ano" value="${carnaval.ano}">
		
				<br><hr>
				
				<input type="submit" name="Cadastrar"value="Cadastrar">								
			</form>	
			<br><hr>
			<input type="submit" value="Consultar carnaval" onclick="location.href='Controlador?opc=consultarCarnaval'">	
		</div>
		</fieldset>

</body>
</html>