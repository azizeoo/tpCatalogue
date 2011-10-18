package ma.norsys.technomaker.catalogue.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.norsys.technomaker.catalogue.bean.Catalogue;

/**
 * Servlet implementation class AfficheCatalogueJSTL
 */
public class AfficheCatalogueJSTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheCatalogueJSTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/afficheCatalogueJSP.jsp");
		//	- On recupere une instance du catalogue et on l'ajoute
		//	- au scope request pour le recupere dans la JSP 'afficheCatalogueJSP.jsp'
		Catalogue catalogue = Catalogue.getInstance();
		request.setAttribute("catalogue", catalogue);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
