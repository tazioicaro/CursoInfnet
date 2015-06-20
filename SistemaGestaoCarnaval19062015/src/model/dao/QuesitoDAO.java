package model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import conexao.InterfacePool;
import model.negocio.Quesitos;

public class QuesitoDAO implements InterfaceQuesitoDAO{
	
	
private InterfacePool pool;
	
	public QuesitoDAO(InterfacePool pool){
		this.pool = pool;
	}
	
	
	

	@Override
	public Quesitos obterQuesitoPorId(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Quesitos obterQuesitos(String nome) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Quesitos> obterQuesitos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean incluir(Quesitos quesito) throws SQLException {
PreparedStatement ps = null;
		
		try {
			ps = pool.getConnection().prepareStatement("INSERT INTO quesitos (nome) VALUES (?)");
			ps.setString(1, quesito.getNome());
					
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
		return false;
	}

	@Override
	public boolean alterar(Quesitos quesito) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(Integer codigo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
