package ma.norsys.technomaker.catalogue.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VidePanier
 */
public class VidePanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VidePanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	- on recherche dans les cookies
		//	- et on supprime tous les cookies qui commencent par 'panier_'
		
		Cookie [] coockies = request.getCookies();
		for (int i = 0; i < coockies.length; i++) {
			Cookie unCookie = coockies[i];
			if ("panier_".equals(unCookie.getName().substring(0, 7))) {
				unCookie.setMaxAge(0);
				response.addCookie(unCookie);
			}
		}
		//	-pour rediriger vers la JSP 'AfficheCatalogueJSP' 
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
