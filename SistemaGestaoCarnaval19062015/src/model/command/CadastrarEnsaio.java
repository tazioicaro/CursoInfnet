package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceEnsaioDAO;
import model.negocio.Ensaios;
import model.negocio.EscolaDeSamba;

public class CadastrarEnsaio implements InterfaceCommand {

	private InterfaceEnsaioDAO ensaioDAO;
	
	public CadastrarEnsaio(InterfaceEnsaioDAO ensaioDAO) {
		super();
		this.ensaioDAO = ensaioDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
	
  try{
	  
	  Ensaios ensaios = new Ensaios();
	  EscolaDeSamba sc = (EscolaDeSamba) request.getSession().getAttribute("usuarioLogado");
	  
	  ensaios.setDescricao(request.getParameter("descricao"));
	  ensaios.setData(request.getParameter("data"));
	  ensaios.setHora(request.getParameter("hora"));
	  ensaios.setDuracao(request.getParameter("duracao"));	  	  
	  ensaios.setSamba_id(sc.getId());
	  //ensaios.setEscola(sc.getNome());
	  
	  
	  ensaioDAO.incluir(ensaios);
	  request.setAttribute("mensagem"," Ensaio ("+ ensaios.getDescricao() + ") criado com sucesso");
	  
  }catch(SQLException e) {
	  request.setAttribute("mensagem", "N�o foi possovel gravar "+ e.getMessage());
	  
  }catch(NumberFormatException e) {
	  request.setAttribute("mensagem", "N�o foi possovel gravar formato numero  "+ e.getMessage());
	  
  }
  
  request.setAttribute("titulo", "Cadastro de Ensaio");
return "Controlador?opc=editarEnsaio";
  
	}

	
}
