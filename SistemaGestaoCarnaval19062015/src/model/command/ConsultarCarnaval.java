package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceCarnavalDAO;

public class ConsultarCarnaval implements InterfaceCommand {

	private InterfaceCarnavalDAO carnavalDAO;
	
	public ConsultarCarnaval(InterfaceCarnavalDAO carnavalDAO) {
		super();
		this.carnavalDAO = carnavalDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.setAttribute("titulo", "Consulta de carnaval");
		
  try{	  
	 
	  request.setAttribute("carnavais", carnavalDAO.obterCarnavalComTO());
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Nao foi consultar "+ e.getMessage());
	  
  }
  		
  		String destino = "consulta_carnaval.jsp";
  		
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