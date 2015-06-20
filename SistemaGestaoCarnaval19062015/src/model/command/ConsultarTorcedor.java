package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.InterfaceTorcedorDAO;
import model.negocio.Usuario;

public class ConsultarTorcedor implements InterfaceCommand {

	private InterfaceTorcedorDAO torcedorDAO;
	
	public ConsultarTorcedor(InterfaceTorcedorDAO torcedorDAO) {
		super();
		this.torcedorDAO = torcedorDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		request.setAttribute("titulo", "Consulta de Integrantes");
		
		try{
			request.setAttribute("torcedores", torcedorDAO.consultarTorcedores(((Usuario) session.getAttribute("usuarioLogado")).getId()));
		}catch(SQLException e) {
			request.setAttribute("mensagem", "Não foi consultar "+ e.getMessage());
		}
		return "consulta_torcedores.jsp";
 
	}
}