package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import model.negocio.Carnaval;
import model.negocio.CarnavalTO;
import conexao.InterfacePool;

public class CarnavalDAO  implements InterfaceCarnavalDAO{
		
private InterfacePool pools;
	
	public CarnavalDAO(InterfacePool pools){
		this.pools = pools;
	}
	
	@Override	
	public  boolean incluir(Carnaval carnaval) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			con = pools.getConnection();
			
			ps = con.prepareStatement("INSERT INTO carnaval(carnaval, ano, id_grupo) VALUES (?,?,?)");
			
			ps.setString(1, carnaval.getCarnaval());
			ps.setString(2, carnaval.getAno());
			ps.setInt(3, carnaval.getIdGrupo());
			
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
		ps = con.prepareStatement("DELETE FROM carnaval WHERE id = ?");
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

public boolean alterar(Carnaval carnaval) throws SQLException {
	PreparedStatement ps = null;
	try {                                               
		ps = pools.getConnection().prepareStatement("UPDATE carnaval SET carnaval = ?, ano = ?, id_grupo= ? WHERE id = ?");
		
		ps.setString(1, carnaval.getCarnaval());
		ps.setString(2, carnaval.getAno());
		ps.setInt(3, carnaval.getIdGrupo());
		ps.setInt(4, carnaval.getId());
		ps.execute();
		
		return true;
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		ps.close();
	}
		
	return false;
}

/*@Override
public carnaval obtercarnavalPorEscola(int id) throws SQLException {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<carnaval> carnavals = new ArrayList<carnaval>();
	Connection con = null;
	
	try {  
		con = pools.getConnection();
		
		ps = con.prepareStatement("SELECT d.id, d.id_escola, d.data, d.hora, s.nome FROM carnaval d, samba s where d.id_escola = s.id and d.id= ?");
		
		ps.setLong(1, id);		
		rs = ps.executeQuery();
		
		while(rs.next()){
			carnaval	de = new carnaval();
			de.setId(rs.getString("id")); 
			de.setIdEscola(rs.getInt("id_escola")); 
			de.setData(rs.getString("data")); 
			de.setHora(rs.getString("hora")); 
						
     		carnavals.add(de);
		}
		
		return carnavals.get(0);
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		ps.close();
		pools.liberarConnection(con);
		
	}
		
	return null;
}
*/




public CarnavalTO obterCarnavalPorId(int id) throws SQLException {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<CarnavalTO> carnavals = new ArrayList<CarnavalTO>();
	Connection con = null;
	
	try {  
		con = pools.getConnection();
		
		ps = con.prepareStatement("SELECT c.id, c.carnaval, c.ano, c.id_grupo FROM carnaval c where c.id = ?");
		
		ps.setLong(1, id);		
		rs = ps.executeQuery();
		
		while(rs.next()){
			CarnavalTO	cto = new CarnavalTO();
			cto.setId(rs.getInt("id")); 
			cto.setCarnaval(rs.getString("carnaval")); 
			cto.setAno(rs.getString("ano")); 
			cto.setIdGrupo(rs.getInt("id_grupo")); 
						
     		carnavals.add(cto);
		}
		
		return carnavals.get(0);
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		ps.close();
		pools.liberarConnection(con);
		
	}
		
	return null;
}





@Override
public Set<CarnavalTO> obterCarnavalComTO() throws SQLException {
	
	String sql = "SELECT c.id, c.carnaval, c.ano, c.id_grupo, g.grupo FROM carnaval c, grupo g where c.id_grupo = g.id order by c.ano, g.grupo";
	
	Set<CarnavalTO> carnavais = null;
	
	PreparedStatement ps = null;
	Connection con = null;
	
	try {
		con = pools.getConnection();
		carnavais = new LinkedHashSet<CarnavalTO>();
		
		ps = con.prepareStatement(sql);		
		
		ResultSet rs = null;
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			CarnavalTO	carnaval = new CarnavalTO();
			carnaval.setId(Integer.valueOf(rs.getString("id")));
			carnaval.setCarnaval(rs.getString("carnaval"));
			carnaval.setAno(rs.getString("ano"));
			carnaval.setIdGrupo(Integer.valueOf(rs.getInt("id_grupo"))); 
			carnaval.setDescricaoGrupo(rs.getString("grupo")); 
			
			carnavais.add(carnaval);
			
		}
		
		return carnavais;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		ps.close();
		pools.liberarConnection(con);
	}
	
	return carnavais;
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