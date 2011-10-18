<%@ include file="taglib.jsp"%>
<%@page import="ma.norsys.technomaker.catalogue.bean.Produit"%>
<%@page import="ma.norsys.technomaker.catalogue.bean.Catalogue"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=stylesheet type="text/css"
	href="<%=request.getContextPath() %>/css/styles.css" />
<title><fmt:message key="message.titre.afficheCatalogueJSTL" /></title>
</head>
<body>

	<jsp:include page="/jsp/header.jsp"></jsp:include>
	
	<div class="titre"><fmt:message key="message.div.panier" /></div>
	
<!-- 	- RECUPERATION DES PAIRES (String,Produit) 
		- POUR AFFICHER LES INFORMATIONS SUR UN PRODUIT -->
	<c:forEach var="produit" items="${requestScope.panierCatalogue.listProduit}">
		<div class="produit">
			<table>
				<tr>
					<td rowspan="2"><c:if test="${null != produit.value.image }">
							<img src="${produit.value.image}" />
						</c:if></td>

					<td class="nom">${produit.value.nom}</td>
				</tr>
				<tr>
					<td class="prix">${produit.value.prix}&nbsp;&euro;</td>
				</tr>
				<tr>
					<td colspan="2" class="desc"><c:if
							test="${null != produit.value.description}">
					${produit.value.description}
					</c:if></td>
				</tr>
			</table>
		</div>

	</c:forEach>

<!-- 		- TESTE POUR SAVOIR SI LE PANIER EST VIDE OU PAS -->
	<c:if test="${empty requestScope.panierCatalogue.listProduit}">
		<p><fmt:message key="message.p.aucunProduit" /></p>
	</c:if>
</body>
</html>