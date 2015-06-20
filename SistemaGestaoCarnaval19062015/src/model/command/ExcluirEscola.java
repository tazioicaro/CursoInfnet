package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceEscolaDAO;

public class ExcluirEscola implements InterfaceCommand {

	private InterfaceEscolaDAO escolaDAO;
	
	public ExcluirEscola(InterfaceEscolaDAO escolaDAO) {
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
	 
	   escolaDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "valor do código inválido "+ e.getMessage());
	  
  }
  
  request.setAttribute("mensagem", "Escola Excluída com sucesso");
  request.setAttribute("titulo", "Atualização de Escola de Samba");
return "Controlador?opc=consultarEscola";
  
	}

	
}
