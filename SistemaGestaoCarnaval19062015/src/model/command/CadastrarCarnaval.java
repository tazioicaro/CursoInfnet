package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceCarnavalDAO;
import model.negocio.Carnaval;

public class CadastrarCarnaval implements InterfaceCommand {

	private InterfaceCarnavalDAO carnavalDAO;
	
	public CadastrarCarnaval(InterfaceCarnavalDAO carnavalDAO) {
		super();
		this.carnavalDAO = carnavalDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
	
  try{
	  
	  Carnaval carnaval = new Carnaval();
	 // EscolaDeSamba sc = (EscolaDeSamba) request.getSession().getAttribute("usuarioLogado");
	  carnaval.setAno(request.getParameter("ano"));
	  carnaval.setCarnaval(request.getParameter("carnaval"));
	  carnaval.setIdGrupo(Integer.valueOf(request.getParameter("grupo")));
	  
	  carnavalDAO.incluir(carnaval);
	  request.setAttribute("mensagem"," Carnaval criado com sucesso");
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Nao foi possivel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "Nao foi possivel gravar formato numero  "+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Cadastro de Carnaval");
return "Controlador?opc=editarCarnaval";
  
	}

	
}
