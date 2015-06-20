package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceQuesitoDAO;
import model.negocio.Quesitos;

public class CadastrarQuesito implements InterfaceCommand {

	private InterfaceQuesitoDAO quesitoDAO;
	
	public CadastrarQuesito(InterfaceQuesitoDAO quesitoDAO) {
		super();
		this.quesitoDAO = quesitoDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
	
  try{
	  Quesitos quesito = new Quesitos();
	
	  quesito.setNome(request.getParameter("nome"));	
	  
	  quesitoDAO.incluir(quesito);
	  request.setAttribute("mensagem"," Quesito ("+ quesito.getNome() + ") cadastrado com sucesso");
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Cadastro - Jurados");
return "Controlador?opc=editarQuesito";
  
	}

	
}
