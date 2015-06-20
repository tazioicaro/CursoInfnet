package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceUsuarioDAO;
import model.negocio.Usuario;

public class CadastrarJurados implements InterfaceCommand {

	private InterfaceUsuarioDAO usuarioDAO;
	
	public CadastrarJurados(InterfaceUsuarioDAO usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
	
  try{
	  Usuario jurados = new Usuario();	  
	
	  jurados.setNome(request.getParameter("nome"));	
	  jurados.setSenha(request.getParameter("senha"));
	  jurados.setEmail(request.getParameter("email"));
	  
	  jurados.setTipo(4);
	  usuarioDAO.incluir(jurados);
	  request.setAttribute("mensagem"," Jurado ("+ jurados.getNome() + ") cadastrado com sucesso");
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Cadastro de Jurados");
return "Controlador?opc=editarJurados";
  
	}

	
}
