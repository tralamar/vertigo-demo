<%@page import="kasper.ui.controller.*,io.vertigo.demo.ui.controller.*,io.vertigo.demo.ui.controller.tutorial2.*, demo.model.produit.*,   java.util.*"%>
<%@taglib uri="/WEB-INF/kasper_demo.tld" prefix="demo" %>
<%@taglib uri="/META-INF/kasper.tld" prefix="kasper" %>
<kasper:page style="tuto" controllerclass="io.vertigo.demo.ui.controller.tutorial.TutoSelectionController" title="Tutoriel - ItemSelect">
<table width="100%">
<tr><%@include file="menu.inc" %>
<td>
<div>
<h1>ItemSelect</h1>
<div class="description"><h2>Description</h2>
Ce composant repr�sente un champ de selection avec popup de selection.<br/>
Son API diff�re de celle de Selection, car il convient de proposer des crit�res de s�l�ction, et non ne pr�senter l'ensemble de la liste.
La liste des valeurs propos�es dans la s�lection peut-�tre d�finie de <b>3</b> fa�ons exclusives :<br/>
<ul>
<li><b>Automatiquement</b> : si le champ surquel est pos� ce composant est une ForeignKey (par une association) vers un DTO d�clar� dans le MasterDataBroker. Si plusieurs MasterDataList sont d�clar�es pour un m�me DT, celle par d�faut est celle d�clar�e en <u>premier</u>.</li>
<li><b>Choix d'une liste de ref</b> : En indiquant l'URI de la liste de ref dans l'attribut <code>masterdatalist</code>.</li>
<li><b>Fournit par un service</b> : En indiquant le nom du service par l'attribut <code>serviceid</code>, les param�tres d'entr�e du service seront utiliser pour construire le formulaire de recherche, et le r�sultat sera affich� sous forme de liste. La mise en page de ces rendus est d�finie par le style des DT correspondant.</li>
</ul>
Il doit etre pos� dans un tag panel fournissant un DTO courant : <code>&lt;kasper:objectpanel&gt;</code> ou <code>&lt;kasper:listpanel&gt;</code><br/>
<i>Le composant Bean et le Tag correspondant ont les m�me param�tres.</i>
</div>
<div class="api">
<h2>Param�tres :</h2>
<ul> 
	<li><b><u>name</u> <span class="mandatory">*</span></b> : Nom du champ dans le DTO courant.</li>
	<li><s><u>style</u> : Pr�cise le style d'affichage � utiliser.</s></li>
	<li><b><u>serviceid</u></b>  : Nom du service � utiliser pour charger les donn�es, il ne doit y avoir qu'un seul param�tre en entr�e et un seul en sortie.</li>
	<li><b><u>masterdatalist</u></b>  : URI de la MasterDataList (Liste de r�f�rence) fournissant les valeurs s�lectionnables.</li>
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
	 Automatique (FK d'une MasterDataList) : <kasper:itemselect name="TYP_ID"/><br/>
	 Autre liste de ref : <kasper:itemselect name="TYP_ID" masterdatalist="DTC:MADA_TUTO_TYPE_2" /><br/>
	 Service : <kasper:itemselect name="TYP_ID" serviceid="TK_LIST_UTILISATEUR_BY_CRITERE" key="UTI_ID" display="PRENOM_NOM"/><br/>
 </kasper:objectpanel>
  <%if(controller.isModeEdit()) {%>
  		<kasper:action name="READ" text="Passer en mode lecture"/>
  	<%} else {%>
  		<kasper:action name="EDIT" text="Passer en mode �dition"/>  		
  	<%}%>
  </kasper:form>
 <br/>
 <h3>Code :</h3>
   <textarea readonly=true rows="6">
 &lt;kasper:objectpanel dtoid="DTO_TUTO_OBJECT"&gt;
	 Automatique (FK d'une MasterDataList) : &lt;kasper:itemselect name="TYP_ID"/&gt;
	 Autre liste de ref : &lt;kasper:itemselect name="TYP_ID" masterdatalist="DTC:MADA_TUTO_TYPE_2" /&gt;
	 Service : &lt;kasper:itemselect name="TYP_ID" serviceid="TK_LIST_UTILISATEUR_BY_CRITERE" key="UTI_ID" display="PRENOM_NOM"/&gt;
 &lt;/kasper:objectpanel&gt;
</textarea>
</div>
<div class="astuce"><a href="http://wiki/index.php/Kasper_4_:_Tutoriel_ItemSelect">Consulter les astuces</a></div>
</td></tr></table>

</kasper:page>
