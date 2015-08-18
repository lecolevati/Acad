package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListaRegulares;
import persistence.ListaDao;

@WebServlet("/listas")
public class Listas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Listas() {
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
		int codigoDisciplina = Integer.parseInt(request
				.getParameter("codigoDisciplina"));
		int codigoTurno = Integer.parseInt(request.getParameter("codigoTurno"));
		String erro = "";
		String msg = "";
		List<ListaRegulares> lista = new ArrayList<ListaRegulares>();
		try {
			ListaDao lDao = new ListaDao();
			lista = lDao.ListaPorDisciplinaTurno(
					codigoDisciplina, codigoTurno);
		} catch (SQLException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("erro", erro);
			if (!lista.isEmpty()){
				request.setAttribute("listaRegulares", lista);
				request.setAttribute("disciplina", lista.get(0).getNomeDaDisciplina());
				request.setAttribute("turno", lista.get(0).getTurnoPorExtenso());
				request.setAttribute("curso", lista.get(0).getNomeDoCurso());
			} else {
				msg = "Não existem dados para os parâmetros solicitados";
			}
			request.setAttribute("mensagem", msg);
			request.setAttribute("codigoDisciplina", codigoDisciplina);
			request.setAttribute("codigoTurno", codigoTurno);
			RequestDispatcher view = request.getRequestDispatcher("listaNotas.jsp");
			view.forward(request, response);
		}

	}
}
