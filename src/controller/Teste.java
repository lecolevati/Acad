package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import persistence.ConexaoDao;

@WebServlet("/teste")
public class Teste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Teste() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		byte[] bytes = null;
		ServletContext context = getServletContext();
		String logoFatec = context.getRealPath("/WEB-INF/images/fateczl.png");
		System.out.println(logoFatec);
		try {
			HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("Logo", logoFatec);
			JasperReport relatorioJasper = (JasperReport) JRLoader
					.loadObjectFromFile(context
							.getRealPath("/WEB-INF/reports/teste.jasper"));
			bytes = JasperRunManager.runReportToPdf(relatorioJasper,
					parametros, new ConexaoDao().fazConexao());

		} catch (SQLException | JRException e) {
			e.printStackTrace();
		} finally {
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		}
	}
}
