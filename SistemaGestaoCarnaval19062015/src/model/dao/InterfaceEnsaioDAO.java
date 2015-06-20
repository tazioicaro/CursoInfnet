package model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import model.negocio.DesfileTO;
import model.negocio.Ensaios;

public interface InterfaceEnsaioDAO {
	
	public  boolean incluir(Ensaios ensaio) throws SQLException;
	public boolean excluir(Integer codigo) throws SQLException;
	public List<Ensaios> obterEnsaioPorEscola(int id) throws SQLException;
	public Set<Ensaios> obterEnsaio() throws SQLException ;

}