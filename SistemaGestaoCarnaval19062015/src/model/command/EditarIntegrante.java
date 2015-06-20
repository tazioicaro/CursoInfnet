package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceIntegranteDAO;

public class EditarIntegrante implements InterfaceCommand {

	private InterfaceIntegranteDAO integranteDAO;
	
	public EditarIntegrante(InterfaceIntegranteDAO integranteDAO) {
		super();
		this.integranteDAO = integranteDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		if(request.getParameter("codigo") == null)
		{
			request.setAttribute("titulo", "Cadastro de Integrante");
			return "cadastro_integrante.jsp";
		}

  try{
	 
	  request.setAttribute("integrante", integranteDAO.obterIntegrantePorId(Integer.valueOf(request.getParameter("codigo"))));
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "valor do código inválido "+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Atualização de Integrante da Escola de Samba");
     return "cadastro_integrante.jsp";
  
	}

	
}
