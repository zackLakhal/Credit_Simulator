package iao.zack.controller;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import iao.zack.dao.Compte;
import iao.zack.model.Credit;

/**
 * Servlet implementation class CompteServlet
 */
@WebServlet("/compte")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("idClient");
		// System.out.println(id);
		LinkedList<Credit> c = Compte.getAllCredits(id);
		// for(Credit l : c) {
		// System.out.println(l);
		// }
		if (c.size() > 0) {
			session.setAttribute("allCredits", c);
		}
		response.sendRedirect("Compte.jsp");
		// this.getServletContext().getRequestDispatcher("/Compte.jsp").forward(
		// request, response );
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
