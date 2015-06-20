package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceUsuarioDAO;
import model.negocio.EscolaDeSamba;
import model.negocio.IntegranteSamba;
import model.negocio.Usuario;

public class CadastrarIntegrante implements InterfaceCommand {

	private InterfaceUsuarioDAO usuarioDAO;
	
	public CadastrarIntegrante(InterfaceUsuarioDAO usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
	
  try{
	  Usuario integrante = new Usuario();	  
	
	  integrante.setNome(request.getParameter("nome"));	
	  integrante.setSenha(request.getParameter("senha"));
	  integrante.setEmail(request.getParameter("email"));
	  integrante.setTipo(2);
	 
	  	 
	  usuarioDAO.incluir(integrante);	
	
	  
      EscolaDeSamba sc = (EscolaDeSamba) request.getSession().getAttribute("usuarioLogado");    
      Usuario acesso  = usuarioDAO.obterUsuario(integrante.getNome(), integrante.getSenha());	
      
      
      IntegranteSamba ei = new IntegranteSamba();
      ei.setIntegrante_id(acesso.getId());
      ei.setSamba_id(sc.getId());	  
	   usuarioDAO.salvarIntegrandeEscola(ei);;
	  
	  
	  
	  request.setAttribute("mensagem"," Integrante ("+ integrante.getNome() + ") cadastrado com sucesso");
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "Não foi possovel gravar - Valor Inválido"+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Cadastro de Integrante");
return "Controlador?opc=editarIntegrante";
  
	}

	
}
