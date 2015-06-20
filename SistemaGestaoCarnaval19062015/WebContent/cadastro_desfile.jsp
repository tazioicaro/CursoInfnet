<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.Set" %>
    <%@ page import="java.util.Iterator" %>
    <%@ page import="model.negocio.CarnavalTO" %>
    <%@ page import="model.negocio.EscolaDeSamba" %>
    <%@ page import="model.negocio.Desfile" %>
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
			<input type="hidden" name="opc" value="cadastrarDesfile">
				
							    <%
				    	Set linhas = (Set)session.getAttribute("escolas");  
				          Iterator<EscolaDeSamba> i = linhas.iterator();
				    %>
	<h4>Escola</h4>			    		
   <select name="escola">  
  <%
    	Desfile d = (Desfile) request.getAttribute("desfile");
          while (i.hasNext()) {  
             EscolaDeSamba escolaDeSamba = i.next();
    %>  
      
      <option value=<%=escolaDeSamba.getId()%> > <%=escolaDeSamba.getNome()%> </option>
                                                                                
    <% } //fecha for  
    %>  
    </select>
    
    <!-- ----------------------------------------------------------- -->
    
    				    <%
				    	Set linhasc = (Set)request.getAttribute("carnavais");  
				          Iterator<CarnavalTO> c = linhasc.iterator();
				    %>
   <h4>Carnaval:</h4>
   <select name="carnaval">  
  <%
    	/* Desfile d = (Desfile) request.getAttribute("desfile"); */
          while (c.hasNext()) {  
             CarnavalTO carnavalTO = c.next();
             
%>      
      <option value=<%=carnavalTO.getId()%> > <%=carnavalTO.getCarnaval()%> </option>
                                                                                
    <% } //fecha for  
    %>  
    </select>
    
    <!-- ---------------------------------------------------------------- -->
    
				
			<%-- 	<h4>Descricao</h4>
				<input type="text" name="id_escola" value="${desfile.id_escola}"> --%>
				
				<h4>Data</h4>
				<input type="text" name="data" value="${desfile.data}">
				
				<h4>Hora</h4>
				<input type="text" name="hora" value="${desfile.hora}">

				<h4>Duracao</h4>
				<input type="text" name="duracao" value="${desfile.duracao}">	
				
		
				<br><hr>
				
				<input type="submit" name="Cadastrar"value="Cadastrar">								
			</form>	
			<br><hr>
			<input type="submit" value="Consultar ensaio" onclick="location.href='Controlador?opc=consultarDesfile'">	
		</div>
		</fieldset>

</body>
</html>