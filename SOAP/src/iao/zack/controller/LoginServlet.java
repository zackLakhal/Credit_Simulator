package iao.zack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import iao.zack.dao.UserLogin;
import iao.zack.model.Client;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);

		String email = request.getParameter("email_login");
		String password = request.getParameter("password_login");
		Client client = UserLogin.validateUser(email, password);

		boolean error = false;
		if (client.getMail() != null) {

			session.setAttribute("villeClient", client.getVille());
			session.setAttribute("adresseClient", client.getAdresse());
			session.setAttribute("phoneClient", client.getTelephone());
			session.setAttribute("emailClient", client.getMail());
			session.setAttribute("prenomClient", client.getPrenom());
			session.setAttribute("idClient", client.getNumeroClient());
			session.setAttribute("nomClient", client.getNom());

		} else {
			error = true;
		}
		session.setAttribute("error_login", error);
		response.sendRedirect(request.getParameter("viewid_login"));
		// request.getRequestDispatcher(request.getParameter("viewid")).forward(request,
		// response);

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
