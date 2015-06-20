package model.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EnsaioDAO;
import model.dao.EscolaDAO;
import model.dao.InterfaceEnsaioDAO;
import model.dao.InterfaceEscolaDAO;
import model.negocio.Ensaios;
import model.negocio.EscolaDeSamba;
import model.negocio.Usuario;

public class ConsultarEnsaio implements InterfaceCommand {

	private InterfaceEnsaioDAO ensaioaDAO;
	private InterfaceEscolaDAO escolaDAO;

	public ConsultarEnsaio(InterfaceEnsaioDAO ensaioaDAO,
			InterfaceEscolaDAO escolaDAO) {
		super();
		this.ensaioaDAO = ensaioaDAO;
		this.escolaDAO = escolaDAO;
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		request.setAttribute("titulo", "Consulta de Ensaios da Escola de Samba");

		try {
			
			List<Ensaios> listaEnsaio = new ArrayList<Ensaios>();

			if (request.getParameter("codigo").equals("cEnsaio")) {

				Usuario integrante = (Usuario) request.getSession().getAttribute("usuarioLogado");
				
				Collection<EscolaDeSamba> escolas = (Collection<EscolaDeSamba>) escolaDAO.obterEscolaPorIntegrante(integrante.getTipo());
				
				for(EscolaDeSamba escola: escolas){
					
					List<Ensaios> ensaio = (List<Ensaios>) ensaioaDAO.obterEnsaioPorEscola(escola.getId());
					for (Ensaios ensaios : ensaio) {
						Ensaios en = new Ensaios();
						if(ensaios.getSamba_id() == escola.getId()){
						
							listaEnsaio.add(ensaios);
												
							
						}
						
						System.out.println(ensaios);
						System.out.println(listaEnsaio);
					}
					
				
							
						
					

				}

				request.setAttribute("ensaio", listaEnsaio);
				
				return "consulta_ensaio_integrante.jsp";

			} else {

				EscolaDeSamba sc = (EscolaDeSamba) request.getSession().getAttribute("usuarioLogado");

				request.setAttribute("escola", sc.getId());
				int cod = sc.getId();
				List<Ensaios> ensaio = (List<Ensaios>) ensaioaDAO.obterEnsaioPorEscola(cod);
				for (Ensaios ensaios : ensaio) {

					if (sc.getId() == ensaios.getId())
						
						ensaios.setEscola(sc.getNome());
					request.setAttribute("ensaio", ensaio);

				}
				
				return "consulta_ensaio.jsp";
			}

		} catch (SQLException e) {
			request.setAttribute("mensagem",
					"N�o foi consultar " + e.getMessage());

		}

		return "consulta_ensaio.jsp";

	}

}
