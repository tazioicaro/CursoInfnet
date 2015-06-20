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

import model.negocio.Desfile;
import model.negocio.DesfileTO;
import conexao.InterfacePool;

public class DesfileDAO  implements InterfaceDesfileDAO{
		
private InterfacePool pools;
	
	public DesfileDAO(InterfacePool pools){
		this.pools = pools;
	}
	
	@Override	
	public  boolean incluir(Desfile desfile) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			con = pools.getConnection();
			
			ps = con.prepareStatement("INSERT INTO desfile (id_escola, id_carnaval, data, hora, duracao) VALUES (?,?,?,?,?)");
			
			ps.setInt(1, desfile.getIdEscola());
			ps.setInt(2, desfile.getIdCarnaval());
			ps.setString(3, desfile.getData());
			ps.setString(4, desfile.getHora());
			ps.setString(5, desfile.getDuracao());
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
		ps = con.prepareStatement("DELETE FROM desfile WHERE id = ?");
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

public boolean alterar(Desfile desfile) throws SQLException {
	PreparedStatement ps = null;
	try {                                               
		//ps = pools.getConnection().prepareStatement("UPDATE desfile SET id = ?, id_escola= ?, id_carnaval=?,  data = ?, hora = ? WHERE id = ?");
		ps = pools.getConnection().prepareStatement("UPDATE desfile SET id_escola= ?, id_carnaval=?,  data = ?, hora = ?, duracao=? WHERE id = ?");
		//ps.setString(1, desfile.getId());
		ps.setInt(1, Integer.valueOf(desfile.getIdEscola()));
		ps.setInt(2, Integer.valueOf(desfile.getIdCarnaval()));
		ps.setString(3, desfile.getData());
		ps.setString(4, desfile.getHora());
		ps.setString(5, desfile.getDuracao());
		ps.setString(6, desfile.getId());
		
		ps.execute();
		
		return true;
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		ps.close();
	}
		
	return false;
}

@Override
public Desfile obterDesfilePorEscola(int id) throws SQLException {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<Desfile> desfiles = new ArrayList<Desfile>();
	Connection con = null;
	
	try {  
		con = pools.getConnection();
		
		ps = con.prepareStatement("SELECT d.id, d.id_escola, d.data, d.hora, d.duracao, s.nome FROM desfile d, samba s where d.id_escola = s.id and d.id= ?");
		
		ps.setLong(1, id);		
		rs = ps.executeQuery();
		
		while(rs.next()){
			Desfile	de = new Desfile();
			de.setId(rs.getString("id")); 
			de.setIdEscola(rs.getInt("id_escola")); 
			de.setData(rs.getString("data")); 
			de.setHora(rs.getString("hora")); 
			de.setDuracao(rs.getString("duracao"));
						
     		desfiles.add(de);
		}
		
		return desfiles.get(0);
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		ps.close();
		pools.liberarConnection(con);
		
	}
		
	return null;
}

@Override
public Set<Desfile> obterDesfile() throws SQLException {
	
	String sql = "SELECT d.id, d.id_escola, d.data, d.hora, d.duracao, s.nome FROM desfile d, samba s where d.id_escola = s.id order by d.id";
	
	Set<Desfile> desfiles = null;
	
	PreparedStatement ps = null;
	Connection con = null;
	
	try {
		con = pools.getConnection();
		desfiles = new HashSet<Desfile>();
		
		ps = con.prepareStatement(sql);		
		
		ResultSet rs = null;
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			Desfile	de = new Desfile();
			de.setId(rs.getString("id")); 
			de.setIdEscola(rs.getInt("id_escola")); 
			de.setData(rs.getString("data")); 
			de.setHora(rs.getString("hora")); 
			
			desfiles.add(de);
			
		}
		
		return desfiles;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		ps.close();
		pools.liberarConnection(con);
		
	}
	
	return desfiles;
}


public Set<DesfileTO> obterDesfileComTO() throws SQLException {
	
	String sql = "SELECT d.id, d.id_escola, d.data, d.hora, d.duracao, s.nome, c.carnaval FROM desfile d, samba s, carnaval c where d.id_escola = s.id and d.id_carnaval=c.id order by s.nome";
	
	Set<DesfileTO> desfilesTO = null;
	
	PreparedStatement ps = null;
	Connection con = null;
	
	try {
		con = pools.getConnection();
		desfilesTO = new LinkedHashSet<DesfileTO>();
		
		ps = con.prepareStatement(sql);		
		
		ResultSet rs = null;
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			DesfileTO de = new DesfileTO();
			de.setId(rs.getString("id")); 
			de.setIdEscola(rs.getInt("id_escola"));
			de.setDescricaoEscola(rs.getString("nome"));
			de.setDescricaoCarnaval(rs.getString("carnaval"));
			de.setData(rs.getString("data")); 
			de.setHora(rs.getString("hora")); 
			de.setDuracao(rs.getString("duracao"));
			
			desfilesTO.add(de);
			
		}
		
		return desfilesTO;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		ps.close();
		pools.liberarConnection(con);
	}
	
	return desfilesTO;
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