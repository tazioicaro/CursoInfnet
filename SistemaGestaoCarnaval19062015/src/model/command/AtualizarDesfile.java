package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EscolaDAO;
import model.dao.InterfaceDesfileDAO;
import model.dao.InterfaceEscolaDAO;
import model.negocio.Desfile;
import conexao.Pool;

public class AtualizarDesfile implements InterfaceCommand {

	private InterfaceDesfileDAO desfileDAO;
	private InterfaceEscolaDAO escolaDAO;
	
	
	public AtualizarDesfile(InterfaceDesfileDAO desfileDAO) {
		super();
		this.desfileDAO = desfileDAO;
		this.escolaDAO = escolaDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
	
  try{
	  Desfile desfile = new Desfile();
	  desfile.setId(request.getParameter("codigo"));
	  desfile.setIdEscola(Integer.valueOf(request.getParameter("escola")));
	  desfile.setIdCarnaval(Integer.valueOf(request.getParameter("carnaval")));
	  desfile.setData(request.getParameter("data"));
	  desfile.setHora(request.getParameter("hora"));
	  desfile.setDuracao(request.getParameter("duracao"));
	  desfileDAO.alterar(desfile);
	  request.setAttribute("mensagem"," Desfile("+ desfile.getId() + ") atualizado com sucesso");
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "N�o foi possovel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "N�o foi possovel gravar "+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Atualiza��o de Desfile");
return "Controlador?opc=consultarDesfile";
  
	}

	
}
