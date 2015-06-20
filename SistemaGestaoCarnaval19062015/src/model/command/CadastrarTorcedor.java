package model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InterfaceEscolaDAO;
import model.dao.InterfaceTorcedorDAO;
import model.negocio.Usuario;

public class CadastrarTorcedor implements InterfaceCommand {

	private InterfaceTorcedorDAO torcedorDAO;
	private InterfaceEscolaDAO escolaDAO;
	
	public CadastrarTorcedor(InterfaceTorcedorDAO torcedorDAO, InterfaceEscolaDAO escolaDAO) {
		super();
		this.torcedorDAO = torcedorDAO;
		this.escolaDAO = escolaDAO;
	}

	 
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
	
		try{
			request.setAttribute("escolas", escolaDAO.obterEscolaDeSamba());
			if (request.getParameter("acao") != null && request.getParameter("acao").equals("salvar")) {
				Usuario torcedor = new Usuario();	  
				  
				torcedor.setNome(request.getParameter("nome"));	
				torcedor.setSenha(request.getParameter("senha"));
				torcedor.setEmail(request.getParameter("email"));
				  
				torcedor.setTipo(3);
				torcedorDAO.incluir(torcedor, Integer.parseInt(request.getParameter("idEscola")));
				request.setAttribute("mensagem"," Torcedor ("+ torcedor.getNome() + ") cadastrado com sucesso");
			}
	  
		}catch(SQLException e) {
			request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
		}catch(NumberFormatException e) {
			request.setAttribute("mensagem", "Não foi possovel gravar "+ e.getMessage());
		}
		request.setAttribute("titulo", "Cadastro de torcedor");
		return "cadastro_torcedor.jsp";
	}
}
