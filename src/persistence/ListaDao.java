package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ListaRegulares;

public class ListaDao {

	private Connection c;
	
	public ListaDao() throws SQLException{
		ConexaoDao cDao = new ConexaoDao();
		c = cDao.fazConexao();
	}
	
	public List<ListaRegulares> ListaPorDisciplinaTurno(int codigoDisciplina, 
			int codigoTurno) throws SQLException{
		List<ListaRegulares> lista = new ArrayList<ListaRegulares>();
		String sql = "SELECT * FROM fn_listaregularespordisciplinaturno(?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, codigoDisciplina);
		ps.setInt(2, codigoTurno);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			ListaRegulares lr = new ListaRegulares();
			lr.setCodigoDaDisciplina(rs.getInt("CodigoDaDisciplina"));
			lr.setCodigoDaTurma(rs.getInt("CodigoDaTurma"));
			lr.setCodigoDoCurso(rs.getInt("CodigoDoCurso"));
			lr.setCodigoDoTurno(rs.getInt("CodigoDoTurno"));
			lr.setConceito(rs.getString("Conceito"));
//			lr.setMedia(rs.getString("Media"));
			lr.setMedia(rs.getDouble("Media"));
			lr.setNome(rs.getString("Nome"));
			lr.setNomeDaDisciplina(rs.getString("NomeDaDisciplina"));
			lr.setNomeDoCurso(rs.getString("NomeDoCurso"));
			lr.setNumeroDeMatricula(rs.getString("NumeroDeMatricula"));
			lr.setSiglaDaDisciplina(rs.getString("SiglaDaDisciplina"));
			lr.setSiglaDoCurso(rs.getString("SiglaDoCurso"));
			lr.setTurnoPorExtenso(rs.getString("TurnoPorExtenso"));
			lista.add(lr);
		}
		return lista;
	}
}
