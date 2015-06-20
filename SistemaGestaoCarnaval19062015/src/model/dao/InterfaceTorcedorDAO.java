package model.dao;

import java.sql.SQLException;
import java.util.Set;

import model.negocio.Usuario;

public interface InterfaceTorcedorDAO {
	
	Set<Usuario> consultarTorcedores(int idTorcedor)throws SQLException;
	boolean incluir(Usuario torcedor, int idEscolaSamba)throws SQLException;
	Set<Usuario> consultarTorcedoresPorEscolaDoIntegrante(int idUsuario)
			throws SQLException;	

}
