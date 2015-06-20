package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import model.negocio.EscolaDeSamba;
import conexao.InterfacePool;



public class EscolaDAO  implements InterfaceEscolaDAO{
		
private InterfacePool pools;
	
	public EscolaDAO(InterfacePool pools){
		this.pools = pools;
	}
	
	
	@Override	
	public  boolean incluir(EscolaDeSamba samba) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			con = pools.getConnection();
			ps = con.prepareStatement("INSERT INTO samba (nome, email, senha, cores, pracinha) VALUES (?,?,?,?,?)");
			ps.setString(1, samba.getNome());
			ps.setString(2, samba.getEmail());
			ps.setString(3, samba.getSenha());
			ps.setString(4, samba.getCores());
			ps.setString(5, samba.getPracinha());
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
		ps = con.prepareStatement("DELETE FROM samba WHERE id = ?");
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
public EscolaDeSamba obterEscolaPorId(int id) throws SQLException {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<EscolaDeSamba> escolas = new ArrayList<EscolaDeSamba>();
	Connection con = null;
	
	try {  
		con = pools.getConnection();
		
		ps = con.prepareStatement("SELECT * FROM samba  WHERE id = ?");
		
		
		ps.setLong(1, id);		
		rs = ps.executeQuery();
		
		while(rs.next()){
			EscolaDeSamba	sc = new EscolaDeSamba();
			sc.setId(Integer.valueOf(rs.getInt("id"))); 
			sc.setNome(rs.getString("nome")); 
			 sc.setEmail(rs.getString("email")); 
			 sc.setSenha(rs.getString("senha")); 
			 sc.setCores(rs.getString("cores")); 
			 sc.setPracinha(rs.getString("pracinha")); 
			 sc.setEnsaios(rs.getString("ensaio"));
									 
			
			
			escolas.add(sc);
		}
		
		
		
		return escolas.get(0);
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		ps.close();
		pools.liberarConnection(con);
		
	}
		
	return null;
}



@Override
public Set<EscolaDeSamba> obterEscolaDeSamba() throws SQLException {
	
	String sql = "SELECT * FROM samba  ORDER BY nome";
	
	Set<EscolaDeSamba> escolas = null;
	
	PreparedStatement ps = null;
	Connection con = null;
	
	
	try {
		con = pools.getConnection();
		escolas = new LinkedHashSet<EscolaDeSamba>();
		
		ps = con.prepareStatement(sql);		
		
		ResultSet rs = null;
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			EscolaDeSamba	sc = new EscolaDeSamba();
			sc.setId(Integer.valueOf(rs.getInt("id"))); 
			sc.setNome(rs.getString("nome")); 
			 sc.setEmail(rs.getString("email")); 
			 sc.setSenha(rs.getString("senha")); 
			 sc.setCores(rs.getString("cores")); 
			 sc.setPracinha(rs.getString("pracinha")); 
			 sc.setEnsaios(rs.getString("ensaio"));
									 
			
			escolas.add(sc);
			
		}
		ps.close();
		
		return escolas;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		pools.liberarConnection(con);
	}
	
	
	return escolas;
}



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


@Override
public Set<EscolaDeSamba> obterEscolaPorIntegrante(int idIntegrante)
		throws SQLException {
	
	String sql = "SELECT * FROM samba u, integrantes_samba i WHERE i.integrante_id = ? AND u.id = i.samba_id ORDER BY u.nome";
	
	Set<EscolaDeSamba> escolas = null;
	
	PreparedStatement ps = null;
	
	
	try {
		escolas = new HashSet<EscolaDeSamba>();
		
		ps = pools.getConnection().prepareStatement(sql);
		ps.setLong(1, idIntegrante);
		
		ResultSet rs = null;
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			EscolaDeSamba es = new EscolaDeSamba();
			
			es.setEmail(rs.getString("email"));
			es.setCores(rs.getString("cores"));
			es.setEnsaios(rs.getString("ensaio"));
			es.setId(rs.getInt("id"));
			es.setNome(rs.getString("nome"));
			es.setPracinha(rs.getString("pracinha"));
			
			escolas.add(es);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return escolas;
}

@Override
public Set<EscolaDeSamba> obterEscolaPorTorcedor(int idTorcedor)
		throws SQLException {
	
String sql = "SELECT * FROM samba u, torcedor_samba i WHERE i.torcedor= ? AND u.id = i.samba ORDER BY u.id";
	
	Set<EscolaDeSamba> escolas = null;
	ResultSet rs = null;	
	PreparedStatement ps = null;
	 Connection con = null;
	
	try {
		
		con = pools.getConnection();
		escolas = new HashSet<EscolaDeSamba>();
		
		ps = con.prepareStatement(sql);
		ps.setLong(1, idTorcedor);
		
		
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			
			EscolaDeSamba es = new EscolaDeSamba();
			
			es.setEmail(rs.getString("email"));
			es.setCores(rs.getString("cores"));
			es.setEnsaios(rs.getString("ensaio"));
			es.setId(rs.getInt("id"));
			es.setNome(rs.getString("nome"));
			es.setPracinha(rs.getString("pracinha"));
			
			escolas.add(es);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		
		ps.close();
		rs.close();
		pools.liberarConnection(con);
	}
	return escolas;
}	
}
