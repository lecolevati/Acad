package controller;

import java.io.IOException;
import java.io.PrintStream;
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

@WebServlet("/historico")
public class GeraHistorico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GeraHistorico() {
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
		String ra = request.getParameter("ra");
		String logoFatec = context.getRealPath("/WEB-INF/images/fateczl.png");
		try {
			HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("ID", ra);
			parametros.put("FatecLogo", logoFatec);
			JasperReport relatorioJasper = (JasperReport) JRLoader
					.loadObjectFromFile(context
							.getRealPath("/WEB-INF/reports/AcadHistoricoLimpo.jasper"));
			bytes = JasperRunManager.runReportToPdf(relatorioJasper,
					parametros, new ConexaoDao().fazConexao());
//			bytes = null;
		} catch (SQLException | JRException e) {
			e.printStackTrace();
		} finally {
			if (bytes != null) {
				response.setContentType("application/pdf");
				response.setContentLength(bytes.length);
				ServletOutputStream ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} else {
				PrintStream tela = new PrintStream(response.getOutputStream());
				tela.println("<HTML><BODY>");
				tela.println("<script>alert('bytes == null ==> RA = '"+ra+");history.back();</script>");
				tela.println("<BR><P>");
				tela.println("</HTML></BODY>");
			}
		}
	}
}
