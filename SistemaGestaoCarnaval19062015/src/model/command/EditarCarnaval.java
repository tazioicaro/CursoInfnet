package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.InterfaceCarnavalDAO;
import model.dao.InterfaceGrupoDAO;

public class EditarCarnaval implements InterfaceCommand {

	private InterfaceGrupoDAO grupoDAO;
	
	private InterfaceCarnavalDAO carnavalDAO;
	
	
	public EditarCarnaval(InterfaceCarnavalDAO carnavalDAO, InterfaceGrupoDAO grupoDAO) {
		super();
		
		this.grupoDAO = grupoDAO;
		this.carnavalDAO = carnavalDAO;
		
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		
		if(request.getParameter("codigo") == null)
		{
			
			try{
				  HttpSession session = request.getSession();
				  
				  session.setAttribute("grupos", grupoDAO.obterGrupos());
				  //request.setAttribute("carnavais", carnavalDAO.obterCarnavalComTO());
				  
			  }catch(SQLException e) {
				  request.setAttribute("mensagem", "N�o foi possovel gravar "+ e.getMessage());
				  
			  }catch(NumberFormatException e) {
				  request.setAttribute("mensagem", "valor do c�digo inv�lido "+ e.getMessage());
				  
			  }
			
			
			request.setAttribute("titulo", "Cadastro de Carnaval");
			return "cadastro_carnaval.jsp";
		}
		
		try{
			  HttpSession session = request.getSession();
			  //request.setAttribute("carnaval", carnavalDAO.obterDesfilePorEscola(Integer.valueOf(request.getParameter("codigo"))));
			  request.setAttribute("carnaval", carnavalDAO.obterCarnavalPorId(Integer.valueOf(request.getParameter("codigo"))));
			  //session.setAttribute("grupos", grupoDAO.obterGrupos());  
			  
			  request.setAttribute("grupos", grupoDAO.obterGrupos());
			  //request.setAttribute("carnavais", carnavalDAO.obterCarnavalComTO());

		  }catch(SQLException e) {
			  request.setAttribute("mensagem", "N�o foi possovel gravar "+ e.getMessage());
			  
		  }catch(NumberFormatException e) {
			  request.setAttribute("mensagem", "valor do c�digo inv�lido "+ e.getMessage());
			  
		  }
  
  request.setAttribute("titulo", "Atualiza��o de desfile");

  return "atualiza_carnaval.jsp";
  
	}

	
}
