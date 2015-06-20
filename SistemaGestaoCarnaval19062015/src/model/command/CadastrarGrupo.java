package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceGrupoDAO;
import model.negocio.Grupo;

public class CadastrarGrupo implements InterfaceCommand {

	private InterfaceGrupoDAO grupoDAO;
	
	public CadastrarGrupo(InterfaceGrupoDAO grupoDAO) {
		super();
		this.grupoDAO = grupoDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
	
  try{
	  Grupo grupo= new Grupo();
	  grupo.setGrupo(request.getParameter("grupo"));
	  grupoDAO.incluir(grupo);
	  request.setAttribute("mensagem"," Grupo("+ grupo.getGrupo() + ") criado com sucesso");
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "N�o foi possovel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "N�o foi possovel gravar "+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Cadastro de Grupo");
return "Controlador?opc=editarGrupo";
  
	}

	
}
