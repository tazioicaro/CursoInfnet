package model.dao;

import java.sql.SQLException;
import java.util.Set;

import model.negocio.IntegranteSamba;
import model.negocio.Usuario;

public interface InterfaceUsuarioDAO {
	
	void salvarIntegrandeEscola (IntegranteSamba escolasEIntegrante) throws SQLException;
	Usuario obterUsuarioPorId(int id)throws SQLException;
	Usuario obterUsuario(String login, String senha ) throws SQLException;	
	Set<Usuario> obterTorcedores() throws SQLException;	
	boolean incluir(Usuario usuario)throws SQLException;	
	boolean alterar(Usuario usuario)throws SQLException;	
	boolean excluir(Integer codigo)throws SQLException;
	

}
