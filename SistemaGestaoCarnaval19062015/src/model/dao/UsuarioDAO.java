package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import model.negocio.IntegranteSamba;
import model.negocio.Usuario;
import conexao.InterfacePool;
import constantes.InterfaceConstantes;

public class UsuarioDAO implements  InterfaceUsuarioDAO{
	
	private InterfacePool pool;
	
	public UsuarioDAO(InterfacePool pool){
		this.pool = pool;
	}
	
	public  Usuario obterUsuarioPorId(int id) throws SQLException {
		
		Usuario usuario = new Usuario();
		
		PreparedStatement ps = null;
		
		try {
			ps = pool.getConnection().prepareStatement("SELECT * FROM usuario WHERE id = ?");
			ps.setLong(1, id);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			usuario.setId(id);
			if (rs.next()){
				usuario.setEmail(rs.getString("email")); 
				usuario.setSenha(rs.getString("senha")); 
				usuario.setNome(rs.getString("nome"));
				usuario.setTipo(rs.getInt("tipo_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	
	
	
	@Override
	public  Usuario obterUsuario(String login, String senha)  throws SQLException {
		
       Usuario usuario = null;	
       Connection con = null;
		
		
		try {
			con = pool.getConnection();
			PreparedStatement ps;
			String sqlSelect = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
			ps = con.prepareStatement(sqlSelect);
			ps.setString(1, login);
			ps.setString(2, senha);
			
			ResultSet rs =  ps.executeQuery();
									
			//usuario.setId(0);
			//usuario.setNome(login); 
			//usuario.setSenha(senha); 
			
			if (rs.next()){
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTipo(rs.getInt("tipo_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			pool.liberarConnection(con);
		}
		
		return usuario;
	}

	



	@Override
	public boolean alterar(Usuario usuario) throws SQLException {
PreparedStatement ps = null;
		
		try {                                               
			ps = pool.getConnection().prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ?, tipo_id = ? WHERE id = ?");
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			ps.setObject(4, usuario.getTipo());
			ps.setLong(5, usuario.getId());
			
			
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
	public Set<Usuario> obterTorcedores()  throws SQLException {
String sql = "SELECT * FROM usuario WHERE tipo = ? ORDER BY nome";
		
		Set<Usuario> torcedores = null;
		
		PreparedStatement ps = null;
		
		
		try {
			torcedores = new HashSet<Usuario>();
			
			ps = pool.getConnection().prepareStatement(sql);
			ps.setString(1, InterfaceConstantes.TIPO_TORCEDOR);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				torcedores.add(new Usuario(rs.getInt("id"), 
										 rs.getString("nome"), 
										 rs.getString("email"), 
										 rs.getString("senha"), 
										 rs.getInt("tipo_id")));
			}
			
			return torcedores;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return torcedores;
	}



	@Override
	public boolean incluir(Usuario usuario) throws SQLException {
PreparedStatement ps = null;

      Connection con = pool.getConnection();
		
		try {
			ps = con.prepareStatement("INSERT INTO usuario (nome, email, senha, tipo_id) VALUES (?,?,?,?)");
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, usuario.getTipo());			
			ps.execute();
			ps.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			pool.liberarConnection(con);
		}
			
		return false;
		
	}
	
	public void salvarIntegrandeEscola (IntegranteSamba escolasEIntegrante) throws SQLException
	{
		Connection con = pool.getConnection();
		PreparedStatement ps;
		String sqlInsert = "INSERT INTO integrantes_samba (integrante_id, samba_id) " +
				" VALUES (?, ?);";
		try{
			ps = con.prepareStatement(sqlInsert);			
			
				ps.setInt(1, escolasEIntegrante.getIntegrante_id());
				ps.setInt(2, escolasEIntegrante.getSamba_id());
				ps.addBatch();
		
			
			ps.executeBatch();
			ps.close();

	
          }catch (SQLException e) {
  			e.printStackTrace();
  		}finally{
  			
  			pool.liberarConnection(con);
  			
  		}
	}
	
	

	
}