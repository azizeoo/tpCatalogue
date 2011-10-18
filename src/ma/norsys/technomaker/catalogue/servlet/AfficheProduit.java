package ma.norsys.technomaker.catalogue.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.norsys.technomaker.catalogue.bean.Catalogue;
import ma.norsys.technomaker.catalogue.bean.Produit;

/**
 * Servlet implementation class AfficheProduit
 */
public class AfficheProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Catalogue catalogue = Catalogue.getInstance();
		//recuperation d'objet volu par id
		Produit produit = catalogue.getListProduit().get(request.getParameter("id"));
		
		out.println("<head><link rel='stylesheet' type='text/css' href='"+request.getContextPath() + "/css/styles.css'></head>");
		out.println("<body>");
		out.println("<div class='produit'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td rowspan=\"2\">");
		if(null != produit.getImage()){
			out.println("<img src='" + produit.getImage() + "' />");		
		}
		out.println("</td>");
		out.println("<td class='nom'>" + produit.getNom()+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td class='prix'>" + produit.getPrix() +"&nbsp;&euro;</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' class='desc'>");
		if(null != produit.getDescription()){
			out.println(produit.getDescription());		
		}
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</div>");
		out.println("<form method='get' action='AjouteAuPanier'>");
		out.println("<input type='hidden' name='id' value='" + produit.getId()+ "'/>");
		out.println("<input type='submit' value='ajouter au panier' />");
		out.println("</form>");
		out.println("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
