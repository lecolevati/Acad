package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoricoDao {

	Connection c;
	
	public HistoricoDao() throws SQLException{
		ConexaoDao cDao = new ConexaoDao();
		c = cDao.fazConexao();
	}

	public ResultSet relatorioHistoricoLimpo(String ra) throws SQLException{
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct he.NumeroDeMatricula, al.nome, disc.NomeDaDisciplina, ");
		sql.append("he.SemestreEAno, he.Conceito, he.Media, estrut.Periodo, ");
		sql.append("cur.NomeDoCurso, al.ClassificacaoNoVestibular,  ");
		sql.append("CONVERT(CHAR(10),al.DataDoVestibular,103) AS DataDoVestibular, "); 
		sql.append("al.TotalDePontosNoVestibular ");
		sql.append("from HistoricosEscolares he ");
		sql.append("inner join Alunos al ");
		sql.append("on al.NumeroDeMatricula = he.NumeroDeMatricula ");
		sql.append("inner join Disciplinas disc ");
		sql.append("on disc.CodigoDaDisciplina = he.CodigoDaDisciplina ");
		sql.append("inner join Cursos cur ");
		sql.append("on cur.CodigoDoCurso = al.CodigoDoCurso ");
		sql.append("inner join ListagemDasEstruturasCurriculares estrut ");
		sql.append("on estrut.CodigoDaDisciplina = disc.CodigoDaDisciplina ");
		sql.append("where he.NumeroDeMatricula = ? and he.Media >= 6 ");
		sql.append("order by estrut.Periodo ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setString(1, ra);
		return ps.executeQuery();
	}
	
}
