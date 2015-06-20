package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceCarnavalDAO;
import model.dao.InterfaceDesfileDAO;
import model.negocio.Carnaval;

public class AtualizarCarnaval implements InterfaceCommand {

	private InterfaceCarnavalDAO carnavalDAO;
	
	
	
	public AtualizarCarnaval(InterfaceCarnavalDAO carnavalDAO) {
		super();
		this.carnavalDAO = carnavalDAO;
		
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
	
  try{
	  Carnaval carnaval = new Carnaval();
	  carnaval.setId(Integer.valueOf(request.getParameter("codigo")));
	  carnaval.setCarnaval((request.getParameter("carnaval")));
	  carnaval.setAno(request.getParameter("ano"));
	  carnaval.setIdGrupo(Integer.valueOf(request.getParameter("grupo")));
	  carnavalDAO.alterar(carnaval);
	  request.setAttribute("mensagem"," Carnaval("+ carnaval.getId() + ") atualizado com sucesso");
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "SQL-Nao foi possovel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "Conversao Numero -conversaoN�o foi possovel gravar "+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Atualiza��o de Carnaval");
return "Controlador?opc=consultarCarnaval";
  
	}

	
}
