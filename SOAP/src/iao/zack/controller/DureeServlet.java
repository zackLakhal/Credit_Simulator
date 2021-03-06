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
import iao.zack.ws.CreditWSStub.CalculDuree;
import iao.zack.ws.CreditWSStub.CalculDureeResponse;

/**
 * Servlet implementation class DureeServlet
 */
@WebServlet("/duree")
public class DureeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DureeServlet() {
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
			CalculDuree d = new CalculDuree();
			double annuiteValue = Double.parseDouble(request.getParameter("Annuitee"));
			double capitalValue = Double.parseDouble(request.getParameter("Capital"));
			double taux = Double.parseDouble(request.getParameter("Taux"));
			double tauxValue = (Double.parseDouble(request.getParameter("Taux"))) * 0.01;

			boolean etatreg = false;
			String saveval = "enregistré";

			d.setA(annuiteValue);
			d.setC(capitalValue);
			d.setT(tauxValue);

			CalculDureeResponse resp = stub.calculDuree(d);
			int repDuree = (int) resp.get_return();

			if (saveval.equals(request.getParameter("addBD"))) {
				Credit c = new Credit();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date dt = new Date();
				String date = dateFormat.format(dt);
				int numeroClient = (int) session.getAttribute("idClient");
				c.setDate(date);
				c.setCapital(capitalValue);
				c.setTaux(taux);
				c.setAnnuite(annuiteValue);
				c.setDuree(repDuree);
				c.setClientnum(numeroClient);
				boolean check = SaveCredit.saveNewCredit(c);
				if (check) {
					etatreg = true;
				}
			}

			session.setAttribute("dureerep", repDuree);
			session.setAttribute("capitalrep", capitalValue);
			session.setAttribute("tauxrep", taux);
			session.setAttribute("anuiterep", annuiteValue);
			session.setAttribute("addBDrep", etatreg);
		} else {

			session.setAttribute("anuiterep", null);
			session.setAttribute("capitalrep", null);
			session.setAttribute("tauxrep", null);
			session.setAttribute("dureerep", null);
			session.setAttribute("addBDrep", null);
		}
		response.sendRedirect("Duree.jsp");
		// this.getServletContext().getRequestDispatcher( "Duree.jsp" ).forward(
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
