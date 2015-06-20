package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceQuesitoDAO;
import model.negocio.Quesitos;

public class EditarQuesito implements InterfaceCommand {

	private InterfaceQuesitoDAO quesitoDAO;
		
	public EditarQuesito(InterfaceQuesitoDAO quesitoDAO) {
		super();
		this.quesitoDAO = quesitoDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		if(request.getParameter("codigo") == null)
		{
			request.setAttribute("titulo", "Cadastro de Quesitos");
			return "cadastro_quesito.jsp";
		}

  try{
	  Quesitos quesito = new Quesitos();

	  quesito.setNome(request.getParameter("nome"));	  
	  
	  quesitoDAO.incluir(quesito);
	  request.setAttribute("mensagem"," Escola ("+ quesito.getNome() + ") criada com sucesso");
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Atualização dos Quesitos das Escola de Samba");
return "Controlador?opc=editarQuesito";
  
	}

	
}
