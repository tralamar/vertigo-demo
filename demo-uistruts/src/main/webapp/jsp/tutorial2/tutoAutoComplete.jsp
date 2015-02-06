<%@page import="kasper.ui.controller.*,io.vertigo.demo.controller.*,io.vertigo.demo.ui.tutorial.*,io.vertigo.demo.services.produit.*,   java.util.*"%>
<%@taglib uri="/WEB-INF/kasper_demo.tld" prefix="demo" %>
<%@taglib uri="/META-INF/kasper.tld" prefix="kasper" %>
<kasper:page style="tuto" controllerclass="io.vertigo.demo.ui.controller.tutorial.TutoSelectionController" title="Tutoriel - AutoComplete">
<table width="100%">
<tr><%@include file="menu.inc" %>
<td>
<div>
<h1>AutoComplete</h1>
<div class="description"><h2>Description</h2>
Ce composant repr�sente un champ de selection avec auto-completion.<br/>
Volontairement ce composant poss�de une API tr�s proche de celle de Selection. Une fusion entre autocomplete et selection est envisager � court/moyen terme.
La liste des valeurs propos�es dans la s�lection peut-�tre d�finie de <s>4</s><b>3</b> fa�ons exclusives :<br/>
<ul>
<li><b>Automatiquement</b> : si le champ surquel est pos� ce composant est une ForeignKey (par une association) vers un DTO d�clar� dans le MasterDataBroker. Si plusieurs MasterDataList sont d�clar�es pour un m�me DT, celle par d�faut est celle d�clar�e en <u>premier</u>.</li>
<li><b>Choix d'une liste de ref</b> : En indiquant l'URI de la liste de ref dans l'attribut <code>masterdatalist</code>.</li>
<li><b>Liste de valeur dans le context</b> : En indiquant le nom de la liste dans le context par l'attribut <code>collectionid</code>, le champ de la liste servant � la jointure dans <code>key</code> et le lib�ll� � afficher dans <code>display</code>.</li>
<li><s><b>Liste de valeur</b> : En fournissant la liste (l'objet java) par l'attribut <code>valuelist</code>, le champ de la liste servant � la jointure dans <code>key</code> et le lib�ll� � afficher dans <code>display</code>.</s></li>
</ul>
Il doit etre pos� dans un tag panel fournissant un DTO courant : <code>&lt;kasper:objectpanel&gt;</code> ou <code>&lt;kasper:listpanel&gt;</code><br/>
<i>Le composant Bean et le Tag correspondant ont les m�me param�tres.</i>
</div>
<div class="api">
<h2>Param�tres :</h2>
<ul> 
	<li><b><u>name</u> <span class="mandatory">*</span></b> : Nom du champ dans le DTO courant.</li>
	<li><s><u>style</u> : Pr�cise le style d'affichage � utiliser.</s></li>
	<li><b><u>masterdatalist</u></b>  : URI de la MasterDataList (Liste de r�f�rence) fournissant les valeurs s�lectionnables.</li>
	<li><b><u>collectionid</u></b>  : Nom dans le context de la liste des valeurs s�lectionnables.</li>
	<li><s><b>valuelist</b> : Liste java des valeurs s�lectionnables (l'objet java).</s></li>
	<li><b><u>key</u></b> : Nom du champ de la liste servant pour la jointure avec le champ � selectionner.</li>
	<li><b><u>display</u></b> : Nom du champ de la liste � utiliser pour l'affichage (peut-�tre un champ calcul�).</li>
	<li><b>nulllabel</b> : Libell� � afficher lorsqu'aucune valeur n'est s�lection�e (�quivalent � null). La valeur par d�faut est d�finit dans le TagRenderer.</li>
	<li><b>readonly</b> : Passe le champ en mode editable ou non �ditable. Par d�faut cette propri�t� est h�rit�e des composants parents.</li>
	<li><b>css</b> : Style css du HTML du field. Le TagRenderer peut l'utiliser pour adapter le rendu.</li>
	<li><b>other</b> : Autres param�tres du composant HTML.</li>
	<li><b>isVisible</b> : Booleen, indiquant si le composant est affich� ou non.</li>
	<li><b>roles</b> : Liste des roles permettant l'utilisation de ce lien. Le lien est invisible pour les utilisateurs qui n'ont pas les droits suffisants.</li>
 </ul>
</div>
<div class="exemple">
<h2>Exemple :</h2>
   <kasper:form>
   <kasper:error/>
   <kasper:objectpanel dtoid="DTO_TUTO_OBJECT" readonly="<%=!controller.isModeEdit()%>">
	Liste des communes <kasper:autocomplete name="TYP_ID" masterdatalist="DTC:MADA_COMMUNES" /><br/>
	Automatique (FK d'une MasterDataList) : <kasper:autocomplete id="TRUC" name="TYP_ID"/><br/>
	Autre liste de ref : <kasper:autocomplete name="TYP_ID" masterdatalist="DTC:MADA_TUTO_TYPE_2" /><br/>
	Liste du context : <kasper:autocomplete id="TRUC3" name="TYP_ID" collectionid="DTC_TUTO_TYPE_SPE" key="TYP_ID" display="LIBELLE"/><br/> 	 
 </kasper:objectpanel>
 <%if(controller.isModeEdit()) {%>
  		<kasper:action name="READ" text="Passer en mode lecture"/>
  	<%} else {%>
  		<kasper:action name="EDIT" text="Passer en mode �dition"/>  		
  	<%}%>
  </kasper:form>
 <br/>
 <h3>Code :</h3>
   <textarea readonly=true rows=5>
&lt;kasper:objectpanel dtoid="DTO_TUTO_OBJECT"&gt;
	 Automatique (FK d'une MasterDataList) : &lt;kasper:autocomplete name="TYP_ID"/&gt;&lt;br/&gt;
	 Autre liste de ref : &lt;kasper:autocomplete name="TYP_ID" masterdatalist="DTC:MADA_TUTO_TYPE_2" /&gt;&lt;br/&gt;
	 Liste du context : &lt;kasper:autocomplete name="TYP_ID" collectionid="DTC_TUTO_TYPE_SPE" key="TYP_ID" display="LIBELLE"/&gt;&lt;br/&gt;
 &lt;/kasper:objectpanel&gt;
</textarea>
</div>
<div class="astuce"><a href="http://wiki.klee.lan.net/index.php/Kasper_4_:_Tutoriel_AutoComplete">Consulter les astuces</a></div>
</td></tr></table>

</kasper:page>
