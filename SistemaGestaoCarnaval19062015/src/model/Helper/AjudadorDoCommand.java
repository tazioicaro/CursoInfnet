package model.Helper;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import model.command.AtualizarCarnaval;
import model.command.AtualizarDesfile;
import model.command.AtualizarEscola;
import model.command.CadastrarCarnaval;
import model.command.CadastrarDesfile;
import model.command.CadastrarEnsaio;
import model.command.CadastrarEscola;
import model.command.CadastrarGrupo;
import model.command.CadastrarIntegrante;
import model.command.CadastrarJurados;
import model.command.CadastrarQuesito;
import model.command.CadastrarTorcedor;
import model.command.ConsultarCarnaval;
import model.command.ConsultarDesfile;
import model.command.ConsultarEnsaio;
import model.command.ConsultarEscola;
import model.command.ConsultarIntegrante;
import model.command.ConsultarTorcedor;
import model.command.EditarCarnaval;
import model.command.EditarDesfile;
import model.command.EditarEnsaio;
import model.command.EditarEscola;
import model.command.EditarGrupo;
import model.command.EditarIntegrante;
import model.command.EditarJurados;
import model.command.EditarQuesito;
import model.command.ExcluirCarnaval;
import model.command.ExcluirDesfile;
import model.command.ExcluirEscola;
import model.command.ExcluirIntegrante;
import model.command.IniciarAdm;
import model.command.IniciarEscolaSamba;
import model.command.IniciarIntegrante;
import model.command.IniciarTorcedor;
import model.command.InterfaceCommand;
import model.dao.CarnavalDAO;
import model.dao.DesfileDAO;
import model.dao.EnsaioDAO;
import model.dao.EscolaDAO;
import model.dao.GrupoDAO;
import model.dao.IntegranteDAO;
import model.dao.QuesitoDAO;
import model.dao.TorcedorDAO;
import model.dao.UsuarioDAO;
import conexao.InterfacePool;
import controller.controle.ControlaAcessos;

public class AjudadorDoCommand {
	
	private HashMap<String, InterfaceCommand> mapaComandos;
    private HttpServletRequest request;
    @SuppressWarnings("unused")
	private InterfacePool pool;
    
    public AjudadorDoCommand(InterfacePool pool){
    	this.pool =pool;
    	
    	mapaComandos = new HashMap<String, InterfaceCommand>();
        mapaComandos.put("controlaAcessos", new ControlaAcessos(new UsuarioDAO(pool), new EscolaDAO(pool)));
       
        mapaComandos.put("cadastrarEscola", new CadastrarEscola(new EscolaDAO(pool)));
        mapaComandos.put("editarEscola", new EditarEscola(new EscolaDAO(pool)));
        mapaComandos.put("consultarEscola", new ConsultarEscola(new EscolaDAO(pool)));
        mapaComandos.put("atualizarEscola", new AtualizarEscola(new EscolaDAO(pool)));
        mapaComandos.put("excluirEscola", new ExcluirEscola(new EscolaDAO(pool)));
        
        mapaComandos.put("cadastrarIntegrante", new CadastrarIntegrante(new UsuarioDAO(pool)));
        mapaComandos.put("editarIntegrante", new EditarIntegrante(new IntegranteDAO(pool)));
        mapaComandos.put("excluirIntegrante", new ExcluirIntegrante(new IntegranteDAO(pool)));
        mapaComandos.put("consultarIntegrante", new ConsultarIntegrante(new IntegranteDAO(pool)));
        
        mapaComandos.put("consultarTorcedor", new ConsultarTorcedor(new TorcedorDAO(pool), new EscolaDAO(pool)));       
        mapaComandos.put("cadastrarTorcedor", new CadastrarTorcedor(new TorcedorDAO(pool), new EscolaDAO(pool)));
        
        mapaComandos.put("cadastrarJurados", new CadastrarJurados(new UsuarioDAO(pool)));
        mapaComandos.put("editarJurados", new EditarJurados(new UsuarioDAO(pool)));
        
        
        mapaComandos.put("cadastrarQuesito", new CadastrarQuesito(new QuesitoDAO(pool)));
        mapaComandos.put("editarQuesito", new EditarQuesito(new QuesitoDAO(pool)));
       
        mapaComandos.put("cadastrarEnsaio", new CadastrarEnsaio(new EnsaioDAO(pool)));
        mapaComandos.put("editarEnsaio", new EditarEnsaio(new EnsaioDAO(pool)));
        mapaComandos.put("consultarEnsaio", new ConsultarEnsaio(new EnsaioDAO(pool), new EscolaDAO(pool)));
        
        mapaComandos.put("cadastrarGrupo", new CadastrarGrupo(new GrupoDAO(pool)));
        mapaComandos.put("editarGrupo", new EditarGrupo(new GrupoDAO(pool)));
        
        mapaComandos.put("iniciarAdm",new IniciarAdm());
        mapaComandos.put("iniciarEscolaSamba", new IniciarEscolaSamba());
        mapaComandos.put("iniciarIntegrante", new IniciarIntegrante());
        mapaComandos.put("iniciarTorcedor", new IniciarTorcedor());
        
        mapaComandos.put("cadastrarDesfile", new CadastrarDesfile(new DesfileDAO(pool)));
        mapaComandos.put("editarDesfile", new EditarDesfile(new DesfileDAO(pool), new EscolaDAO(pool), new CarnavalDAO(pool)));
        mapaComandos.put("consultarDesfile", new ConsultarDesfile(new DesfileDAO(pool)));
        mapaComandos.put("atualizarDesfile", new AtualizarDesfile(new DesfileDAO(pool)));
        mapaComandos.put("excluirDesfile", new ExcluirDesfile(new DesfileDAO(pool)));
        
        mapaComandos.put("consultarCarnaval", new ConsultarCarnaval(new CarnavalDAO(pool)));
        mapaComandos.put("cadastrarCarnaval", new CadastrarCarnaval(new CarnavalDAO(pool)));
        mapaComandos.put("editarCarnaval", new EditarCarnaval(new CarnavalDAO(pool), new GrupoDAO(pool)));
        mapaComandos.put("excluirCarnaval", new ExcluirCarnaval(new CarnavalDAO(pool)));
        mapaComandos.put("atualizarCarnaval", new AtualizarCarnaval(new CarnavalDAO(pool)));
        
    }
    
    
    
    public InterfaceCommand getCommand(){
    	return request.getParameter("opc") != null ? mapaComandos.get(request.getParameter("opc")) : null;
    }
    
    public void setRequest(HttpServletRequest request){
    	this.request = request;
    }
	
}
