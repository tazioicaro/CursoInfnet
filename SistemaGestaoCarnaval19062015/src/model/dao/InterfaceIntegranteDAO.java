package model.dao;

import java.sql.SQLException;
import java.util.Set;

import model.negocio.Integrante;

public interface InterfaceIntegranteDAO {
	
	Integrante obterIntegrantePorId(int id)throws SQLException;
	Integrante obterIntegrante(String login, String senha ) throws SQLException;	
	Set<Integrante> obterIntegrantes(int idEscolaSamba) throws SQLException;	
	boolean incluir(Integrante integrante)throws SQLException;	
	boolean alterar(Integrante integrante)throws SQLException;	
	boolean excluir(Integer codigo)throws SQLException;
}
