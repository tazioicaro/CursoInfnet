package controller.controle;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.command.InterfaceCommand;
import model.dao.InterfaceEscolaDAO;
import model.dao.InterfaceUsuarioDAO;
import model.negocio.EscolaDeSamba;
import model.negocio.Usuario;

public class ControlaAcessos implements InterfaceCommand {
	private InterfaceUsuarioDAO usuarioDAO;	
	private InterfaceEscolaDAO escolaDAO;	
	private HttpSession session = null;
	String tela;
	
	
    public ControlaAcessos(InterfaceUsuarioDAO usuarioDAO, InterfaceEscolaDAO escolaDAO) {
        super();
        this.usuarioDAO= usuarioDAO;
        this.escolaDAO = escolaDAO;
    }

	
		//request.getRequestDispatcher("login.jsp").forward(request, response);
	

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		Usuario  usuario= null;
		EscolaDeSamba escola = null;
		String nome = request.getParameter("nome");
		String senha =request.getParameter("senha");	   
	   session = request.getSession();
	   
	   if(nome == null)
		   return "login.jsp";
	   
	   try{
		   if(usuarioDAO.obterUsuario(nome, senha) != (null) && escolaDAO.getEscola(nome, senha) == (null)){
            usuario = usuarioDAO.obterUsuario(nome, senha);
		   escola = new EscolaDeSamba(); 
		   }
		   
		   
		   if(escolaDAO.getEscola(nome, senha) != null && usuarioDAO.obterUsuario(nome, senha) == (null)){
            escola = escolaDAO.getEscola(nome, senha);	
		    usuario = new Usuario();
		    }
		    
		   
		   
		   if(usuarioDAO.obterUsuario(nome, senha) == (null) && escolaDAO.getEscola(nome, senha) == (null)){			   
			   request.setAttribute("mensagem", "Login ou senha Inexistentes"); 
			   	   tela = "login.jsp";
		   }			   
		   
		   
			
			    
	   }catch(SQLException e ){
		   request.setAttribute("mensagem","Problema com a base de dados" + e.getMessage());
	   }
	   
	   
	   if (usuario !=(null) && escola ==(null) && !usuario.getSenha().equals(senha) ||usuario !=(null) && escola ==(null) && !usuario.getNome().equals(nome) && escola ==(null))
	   {
		   request.setAttribute("mensagem", "Login ou senha Inválidos - primeiro");
		   tela =  "login.jsp";
		   
		   if(escola!=(null) && usuario ==null && !escola.getSenha().equals(senha) ||escola!=(null) && usuario ==null && !escola.getNome().equals(nome) && usuario==(null))
		   {
			   
			   request.setAttribute("mensagem", "Escola não existe ou senha está Inválida");
			   tela = "login.jsp";
				   
			  }
	   
	
	   }
	   
	     
		
       if (usuario.getId() > 0 ){				
			
			
			if (1 == usuario.getTipo()){
				session.setAttribute("usuarioLogado", usuario);
				tela = "Controlador?opc=iniciarAdm";
				session.setAttribute("usuarioLogadoTipo", "administrador");  
				
			}  else if (2 == usuario.getTipo()){
				session.setAttribute("usuarioLogado", usuario);
				tela = "Controlador?opc=iniciarIntegrante";
				session.setAttribute("usuarioLogadoTipo", "Integrante"); 
								
				
			} else if (3 == usuario.getTipo()) {
				session.setAttribute("usuarioLogado", usuario);
				session.setAttribute("usuarioLogadoTipo", "Torcedor"); 				
							
				tela =  "Controlador?opc=iniciarTorcedor";
			}else if (4 == usuario.getTipo()) {
				request.setAttribute("mensagem", "Você não possui acesso a este sistema");		
				
				tela =  "login.jsp";
			}			
						
			
					
		}
       
       
       else if (escola.getId()>0){
			
    	    session.setAttribute("usuarioLogado", escola);			
			session.setAttribute("usuarioLogadoTipo", "Escola de Samba"); 			
			tela =  "Controlador?opc=iniciarEscolaSamba";
			
		}
     
	     
	return tela; 
	}

	
}