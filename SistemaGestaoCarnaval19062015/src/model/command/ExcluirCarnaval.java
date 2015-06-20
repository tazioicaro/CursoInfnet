package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceCarnavalDAO;
import model.dao.InterfaceEscolaDAO;

public class ExcluirCarnaval implements InterfaceCommand {

	private InterfaceCarnavalDAO CarnavalDAO;
	
	public ExcluirCarnaval(InterfaceCarnavalDAO CarnavalDAO) {
		super();
		this.CarnavalDAO = CarnavalDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		if(request.getParameter("codigo") == null)
		{
			request.setAttribute("titulo", "Cadastro de Carnaval");
			return "cadastro_Carnaval.jsp";
		}
		
		
  try{
	 
	   CarnavalDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "N�o foi poss�vel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "valor do c�digo inv�lido "+ e.getMessage());
	  
  }
  
  request.setAttribute("mensagem", "Carnaval exclu�do com sucesso");
  request.setAttribute("titulo", "Atualiza��o de Carnaval");
return "Controlador?opc=consultarCarnaval";
  
	}

	
}
