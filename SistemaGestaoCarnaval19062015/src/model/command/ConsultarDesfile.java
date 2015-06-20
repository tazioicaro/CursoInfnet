package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceDesfileDAO;

public class ConsultarDesfile implements InterfaceCommand {

	private InterfaceDesfileDAO desfileDAO;
	
	public ConsultarDesfile(InterfaceDesfileDAO desfileDAO) {
		super();
		this.desfileDAO = desfileDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.setAttribute("titulo", "Consulta de desfile");
		
		
  try{	  
	 
	  request.setAttribute("desfile", desfileDAO.obterDesfileComTO());
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Nao foi consultar "+ e.getMessage());
	  
  }
  		
  		String destino = "consulta_desfile.jsp";
  		
  		//Verifica se � um torcedor.
  		/*HttpSession session = request.getSession();
  		if(session.getAttribute("usuarioLogado") instanceof Usuario){
  			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
  			if(usuario.getTipo() == 3){
  				destino = "consulta_escola_torcedor.jsp";
  			}
  		}*/
  		
  		return destino;
	}
}