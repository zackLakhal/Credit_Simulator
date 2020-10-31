package iao.zack.controller;

import java.io.IOException;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import iao.zack.dao.SaveCredit;
import iao.zack.model.Credit;


/**
 * Servlet implementation class AnnuiteServlet
 */
@WebServlet("/annuite")
public class AnnuiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnnuiteServlet() {
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
			
	      

			double capitalValue = Double.parseDouble(request.getParameter("Capital"));
			int dureeValue = (int) Double.parseDouble(request.getParameter("Duree"));
			double taux = Double.parseDouble(request.getParameter("Taux"));

			double tauxValue = (Double.parseDouble(request.getParameter("Taux"))) * 0.01;
			boolean etatreg = false;
			String saveval = "enregistré";
			
			Client client = ClientBuilder.newClient();

			double annuite = client.target("http://localhost:8020/REST/rest/credit/calculMensualite").queryParam("capital", capitalValue).queryParam("duree", dureeValue).queryParam("taux", tauxValue).request().get(Double.class);			
	
			 
			double repAnnuite = Math.round(annuite);

			if (saveval.equals(request.getParameter("addBD"))) {

				Credit c = new Credit();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date d = new Date();
				String date = dateFormat.format(d);
				int numeroClient = (int) session.getAttribute("idClient");
				c.setDate(date);
				c.setCapital(capitalValue);
				c.setTaux(taux);
				c.setAnnuite(repAnnuite);
				c.setDuree(dureeValue);
				c.setClientnum(numeroClient);
				boolean check = SaveCredit.saveNewCredit(c);
				if (check) {
					etatreg = true;
				}

			}

			session.setAttribute("anuiterep", repAnnuite);
			session.setAttribute("capitalrep", capitalValue);
			session.setAttribute("tauxrep", taux);
			session.setAttribute("dureerep", dureeValue);
			session.setAttribute("addBDrep", etatreg);
		} else {

			session.setAttribute("anuiterep", null);
			session.setAttribute("capitalrep", null);
			session.setAttribute("tauxrep", null);
			session.setAttribute("dureerep", null);
			session.setAttribute("addBDrep", null);
		}

		response.sendRedirect("Annuite.jsp");
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
