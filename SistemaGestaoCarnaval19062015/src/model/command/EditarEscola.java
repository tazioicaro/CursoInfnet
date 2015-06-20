package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceEscolaDAO;

public class EditarEscola implements InterfaceCommand {

	private InterfaceEscolaDAO escolaDAO;
	
	public EditarEscola(InterfaceEscolaDAO escolaDAO) {
		super();
		this.escolaDAO = escolaDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		if(request.getParameter("codigo") == null)
		{
			request.setAttribute("titulo", "Cadastro de Escola de Samba");
			return "cadastro_escola.jsp";
		}

  try{
	 
	  request.setAttribute("escola", escolaDAO.obterEscolaPorId(Integer.valueOf(request.getParameter("codigo"))));
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "N�o foi possovel gravar "+ e.getMessage());
	  	
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "valor do c�digo inv�lido "+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Atualiza��o de Escola de Samba");
return "atualiza_escola.jsp";
  
	}

	
}
