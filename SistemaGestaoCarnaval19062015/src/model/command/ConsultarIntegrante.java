package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.InterfaceIntegranteDAO;
import model.negocio.EscolaDeSamba;

public class ConsultarIntegrante implements InterfaceCommand {

	private InterfaceIntegranteDAO integranteDAO;
	
	public ConsultarIntegrante(InterfaceIntegranteDAO integranteDAO) {
		super();
		this.integranteDAO = integranteDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		request.setAttribute("titulo", "Consulta de Integrantes");
		try{
			request.setAttribute("integrantes", integranteDAO.obterIntegrantes(((EscolaDeSamba) session.getAttribute("usuarioLogado")).getId()));
		}catch(SQLException e) {
			request.setAttribute("mensagem", "Não foi consultar "+ e.getMessage());
		}
 
		return "consulta_integrante.jsp";
	}
}