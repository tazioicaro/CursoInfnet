package model.dao;

import java.sql.SQLException;
import java.util.Set;

import model.negocio.Carnaval;
import model.negocio.CarnavalTO;

public interface InterfaceCarnavalDAO {
	
	public  boolean incluir(Carnaval carnaval) throws SQLException;
	public boolean excluir(Integer codigo) throws SQLException;
	//public Carnaval obterCarnavalPorEscola(int id) throws SQLException ;
	public Set<CarnavalTO> obterCarnavalComTO() throws SQLException; 
	public boolean alterar(Carnaval carnaval) throws SQLException;
	public CarnavalTO obterCarnavalPorId(int id) throws SQLException;
}
