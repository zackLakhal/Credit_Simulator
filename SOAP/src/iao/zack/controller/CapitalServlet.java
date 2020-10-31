package iao.zack.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import iao.zack.dao.SaveCredit;
import iao.zack.model.Credit;
import iao.zack.ws.CreditWSStub;
import iao.zack.ws.CreditWSStub.CalculCapital;
import iao.zack.ws.CreditWSStub.CalculCapitalResponse;

/**
 * Servlet implementation class CapitalServlet
 */
@WebServlet("/capital")
public class CapitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CapitalServlet() {
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
		if (request.getParameter("sub").equals("calculer")) {
			CreditWSStub stub = new CreditWSStub();
			CalculCapital c = new CalculCapital();
			double annuiteValue = Double.parseDouble(request.getParameter("Annuitee"));
			int dureeValue = (int) Double.parseDouble(request.getParameter("Duree"));
			double taux = (Double.parseDouble(request.getParameter("Taux")));
			double tauxValue = (Double.parseDouble(request.getParameter("Taux"))) * 0.01;

			boolean etatreg = false;
			String saveval = "enregistré";

			c.setA(annuiteValue);
			c.setN(dureeValue);
			c.setT(tauxValue);

			CalculCapitalResponse resp = stub.calculCapital(c);
			double repCapital = Math.round(resp.get_return());

			if (saveval.equals(request.getParameter("addBD"))) {
				Credit cred = new Credit();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date d = new Date();
				String date = dateFormat.format(d);
				int numeroClient = (int) session.getAttribute("idClient");
				cred.setDate(date);
				cred.setCapital(repCapital);
				cred.setTaux(taux);
				cred.setAnnuite(repCapital);
				cred.setDuree(dureeValue);
				cred.setClientnum(numeroClient);
				boolean check = SaveCredit.saveNewCredit(cred);
				if (check) {
					etatreg = true;
				}
			}

			session.setAttribute("anuiterep", annuiteValue);
			session.setAttribute("capitalrep", repCapital);
			session.setAttribute("dureerep", dureeValue);
			session.setAttribute("tauxrep", taux);
			session.setAttribute("addBDrep", etatreg);
		} else {

			session.setAttribute("anuiterep", null);
			session.setAttribute("capitalrep", null);
			session.setAttribute("tauxrep", null);
			session.setAttribute("dureerep", null);
			session.setAttribute("addBDrep", null);
		}

		response.sendRedirect("Capital.jsp");
		// this.getServletContext().getRequestDispatcher("Annuite.jsp").forward(
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
