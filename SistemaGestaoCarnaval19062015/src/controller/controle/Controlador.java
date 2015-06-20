package controller.controle;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Helper.AjudadorDoCommand;
import model.command.InterfaceCommand;
import conexao.InterfacePool;
import conexao.Pool;

/**
 * Servlet implementation class Controlador
 */
public class Controlador  extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet{
	private static final long serialVersionUID = 1L;
  
	private InterfacePool pool = new Pool();
	private AjudadorDoCommand ajudador = new AjudadorDoCommand(pool);
	
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	this.pool = (InterfacePool)getServletContext().getAttribute("pool");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}
	
	protected void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ajudador.setRequest(request);
		InterfaceCommand comando = ajudador.getCommand();
		String pagina = comando.execute(request, response);
		request.getRequestDispatcher(pagina).include(request, response);
		
	}

}
