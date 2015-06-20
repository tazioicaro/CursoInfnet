package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceEscolaDAO;
import model.negocio.EscolaDeSamba;

public class AtualizarEscola implements InterfaceCommand {

	private InterfaceEscolaDAO escolaDAO;
	
	public AtualizarEscola(InterfaceEscolaDAO escolaDAO) {
		super();
		this.escolaDAO = escolaDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
	
  try{
	  EscolaDeSamba escola = new EscolaDeSamba();
	  escola.setId(Integer.valueOf(request.getParameter("codigo")));
	  escola.setCores(request.getParameter("cores"));
	  escola.setEmail(request.getParameter("email"));
	  escola.setNome(request.getParameter("nome"));
	  escola.setPracinha(request.getParameter("pracinha"));
	  escola.setSenha(request.getParameter("senha"));
	  escolaDAO.alterar(escola);
	  request.setAttribute("mensagem"," Escola ("+ escola.getNome() + ") atualizada com sucesso");
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Atualização de Escola de Samba");
return "Controlador?opc=consultarEscola";
  
	}

	
}
