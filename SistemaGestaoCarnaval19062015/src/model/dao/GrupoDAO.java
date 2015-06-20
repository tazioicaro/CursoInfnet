package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.negocio.DesfileTO;
import model.negocio.Grupo;
import conexao.InterfacePool;

public class GrupoDAO implements InterfaceGrupoDAO {

	private InterfacePool pools;

	public GrupoDAO(InterfacePool pools) {
		this.pools = pools;
	}

	@Override
	public boolean incluir(Grupo grupo) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;

		try {
			con = pools.getConnection();

			ps = con.prepareStatement("INSERT INTO grupo (grupo) VALUES (?)");
			
			ps.setString(1, grupo.getGrupo());

			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
			ps = con.prepareStatement("DELETE FROM grupo WHERE id = ?");
			ps.setLong(1, codigo);

			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ps.close();
			pools.liberarConnection(con);
		}

		return false;
	}

	@Override
	public Set<Grupo> obterGrupos() throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<Grupo> grupos = new HashSet<Grupo>();
		Connection con = null;

		try {

			con = pools.getConnection();
			ps = con.prepareStatement("SELECT * FROM grupo");
			rs = ps.executeQuery();
			
			while (rs.next()) {

				Grupo grupo = new Grupo();
				grupo.setId(rs.getInt("id"));
				grupo.setGrupo(rs.getString("grupo"));
				
				grupos.add(grupo);

			}

			return grupos;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ps.close();
			pools.liberarConnection(con);

		}

		return null;
	}
}