package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;

import constantes.InterfaceConstantes;

public class Pool implements InterfacePool {

	private InterfaceDataSource ds;
	private ArrayBlockingQueue<Connection> conexoesLivres;
	private HashMap<String, Connection> conexoesUtilizadas;
	private Integer numeroMaximoConexoes;

	public Pool() {
		ds = new Conexao();
		numeroMaximoConexoes = InterfaceConstantes.NUMEROMAXIMOCONEXAO;
		conexoesLivres = new ArrayBlockingQueue<Connection>(
				InterfaceConstantes.NUMEROMAXIMOCONEXAO, true);
		conexoesUtilizadas = new HashMap<String, Connection>();
	}

	@Override
	public Connection getConnection() {

		Connection con = null;

		try {
			if (conexoesUtilizadas.size() < numeroMaximoConexoes) {
				con = conexoesLivres.poll();
				if (con == null)
					con = ds.getConnection();
				else if (con.isClosed()) {
					this.getConnection();
				}
				conexoesUtilizadas.put(con.toString(), con);
			}
		} catch (SQLException e) {

			System.out.println("Problemas com a conexão");
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public void liberarConnection(Connection conn) {
		conexoesLivres.add(conn);
		conexoesUtilizadas.remove(conn.toString());

	}

}
