package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceDesfileDAO;
import model.negocio.Desfile;
import model.negocio.EscolaDeSamba;

public class CadastrarDesfile implements InterfaceCommand {

	private InterfaceDesfileDAO desfileDAO;
	
	public CadastrarDesfile(InterfaceDesfileDAO desfileDAO) {
		super();
		this.desfileDAO = desfileDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
	
  try{
	  
	  Desfile desfile = new Desfile();
	 // EscolaDeSamba sc = (EscolaDeSamba) request.getSession().getAttribute("usuarioLogado");
	  desfile.setIdEscola(Integer.valueOf(request.getParameter("escola")));
	  //desfile.setIdEscola(Integer.valueOf(request.getParameter("id_escola")));
	  //desfile.setId(request.getParameter("id"));
	  desfile.setIdCarnaval(Integer.valueOf(request.getParameter("carnaval")));
	  desfile.setData(request.getParameter("data"));
	  desfile.setHora(request.getParameter("hora"));
	  desfile.setDuracao(request.getParameter("duracao"));
	  
	  //ensaios.setEscola(sc.getNome());
	  
	  
	  desfileDAO.incluir(desfile);
	  request.setAttribute("mensagem"," Desfile criado com sucesso");
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "Nao foi possivel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "Nao foi possivel gravar formato numero  "+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Cadastro de Desfile");
return "Controlador?opc=editarDesfile";
  
	}

	
}
