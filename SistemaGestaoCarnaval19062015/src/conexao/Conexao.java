package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao  implements InterfaceDataSource{
	
	private String url;
	private String bandoDados;
	private String usuario;
	private String senha;
	private String serverName;
	
	
	private static Connection conn = null;
	
	public Conexao ( ){
          super();		
			
			serverName = "localhost";				
			bandoDados = "samba";  				
			url = "jdbc:mysql://" + serverName + "/" + bandoDados;
			usuario = "root";   
			senha = "root";
			
						
			if (conn == null){
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			
			}
		}		
		

	@Override
	public Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(url,usuario, senha);
	}
}