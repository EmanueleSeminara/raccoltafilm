package it.prova.raccoltafilm.web.servlet.utente;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.raccoltafilm.model.Ruolo;
import it.prova.raccoltafilm.model.StatoUtente;
import it.prova.raccoltafilm.model.Utente;
import it.prova.raccoltafilm.service.MyServiceFactory;
import it.prova.raccoltafilm.utility.UtilityForm;

@WebServlet("/utente/ExecuteEditUtenteServlet")
public class ExecuteEditUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// estraggo input
		String idUtente = request.getParameter("idUtente");

		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String usernameParam = request.getParameter("username");
		String passwordParam = request.getParameter("password");
		String statoParam = request.getParameter("stato");
		String[] ruoliParam = request.getParameterValues("ruoloInput");

		System.out.println("STATO: " + statoParam);
		Utente utenteInstance = UtilityForm.createUtenteFromParams(nomeParam, cognomeParam, usernameParam,
				new SimpleDateFormat("dd/MM/yyyy").format(new Date()), passwordParam, ruoliParam,
				StatoUtente.valueOf(statoParam));

		System.out.println(utenteInstance);
		try {

			// se la validazione non risulta ok
			if (!UtilityForm.validateUtenteBean(utenteInstance)) {
				request.setAttribute("edit_utente_attr", utenteInstance);
				request.setAttribute("ruoli_list_attribute", UtilityForm.buildCheckedRolesFromRolesAlreadyInUtente(
						MyServiceFactory.getRuoloServiceInstance().listAll(), utenteInstance.getRuoli()));
				request.setAttribute("list_stati_attr", StatoUtente.values());
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
				request.getRequestDispatcher("/utente/edit.jsp").forward(request, response);
				return;
			}

			Map<Ruolo, Boolean> ruoli = UtilityForm.buildCheckedRolesFromRolesAlreadyInUtente(
					MyServiceFactory.getRuoloServiceInstance().listAll(), utenteInstance.getRuoli());
			for (Ruolo ruoloItem : ruoli.keySet()) {
				if (ruoli.get(ruoloItem)) {
					MyServiceFactory.getUtenteServiceInstance().aggiungiRuolo(utenteInstance, ruoloItem);
				} else {
					MyServiceFactory.getUtenteServiceInstance().eliminaRuolo(utenteInstance, ruoloItem);
				}
			}
			// utenteInstance.setRuoli(ruoliParam);
			// se sono qui i valori sono ok quindi posso creare l'oggetto da inserire
			// occupiamoci delle operazioni di business
			// utenteInstance.
			utenteInstance.setId(Long.parseLong(idUtente));
			MyServiceFactory.getUtenteServiceInstance().aggiorna(utenteInstance);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.setAttribute("ruoli_list_attribute", utenteInstance.getRuoli());
			request.getRequestDispatcher("/utente/edit.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		// uso il sendRedirect con parametro per evitare il problema del double save on
		// refresh
		response.sendRedirect("ExecuteListUtenteServlet?operationResult=SUCCESS");
	}

}
