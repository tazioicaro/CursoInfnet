package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.InterfaceEscolaDAO;
import model.negocio.Usuario;

public class ConsultarEscola implements InterfaceCommand {

	private InterfaceEscolaDAO escolaDAO;
	
	public ConsultarEscola(InterfaceEscolaDAO escolaDAO) {
		super();
		this.escolaDAO = escolaDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.setAttribute("titulo", "Consulta de Escola de Samba");
		
		
  try{	  
	  if( request.getParameter("codigo") != null){
	 
	 if( request.getParameter("codigo").equals("cEscola")){
		 
		 request.setAttribute("escola", escolaDAO.obterEscolaPorIntegrante(Integer.valueOf((request.getParameter("id")))));
		  
	   request.setAttribute("exibirNome", "Escolas que você é Integrante "); 
	 }
	 
	 else if( request.getParameter("codigo").equals("tEscola")){
		 
		 request.setAttribute("escola", escolaDAO.obterEscolaPorTorcedor(Integer.valueOf((request.getParameter("id")))));
	 
	    request.setAttribute("exibirNome", "Escolas do seu coração");
	 }
	 
	  
	  
	  }else{
	  request.setAttribute("escola", escolaDAO.obterEscolaDeSamba());
	  
	  request.setAttribute("exibirNome", "Escola de Samba Cadastradas");
	  }
	  
	  
	  
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Não foi consultar "+ e.getMessage());
	  
  }
  		
  		String destino = "consulta_escola.jsp";
  		
  		//Verifica se é um torcedor.
  		HttpSession session = request.getSession();
  		if(session.getAttribute("usuarioLogado") instanceof Usuario){
  			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
  			if(usuario.getTipo() == 3){
  				destino = "consulta_escola_torcedor.jsp";
  			}
  		}
  		
  		return destino;
	}
}
