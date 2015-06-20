package model.dao;

import java.sql.SQLException;
import java.util.Set;

import model.negocio.DesfileTO;
import model.negocio.Grupo;

public interface InterfaceGrupoDAO {

	
 
    Set<Grupo> obterGrupos() throws SQLException;	
	//Set<EscolaDeSamba> obterTorcedores() throws SQLException;	
	boolean incluir(Grupo grupo)throws SQLException;	
	//boolean alterar(Ensaios ensaio)throws SQLException;	
	boolean excluir(Integer codigo)throws SQLException;
	

}
