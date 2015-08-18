package persistence;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.leandrocolevati.bancodedados.GenericDao;
import br.com.leandrocolevati.bancodedados.Sgbd;

public class ConexaoDao {

	Connection c;
	
	public Connection fazConexao() throws SQLException{
		GenericDao gDao = new GenericDao("localhost", "l.colevati", "com@fatec", "academico", true, Sgbd.SQLSERVER);
		c = gDao.getConnection();
		return c;
	}
	
}
