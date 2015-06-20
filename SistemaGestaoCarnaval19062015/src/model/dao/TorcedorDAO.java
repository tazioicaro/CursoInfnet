package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import model.negocio.Usuario;
import conexao.InterfacePool;

public class TorcedorDAO  implements InterfaceTorcedorDAO{
		
private InterfacePool pools;
	
	public TorcedorDAO(InterfacePool pools){
		this.pools = pools;
	}
	
//	SELECIONAR TODOS OS TORCEDORES DESSAS ESCOLAS. (COM DISTINCT)	
	@Override
	public Set<Usuario> consultarTorcedores(int idTorcedor) throws SQLException {
		String sql = "SELECT distinct u.* "
				+ "   FROM usuario u, torcedor_samba ts "
				+ "   WHERE ts.torcedor = u.id "
				+ "   AND ts.samba= ANY (SELECT ts2.samba"
				+ "						 FROM torcedor_samba ts2 "
				+ "						 WHERE ts2.torcedor= ?) "
				+ "   ORDER BY u.nome";
		
		Set<Usuario> usuario = null;
		
		PreparedStatement ps = null;
		
		
		try {
			usuario = new HashSet<Usuario>();
			
			ps = pools.getConnection().prepareStatement(sql);
			ps.setLong(1, idTorcedor);
			
			ResultSet rs = null;
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				usuario.add(new Usuario(rs.getInt("id"), 
										 rs.getString("nome"), 
										 rs.getString("email"), 
										 rs.getString("senha"), 
										 rs.getInt("tipo_id")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	


//	SELECIONAR TODAS AS ESCOLAS QUE QUE FAZ PARTE O INTEGRANTE.
//	SELECIONAR TODOS OS TORCEDORES DESSAS ESCOLAS. (COM DISTINCT)
	
	
	
	

	@Override
	public boolean incluir(Usuario torcedor, int idEscolaSamba)
			throws SQLException {
		try {
			PreparedStatement ps = null;
			
			ps = pools.getConnection().prepareStatement("INSERT INTO usuario (nome, email, senha, tipo_id) VALUES (?,?,?,?)");
			ps.setString(1, torcedor.getNome());
			ps.setString(2, torcedor.getEmail());
			ps.setString(3, torcedor.getSenha());
			ps.setObject(4, torcedor.getTipo());			
			ps.execute();
			
			int idTorcedor = this.obterIDTorcedor(torcedor.getNome(), torcedor.getSenha());
			ps = pools.getConnection().prepareStatement("INSERT INTO torcedor_samba (torcedor_id, samba_id) VALUES (?,?)");
			ps.setLong(1, idTorcedor);
			ps.setLong(2, idEscolaSamba);
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}
	
	
	private int obterIDTorcedor(String login, String senha)  throws SQLException {
		
		int id = 0;	
		Connection con = null;
		
		try {
			con = pools.getConnection();
			PreparedStatement ps;
			String sqlSelect = "SELECT id FROM usuario WHERE nome = ? AND senha = ?";
			ps = con.prepareStatement(sqlSelect);
			ps.setString(1, login);
			ps.setString(2, senha);
			
			ResultSet rs =  ps.executeQuery();
			
			if (rs.next()){
				id = rs.getInt("id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			pools.liberarConnection(con);
		}
		return id;
	}
	
	
	@Override
	public Set<Usuario> consultarTorcedoresPorEscolaDoIntegrante (int idUsuario) throws SQLException {
		String sql ="SELECT distinct u.nome nome_torcedor, " +
					"u.id, u.nome, u.email, u.senha, u.tipo_id " +
					"from samba e, integrantes_samba ie, torcedor_samba te, usuario u " +
					"where e.id = ie.samba_id and ie.integrante_id = ? and ie.samba_id = te.samba and te.torcedor= u.id "; 

		
		Set<Usuario> usuario = null;
		
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		
		
		try {
			usuario = new HashSet<Usuario>();
			con =pools.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setLong(1, idUsuario);
			
		
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				usuario.add(new Usuario(rs.getInt("id"), 
										 rs.getString("nome_torcedor"), 
										 rs.getString("email"), 
										 rs.getString("senha"), 
										 rs.getInt("tipo_id")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			pools.liberarConnection(con);
			rs.close();
			ps.close();
		}
		
		return usuario;
	}
	
}