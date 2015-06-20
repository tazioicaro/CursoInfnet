package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceIntegranteDAO;

public class ExcluirIntegrante implements InterfaceCommand {

	private InterfaceIntegranteDAO integranteDAO;
	
	public ExcluirIntegrante(InterfaceIntegranteDAO integranteDAO) {
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
	  integranteDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Não foi possovel exluir "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "valor do código inválido "+ e.getMessage());
	  
  }
  
  request.setAttribute("mensagem", "Integrante Excluído com sucesso");
  request.setAttribute("titulo", "Atualização de integrante");
return "Controlador?opc=consultarIntegrante";
  
	}

	
}
