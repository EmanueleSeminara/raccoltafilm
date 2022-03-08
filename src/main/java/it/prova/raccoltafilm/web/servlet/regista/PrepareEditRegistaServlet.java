package it.prova.raccoltafilm.web.servlet.regista;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.raccoltafilm.service.MyServiceFactory;

@WebServlet("/PrepareEditRegistaServlet")
public class PrepareEditRegistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idRegista = request.getParameter("idRegista");

		if (!NumberUtils.isCreatable(idRegista)) {
			request.setAttribute("errorMessage", "Attenzione, non è stato trovato il regista corrispondente");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}

		try {

			request.setAttribute("edit_regista_attr",
					MyServiceFactory.getRegistaServiceInstance().caricaSingoloElemento(Long.parseLong(idRegista)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/regista/edit.jsp").forward(request, response);
	}

}
