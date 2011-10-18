package ma.norsys.technomaker.catalogue.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.norsys.technomaker.catalogue.bean.Catalogue;
import ma.norsys.technomaker.catalogue.bean.Produit;

/**
 * Servlet implementation class InitCatalogue
 */
public class InitCatalogue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitCatalogue() {
        super();
		Produit produit1 = new Produit();
		produit1.setId("P1");
		produit1.setNom("PHILIPS 52PFL7203H");
		produit1.setPrix(1499.99f);
		Produit produit2 = new Produit();
		produit2.setId("P2");
		produit2.setNom("SAMSU_PS42A416");
		produit2.setPrix(589.99f);
//		produit2.setImage("http://ak.cdiscount.com/pdt/4/1/6/1/d/SAMSU_PS42A416.jpg");
		produit2.setImage("http://assos.blogvie.com/files/2009/02/samsu_ps42a416.jpg");
		produit2.setDescription("Téléviseur Plasma 42\" (106 cm) 16:9 - Tuner TNT intégré - Double HDMI - Entrée PC -"
		+ "Résolution: 1024 x 768 - Luminosité: 1500 cd/m² - Taux de contraste: 100 000:1 - Angle de vision: 175°");
		Produit produit3 = new Produit();
		produit3.setId("P3");
		produit3.setNom("PHILIPS 52PFL7203H");
//		produit3.setImage("http://ak.cdiscount.com/pdt/0/3/H/1/d/PHIL_52PFL7203H.jpg");
		produit3.setImage("http://www.son-video.com/images/static/Rayons/Video/EcransLCD/Philips/52PFL7203H/52PFL7203H_face_L.jpg");
		produit3.setPrix(1499.99f);
		Produit produit4 = new Produit();
		produit4.setId("P4");
		produit4.setNom("TOSHIBA 32CV515DG");
		produit4.setPrix(499.99f);
		produit4.setDescription("Téléviseur LCD 32\" (81 cm) 16:9 HD TV - Tuner TNT HD intégré - Triple HDMI - Résolution:"
		+ "1366 x 768 - Luminosité: 500 cd/m² - Contraste: 30000:1 - Temps de réponse: 8 ms - Angle de vision: 178°");
		HashMap<String, Produit> listProduit = new HashMap<String, Produit>();
		listProduit.put(produit1.getId(), produit1);
		listProduit.put(produit2.getId(), produit2);
		listProduit.put(produit3.getId(), produit3);
		listProduit.put(produit4.getId(), produit4);
		Catalogue catalogue = Catalogue.getInstance();
		catalogue.setNom("Catalogue");
		catalogue.setListProduit(listProduit);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
