package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.negocio.Ensaios;
import conexao.InterfacePool;



public class EnsaioDAO  implements InterfaceEnsaioDAO{
		
private InterfacePool pools;
	
	public EnsaioDAO(InterfacePool pools){
		this.pools = pools;
	}
	
	
	@Override	
	public  boolean incluir(Ensaios ensaio) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			con = pools.getConnection();
			
			ps = con.prepareStatement("INSERT INTO ensaios (descricao, data, hora, duracao, samba_id) VALUES (?,?,?,?,?)");
			ps.setString(1, ensaio.getDescricao());
			ps.setString(2, ensaio.getData());
			ps.setString(3, ensaio.getHora());
			ps.setString(4, ensaio.getDuracao());
			ps.setInt(5, ensaio.getSamba_id());
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ps.close();
			pools.liberarConnection(con);
		}
			
		return false;
	}
	
		



@Override
public boolean excluir(Integer codigo) throws SQLException {
	PreparedStatement ps = null;
	Connection con = null;
	
	try {
		con = pools.getConnection();
		ps = con.prepareStatement("DELETE FROM ensaios WHERE id = ?");
		ps.setLong(1, codigo);
		
		ps.execute();
		
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		ps.close();
		pools.liberarConnection(con);
	}
		
	return false;
}



@Override
public List<Ensaios> obterEnsaioPorEscola(int id) throws SQLException {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<Ensaios> ensaios = new ArrayList<Ensaios>();
	Connection con = null;
	
	try {  
		con = pools.getConnection();
		
		ps = con.prepareStatement("SELECT * FROM ensaios  WHERE samba_id = ?");
		
		
		ps.setLong(1, id);		
		rs = ps.executeQuery();
		
		while(rs.next()){
			Ensaios	en = new Ensaios();
			en.setId(Integer.valueOf(rs.getInt("id"))); 
			en.setDescricao(rs.getString("descricao")); 
			en.setData(rs.getString("data")); 
			en.setHora(rs.getString("hora")); 
			en.setDuracao(rs.getString("duracao")); 
			en.setSamba_id(rs.getInt("samba_id"));
			en.setEscola(rs.getString("samba_id"));
			
						
			 ensaios.add(en);
		}
		
		
		
		return ensaios;
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		ps.close();
		pools.liberarConnection(con);
		
	}
		
	return null;
}



@Override
public Set<Ensaios> obterEnsaio() throws SQLException {
	
	String sql = "SELECT * FROM ensaios  ORDER BY id";
	
	Set<Ensaios> ensaios = null;
	
	PreparedStatement ps = null;
	Connection con = null;
	
	
	try {
		con = pools.getConnection();
		ensaios = new HashSet<Ensaios>();
		
		ps = con.prepareStatement(sql);		
		
		ResultSet rs = null;
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			Ensaios	en = new Ensaios();
			en.setId(Integer.valueOf(rs.getInt("id"))); 
			en.setDescricao(rs.getString("descricao")); 
			en.setData(rs.getString("data")); 
			en.setHora(rs.getString("hora")); 
			en.setDuracao(rs.getString("duracao")); 
			en.setEscola(rs.getString("samba_id")); 
			
			
			
									 
			
			ensaios.add(en);
			
		}
		
		
		return ensaios;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		ps.close();
		pools.liberarConnection(con);
	}
	
	
	return ensaios;
}


/*
@Override
public boolean alterar(EscolaDeSamba samba) throws SQLException {
	PreparedStatement ps = null;
	try {                                               
		ps = pools.getConnection().prepareStatement("UPDATE samba SET nome = ?, email = ?, senha = ?, cores = ?, pracinha = ? WHERE id = ?");
		
		ps.setString(1, samba.getNome());
		ps.setString(2, samba.getEmail());
		ps.setString(3, samba.getSenha());
		ps.setString(4, samba.getCores());
		ps.setString(5, samba.getPracinha());
		ps.setLong(6, samba.getId());
		
		
		ps.execute();
		
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		ps.close();
	}
		
	return false;
}


@Override
public EscolaDeSamba getEscola(String nome, String senha) throws SQLException {
	EscolaDeSamba escola = null;	
     Connection con = null;
		
		
		try {
			con = pools.getConnection();
			PreparedStatement ps;
			String sqlSelect = "SELECT * FROM samba WHERE nome = ? AND senha = ?";
			ps = con.prepareStatement(sqlSelect);
			ps.setString(1, nome);
			ps.setString(2, senha);
			
			ResultSet rs =  ps.executeQuery();
									
			//usuario.setId(0);
			//usuario.setNome(login); 
			//usuario.setSenha(senha); 
			
			if (rs.next()){
				escola = new EscolaDeSamba();
				escola.setId(rs.getInt("id"));
				escola.setNome(rs.getString("nome"));
				escola.setSenha(rs.getString("senha"));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			pools.liberarConnection(con);
		}
		
		return escola;
}	
*/}
