<%@ include file="taglib.jsp"%>
<%@page import="java.util.Map"%>
<%@page import="ma.norsys.technomaker.catalogue.bean.Produit"%>
<%@page import="ma.norsys.technomaker.catalogue.bean.Catalogue"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=stylesheet type="text/css"
	href="<%=request.getContextPath() %>/css/styles.css" />
<title><fmt:message key="message.titre.afficheCatalogueJSP" /></title>
</head>
<body>
	<jsp:include page="/jsp/header.jsp"></jsp:include>
	<div class="titre"><%=((Catalogue)request.getAttribute("catalogue")).getNom() %></div>
	
<!-- 	PARCOUR DU HASHMAP POUR AFFICHER LES INFORMATIONS SUR LES PRODUITS -->
	<%
	for (Map.Entry<String,Produit> produit : ((Catalogue)request.getAttribute("catalogue")).getListProduit().entrySet()){
	%>
	<div class="produit">
		<table>
			<tr>
				<td rowspan="2">
<!-- 			TESTE POUR SAVOIR SI LE CHAMP EST DIFFENT DE NULL -->
					<% if(null != produit.getValue().getImage()){
					%> <img src="<%=produit.getValue().getImage()%>"> <%}
					%>
				</td>

				<td><a class="nom"
					href="AfficheProduit?id=<%= produit.getKey() %>"> <%= produit.getValue().getNom()%>
				</a>
				</td>
			</tr>
			<tr>
				<td class="prix"><%= produit.getValue().getPrix()%>&nbsp;&euro;</td>
			</tr>
			<tr>
				<td colspan="2" class="desc">
<!-- 			TESTE POUR SAVOIR SI LE CHAMP EST DIFFENT DE NULL -->
					<% if(null!=produit.getValue().getDescription()){
					%> <%=produit.getValue().getDescription()%> <%}
				%>
				</td>
			</tr>
		</table>
	</div>
	<%
	}
	%>
</body>
</html>