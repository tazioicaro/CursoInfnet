package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.InterfaceEscolaDAO;
import model.dao.InterfaceTorcedorDAO;

public class ConsultarTorcedor implements InterfaceCommand {

	private InterfaceTorcedorDAO torcedorDAO;
	private InterfaceEscolaDAO escolaDAO;
	
	public ConsultarTorcedor(InterfaceTorcedorDAO torcedorDAO, InterfaceEscolaDAO escolaDAO) {
		super();
		this.torcedorDAO = torcedorDAO;
		this.escolaDAO = escolaDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		request.setAttribute("titulo", "Consulta de Integrantes");
		
		try{			
			if(request.getParameter("codigo")!=null){
			
			if(request.getParameter("codigo").equals("cTorcedor")){
                    request.setAttribute("torcedores", torcedorDAO.consultarTorcedoresPorEscolaDoIntegrante(Integer.valueOf(request.getParameter("id")))); 

				
			}}else{
			request.setAttribute("torcedores", torcedorDAO.consultarTorcedores(Integer.valueOf(request.getParameter("id"))));
			}
		}catch(SQLException e) {
			request.setAttribute("mensagem", "Não foi consultar "+ e.getMessage());
		}
		return "consulta_torcedores.jsp";
 
	}
}