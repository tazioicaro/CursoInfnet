package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceGrupoDAO;
import model.dao.InterfaceQuesitoDAO;
import model.negocio.Grupo;

public class EditarGrupo implements InterfaceCommand {

	private InterfaceGrupoDAO grupoDAO;
		
	public EditarGrupo(InterfaceGrupoDAO grupoDAO) {
		super();
		this.grupoDAO = grupoDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		if(request.getParameter("codigo") == null)
		{
			request.setAttribute("titulo", "Cadastro de Grupos");
			return "cadastro_grupo.jsp";
		}

  try{
	  Grupo grupo= new Grupo();

	  grupo.setGrupo(request.getParameter("grupo"));	  
	  
	  grupoDAO.incluir(grupo);
	  request.setAttribute("mensagem"," Grupo ("+ grupo.getGrupo() + ") criada com sucesso");
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "N�o foi possovel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "N�o foi possovel gravar "+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Atualiza��o do Grupo");
return "Controlador?opc=editarGrupo";
  
	}

	
}
