package it.prova.raccoltafilm.web.servlet.regista;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.raccoltafilm.exceptions.RegistaConFilmException;
import it.prova.raccoltafilm.service.MyServiceFactory;

@WebServlet("/ExecuteDeleteRegistaServlet")
public class ExecuteDeleteRegistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idRegistaParam = request.getParameter("idRegista");

		if (!NumberUtils.isCreatable(idRegistaParam)) {
			request.setAttribute("errorMessage", "Attenzione, non è stato trovato l'regista corrispondente");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		try {
			MyServiceFactory.getRegistaServiceInstance().rimuovi(Long.parseLong(idRegistaParam));
			request.setAttribute("registi_list_attribute",
					MyServiceFactory.getRegistaServiceInstance().listAllElements());
		} catch (RegistaConFilmException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Impossibile eliminare il regista poichè vi sono film associati");
			try {
				request.setAttribute("delete_regista_attr", MyServiceFactory.getRegistaServiceInstance()
						.caricaSingoloElemento(Long.parseLong(idRegistaParam)));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.getRequestDispatcher("/regista/delete.jsp").forward(request, response);

			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("ExecuteListRegistaServlet?operationResult=NOT_FOUND").forward(request,
					response);
		}

		request.getRequestDispatcher("/regista/list.jsp").forward(request, response);
	}

}
