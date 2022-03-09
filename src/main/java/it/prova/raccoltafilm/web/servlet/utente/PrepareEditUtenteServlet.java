package it.prova.raccoltafilm.web.servlet.utente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.raccoltafilm.model.StatoUtente;
import it.prova.raccoltafilm.model.Utente;
import it.prova.raccoltafilm.service.MyServiceFactory;
import it.prova.raccoltafilm.utility.UtilityForm;

@WebServlet("/utente/PrepareEditUtenteServlet")
public class PrepareEditUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idUtente = request.getParameter("idUtente");

		if (!NumberUtils.isCreatable(idUtente)) {
			request.setAttribute("errorMessage", "Attenzione, non è stato trovato il utente corrispondente");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}

		try {
			Utente utenteDaModificare = MyServiceFactory.getUtenteServiceInstance()
					.caricaSingoloElementoEager(Long.parseLong(idUtente));
			request.setAttribute("edit_utente_attr", utenteDaModificare);
			request.setAttribute("list_stati_attr", StatoUtente.values());
			request.setAttribute("ruoli_list_attribute", UtilityForm.buildCheckedRolesFromRolesAlreadyInUtente(
					MyServiceFactory.getRuoloServiceInstance().listAll(), utenteDaModificare.getRuoli()));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/utente/edit.jsp").forward(request, response);
	}

}
