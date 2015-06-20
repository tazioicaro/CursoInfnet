package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceEnsaioDAO;
import model.dao.InterfaceEscolaDAO;

public class EditarEnsaio implements InterfaceCommand {

	private InterfaceEnsaioDAO ensaioDAO;
	
	public EditarEnsaio(InterfaceEnsaioDAO ensaioDAO) {
		super();
		this.ensaioDAO = ensaioDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		if(request.getParameter("codigo") == null)
		{
			request.setAttribute("titulo", "Cadastro de Ensaio");
			return "cadastro_ensaio.jsp";
		}

/*  try{
	 
	  request.setAttribute("escola", escolaDAO.obterEscolaPorId(Integer.valueOf(request.getParameter("codigo"))));
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Nï¿½o foi possovel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "valor do cï¿½digo invï¿½lido "+ e.getMessage());
	  
  }*/
  
  request.setAttribute("titulo", "Atualização dos ensaios da Escola de Samba");
return "atualiza_escola.jsp";
  
	}

	
}
