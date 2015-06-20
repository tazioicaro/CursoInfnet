package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.InterfaceCarnavalDAO;
import model.dao.InterfaceDesfileDAO;
import model.dao.InterfaceEscolaDAO;

public class EditarDesfile implements InterfaceCommand {

	private InterfaceDesfileDAO desfileDAO;
	private InterfaceEscolaDAO escolaDAO;
	private InterfaceCarnavalDAO carnavalDAO;
	
	public EditarDesfile(InterfaceDesfileDAO desfileDAO, InterfaceEscolaDAO escolaDAO, InterfaceCarnavalDAO carnavalDAO) {
		super();
		this.desfileDAO = desfileDAO;
		this.escolaDAO = escolaDAO;
		this.carnavalDAO = carnavalDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		
		if(request.getParameter("codigo") == null)
		{
			
			try{
				  HttpSession session = request.getSession();
				  
				  session.setAttribute("escolas", escolaDAO.obterEscolaDeSamba());
				  request.setAttribute("carnavais", carnavalDAO.obterCarnavalComTO());
				  
			  }catch(SQLException e) {
				  request.setAttribute("mensagem", "N�o foi possovel gravar "+ e.getMessage());
				  
			  }catch(NumberFormatException e) {
				  request.setAttribute("mensagem", "valor do c�digo inv�lido "+ e.getMessage());
				  
			  }
			
			
			request.setAttribute("titulo", "Cadastro de Desfile");
			return "cadastro_desfile.jsp";
		}
		
		try{
			  HttpSession session = request.getSession();
			  request.setAttribute("desfile", desfileDAO.obterDesfilePorEscola(Integer.valueOf(request.getParameter("codigo"))));
			  session.setAttribute("escolas", escolaDAO.obterEscolaDeSamba());  
			  request.setAttribute("carnavais", carnavalDAO.obterCarnavalComTO());

		  }catch(SQLException e) {
			  request.setAttribute("mensagem", "N�o foi possovel gravar "+ e.getMessage());
			  
		  }catch(NumberFormatException e) {
			  request.setAttribute("mensagem", "valor do c�digo inv�lido "+ e.getMessage());
			  
		  }

  
  
  request.setAttribute("titulo", "Atualiza��o de desfile");

  return "atualiza_desfile.jsp";
  
	}

	
}
