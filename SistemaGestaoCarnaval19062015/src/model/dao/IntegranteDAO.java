package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import model.negocio.Integrante;
import conexao.InterfacePool;

public class IntegranteDAO implements  InterfaceIntegranteDAO{
	
	private InterfacePool pool;
	
	public IntegranteDAO(InterfacePool pool){
		this.pool = pool;
	}
	
	public  Integrante obterIntegrantePorId(int id) throws SQLException {
		
		Integrante integrante = new Integrante();
		
		PreparedStatement ps = null;
		
		try {
			ps = pool.getConnection().prepareStatement("SELECT * FROM usuario WHERE id = ?");
			ps.setLong(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			integrante.setId(id);
			if (rs.next()){
				integrante.setEmail(rs.getString("email")); 
				integrante.setSenha(rs.getString("senha")); 
				integrante.setNome(rs.getString("nome"));
				integrante.setTipo(rs.getInt("tipo_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return integrante;
	}
	
	@Override
	public Integrante obterIntegrante(String login, String senha)  throws SQLException {
		
		Integrante integrante = null;	
		Connection con = null;
		
		try {
			con = pool.getConnection();
			PreparedStatement ps;
			String sqlSelect = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
			ps = con.prepareStatement(sqlSelect);
			ps.setString(1, login);
			ps.setString(2, senha);
			
			ResultSet rs =  ps.executeQuery();
			
			if (rs.next()){
				integrante = new Integrante();
				integrante.setId(rs.getInt("id"));
				integrante.setNome(rs.getString("nome"));
				integrante.setSenha(rs.getString("senha"));
				integrante.setTipo(rs.getInt("tipo_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			pool.liberarConnection(con);
		}
		return integrante;
	}

	@Override
	public boolean alterar(Integrante integrante) throws SQLException {
		PreparedStatement ps = null;
		
		try {                                               
			ps = pool.getConnection().prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ?, tipo_id = ? WHERE id = ?");
			
			ps.setString(1, integrante.getNome());
			ps.setString(2, integrante.getEmail());
			ps.setString(3, integrante.getSenha());
			ps.setObject(4, integrante.getTipo());
			ps.setLong(5, integrante.getId());
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
		
	}

	@Override
	public boolean excluir(Integer codigo) throws SQLException {
		PreparedStatement ps = null;
		
		try {
			ps = pool.getConnection().prepareStatement("DELETE FROM integrantes_samba WHERE integrante_id = ?");
			ps.setLong(1, codigo);
			
			ps.execute();
			
			ps = pool.getConnection().prepareStatement("DELETE FROM usuario WHERE id = ?");
			ps.setLong(1, codigo);
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Set<Integrante> obterIntegrantes(int idEscolaSamba)  throws SQLException {
		String sql = "SELECT * FROM usuario u, integrantes_samba i WHERE i.samba_id = ? AND u.id = i.integrante_id ORDER BY u.nome";
		
		Set<Integrante> integrantes = null;
		
		PreparedStatement ps = null;
		
		
		try {
			integrantes = new HashSet<Integrante>();
			
			ps = pool.getConnection().prepareStatement(sql);
			ps.setLong(1, idEscolaSamba);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				integrantes.add(new Integrante(rs.getInt("id"), 
										 rs.getString("nome"), 
										 rs.getString("email"), 
										 rs.getString("senha"), 
										 rs.getInt("tipo_id")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return integrantes;
	}



	@Override
	public boolean incluir(Integrante integrante) throws SQLException {
PreparedStatement ps = null;
		
		try {
			int idEscolaSamba = integrante.getIdEscolaSamba();
			
			ps = pool.getConnection().prepareStatement("INSERT INTO usuario (nome, email, senha, tipo_id) VALUES (?,?,?,?)");
			ps.setString(1, integrante.getNome());
			ps.setString(2, integrante.getEmail());
			ps.setString(3, integrante.getSenha());
			ps.setObject(4, integrante.getTipo());			
			ps.execute();
			
			integrante = this.obterIntegrante(integrante.getNome(), integrante.getSenha());
			integrante.setIdEscolaSamba(idEscolaSamba);
			ps = pool.getConnection().prepareStatement("INSERT INTO integrantes_samba (integrante_id, samba_id) VALUES (?,?)");
			ps.setLong(1, integrante.getId());
			ps.setLong(2, integrante.getIdEscolaSamba());
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
		
	}

	
}