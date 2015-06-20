package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.InterfaceIntegranteDAO;
import model.negocio.EscolaDeSamba;
import model.negocio.Integrante;

public class CadastrarIntegrante_old implements InterfaceCommand {

	private InterfaceIntegranteDAO IntegranteDao;
	
	public CadastrarIntegrante_old(InterfaceIntegranteDAO usuarioDao) {
		super();
		this.IntegranteDao = usuarioDao;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
  try{
	  Integrante integrante = new Integrante();
	  integrante.setEmail(request.getParameter("email"));
	  integrante.setNome(request.getParameter("nome"));
	  integrante.setSenha(request.getParameter("senha"));
	  integrante.setIdEscolaSamba(((EscolaDeSamba) session.getAttribute("usuarioLogado")).getId());
	  integrante.setTipo(2);

	  if(request.getParameter("id") != null || !request.getParameter("id").equals("0")){
		  integrante.setId(Integer.parseInt(request.getParameter("id")));
		  IntegranteDao.alterar(integrante);
	  } else {
		  IntegranteDao.incluir(integrante);
	  }
	  
	  request.setAttribute("mensagem"," Integrante ("+ integrante.getNome() + ") criado com sucesso");
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Cadastro de Integrante da Escola de Samba");
return "Controlador?opc=editarIntegrante";
  
	}

	
}
