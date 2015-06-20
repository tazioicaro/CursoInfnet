package model.dao;

import java.sql.SQLException;
import java.util.Set;

import model.negocio.Quesitos;

public interface InterfaceQuesitoDAO {
	
	Quesitos obterQuesitoPorId(long id)throws SQLException;
	Quesitos obterQuesitos(String nome ) throws SQLException;	
	Set<Quesitos> obterQuesitos() throws SQLException;	
	boolean incluir(Quesitos quesito)throws SQLException;	
	boolean alterar(Quesitos quesito)throws SQLException;	
	boolean excluir(Integer codigo)throws SQLException;
	

}
