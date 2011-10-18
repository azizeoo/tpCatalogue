package ma.norsys.technomaker.catalogue.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjouteAuPanier
 */
public class AjouteAuPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouteAuPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie monCookie = new Cookie("panier_" + request.getParameter("id"), request.getParameter("id"));
		monCookie.setMaxAge(6000);

		
		//on recherche un cookie
		Cookie [] coockies = request.getCookies();
		boolean existe = false;
		for (int i = 0; i < coockies.length; i++) {
			Cookie unCookie = coockies[i];
			if (request.getParameter("id").equals(unCookie.getValue())) {
				existe = true;
				break;
			}
		}
		
		if(!existe){
			response.addCookie(monCookie);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("AfficheCatalogueJSP");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
