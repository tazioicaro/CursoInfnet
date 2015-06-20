package model.dao;

import java.sql.SQLException;
import java.util.Set;

import model.negocio.Desfile;
import model.negocio.DesfileTO;

public interface InterfaceDesfileDAO {
	
	public  boolean incluir(Desfile desfile) throws SQLException;
	public boolean excluir(Integer codigo) throws SQLException;
	public Desfile obterDesfilePorEscola(int id) throws SQLException ;
	public Set<Desfile> obterDesfile() throws SQLException; 
	public boolean alterar(Desfile desfile) throws SQLException;
	public Set<DesfileTO> obterDesfileComTO() throws SQLException; 
}
