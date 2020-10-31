package iao.zack.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.function.Predicate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import iao.zack.dao.Compte;
import iao.zack.model.Credit;

/**
 * Servlet implementation class DeletCreditServlet
 */
@WebServlet("/delet")
public class DeletCreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletCreditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		int id = Integer.parseInt(request.getParameter("id_credit"));
		@SuppressWarnings("unchecked")
		LinkedList<Credit> l = (LinkedList<Credit>) session.getAttribute("allCredits");

		Predicate<Credit> condition = credit -> credit.getNumero() == id;
		l.removeIf(condition);
		session.setAttribute("allCredits", l);

		Compte.deletCredit(id);

		response.sendRedirect("Compte.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
