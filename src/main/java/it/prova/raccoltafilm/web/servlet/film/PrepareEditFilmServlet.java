package it.prova.raccoltafilm.web.servlet.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.raccoltafilm.service.MyServiceFactory;

@WebServlet("/PrepareEditFilmServlet")
public class PrepareEditFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdDellFilmDaEliminare = request.getParameter("idFilm");

		if (!NumberUtils.isCreatable(parametroIdDellFilmDaEliminare)) {
			request.setAttribute("errorMessage", "Attenzione, non è stato trovato l'film corrispondente");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		try {

			request.setAttribute("edit_film_attr", MyServiceFactory.getFilmServiceInstance()
					.caricaSingoloElementoEager(Long.parseLong(parametroIdDellFilmDaEliminare)));
			request.setAttribute("registi_list_attribute",
					MyServiceFactory.getRegistaServiceInstance().listAllElements());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/film/edit.jsp").forward(request, response);
	}

}
