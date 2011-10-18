package ma.norsys.technomaker.catalogue.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.norsys.technomaker.catalogue.bean.Catalogue;
import ma.norsys.technomaker.catalogue.bean.Produit;

/**
 * Servlet implementation class AffichePanier
 */
public class AffichePanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichePanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/afficheCatalogueJSTL.jsp");
		Catalogue cataloguePanier = new Catalogue();
		HashMap<String, Produit> listProduit = new HashMap<String, Produit>();
		//on recherche un cookie
		Cookie [] coockies = request.getCookies();
		Catalogue catalogue = Catalogue.getInstance();
		for (int i = 0; i < coockies.length; i++) {
			Cookie unCookie = coockies[i];
			if ("panier_".equals(unCookie.getName().substring(0, 7))) {
				Produit produit = catalogue.getListProduit().get(unCookie.getValue());
				listProduit.put(produit.getId(), produit);
			}
		}
		cataloguePanier.setListProduit(listProduit);
		request.setAttribute("panierCatalogue", cataloguePanier);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
