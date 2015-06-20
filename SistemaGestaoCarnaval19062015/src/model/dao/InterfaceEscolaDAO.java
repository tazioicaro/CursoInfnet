package model.dao;

import java.sql.SQLException;
import java.util.Set;

import model.negocio.EscolaDeSamba;

public interface InterfaceEscolaDAO {
	
	EscolaDeSamba obterEscolaPorId(int id)throws SQLException;
	EscolaDeSamba getEscola(String nome, String senha) throws SQLException;
	Set<EscolaDeSamba> obterEscolaDeSamba() throws SQLException;	
	Set<EscolaDeSamba> obterEscolaPorIntegrante(int idIntegrante) throws SQLException;	
	boolean incluir(EscolaDeSamba samba)throws SQLException;	
	boolean alterar(EscolaDeSamba samba)throws SQLException;	
	boolean excluir(Integer codigo)throws SQLException;
	Set<EscolaDeSamba> obterEscolaPorTorcedor(int idTorcedor)
			throws SQLException;
	

}
