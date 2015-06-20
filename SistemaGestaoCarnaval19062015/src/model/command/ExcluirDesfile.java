package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceDesfileDAO;
import model.dao.InterfaceEscolaDAO;

public class ExcluirDesfile implements InterfaceCommand {

	private InterfaceDesfileDAO desfileDAO;
	
	public ExcluirDesfile(InterfaceDesfileDAO desfileDAO) {
		super();
		this.desfileDAO = desfileDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		if(request.getParameter("codigo") == null)
		{
			request.setAttribute("titulo", "Cadastro de desfile");
			return "cadastro_desfile.jsp";
		}
		
		
  try{
	 
	   desfileDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "N�o foi poss�vel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "valor do c�digo inv�lido "+ e.getMessage());
	  
  }
  
  request.setAttribute("mensagem", "Desfile exclu�do com sucesso");
  request.setAttribute("titulo", "Atualiza��o de desfile");
return "Controlador?opc=consultarDesfile";
  
	}

	
}
