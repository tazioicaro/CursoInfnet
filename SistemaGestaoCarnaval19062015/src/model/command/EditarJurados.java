package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceUsuarioDAO;
import model.negocio.Usuario;

public class EditarJurados implements InterfaceCommand {

	private InterfaceUsuarioDAO usuarioDAO;
		
	public EditarJurados(InterfaceUsuarioDAO usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		if(request.getParameter("codigo") == null)
		{
			request.setAttribute("titulo", "Cadastro de Jurados");
			return "cadastro_jurados.jsp";
		}

  try{
	  Usuario jurados = new Usuario();

	  jurados.setNome(request.getParameter("nome"));
	  
	  jurados.setSenha(request.getParameter("senha"));
	  usuarioDAO.incluir(jurados);
	  request.setAttribute("mensagem"," Escola ("+ jurados.getNome() + ") criada com sucesso");
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Atualização de Juerados das Escolas de Samba");
return "Controlador?opc=editarJurados";
  
	}

	
}
