package iao.zack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import iao.zack.dao.UserSignUp;
import iao.zack.model.Client;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Client newClient = new Client();
		boolean error = false;
		String nomInputForm = request.getParameter("nom_register");
		String prenomInputForm = request.getParameter("prenom_register");
		String mailInputForm = request.getParameter("email_register");
		String passwordInputForm = request.getParameter("password_register");
		String adresseInputForm = request.getParameter("adress_register");
		String villeInputForm = request.getParameter("ville_register");
		String phoneInputForm = request.getParameter("tel_register");
		newClient.setNom(nomInputForm);
		newClient.setPrenom(prenomInputForm);
		newClient.setMail(mailInputForm);
		newClient.setMotdepasse(passwordInputForm);
		newClient.setAdresse(adresseInputForm);
		newClient.setVille(villeInputForm);
		newClient.setTelephone(phoneInputForm);
		boolean exist = UserSignUp.isExist(mailInputForm);

		if (!exist) {
			boolean check = UserSignUp.registerClient(newClient);

			if (check) {

				session.setAttribute("villeClient", newClient.getVille());
				session.setAttribute("adresseClient", newClient.getAdresse());
				session.setAttribute("phoneClient", newClient.getTelephone());
				session.setAttribute("emailClient", newClient.getMail());
				session.setAttribute("prenomClient", newClient.getPrenom());
				session.setAttribute("idClient", newClient.getNumeroClient());
				session.setAttribute("nomClient", newClient.getNom());

			}
		} else {

			error = true;

		}
		session.setAttribute("error_register", error);
		response.sendRedirect(request.getParameter("viewid_register"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
