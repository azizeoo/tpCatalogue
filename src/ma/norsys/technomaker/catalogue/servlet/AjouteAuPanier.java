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
		//	- l'age du cookie en secondes
		monCookie.setMaxAge(6000);
		
		//	- on recherche si un cookie exite déjà dans les cookies 
		//	- si il n'existe pas on l'ajoute dans les cookies
		// 	- puis on redirige vers la JSP pour afficher le catalogue
		Cookie [] coockies = request.getCookies();
		boolean existe = false;
		for (int i = 0; i < coockies.length; i++) {
			Cookie unCookie = coockies[i];
			if (request.getParameter("id").equals(unCookie.getValue())) {
				existe = true;
				break;
			}
		}
		
		//	- On teste si le cookie n'existe pas
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
