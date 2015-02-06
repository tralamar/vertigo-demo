<%@page import="kasper.ui.controller.*,io.vertigo.demo.ui.controller.*,io.vertigo.demo.ui.controller.tutorial2.*,  java.util.*"%>
<%@taglib uri="/WEB-INF/kasper_demo.tld" prefix="demo" %>
<%@taglib uri="/META-INF/kasper.tld" prefix="kasper" %>
<kasper:page style="tuto" controllerclass="io.vertigo.demo.ui.controller.tutorial.TutoUploadController" title="Tutoriel - Upload">
<table width="100%">
<tr><%@include file="menu.inc" %>
<td>
<div>
<h1>Upload</h1>
<div class="description"><h2>Description</h2>
Ce composant repr�sente un Fichier, quelque soit son type.<br/>
Il doit etre pos� dans un tag panel fournissant un DTO courant : <code>&lt;kasper:objectpanel&gt;</code> ou <code>&lt;kasper:listpanel&gt;</code><br/>
<i>Le composant Bean et le Tag correspondant ont les m�me param�tres.</i><br/>
N�cessite les librairies <code>commons-fileupload-1.2.1.jar</code> et <code>commons-io-1.4.jar</code><br/>
Au download :
<ul><li>Les fichiers de moins de 10 Kio restent en m�moire, les autres sont copi�s sur disque.</li></ul>
<br/>
A l'upload :
<ul><li>Les fichiers de moins de 50 Kio restent en m�moire, les autres sont copi�s sur disque.</li>
<li>La taille maximum est de 30 Mio.</li></ul>
<br/>
</div>
<div class="api">
<h2>Param�tres :</h2>
<ul> 
	<li><b><u>name</u> <span class="mandatory">*</span></b> : Nom du champs portant l'identifiant du fichier dans le DTO courant.</li>
	<li><b>style</b> : Surcharge le style d'affichage � utiliser. Par d�faut on prend celui associ� au domain. La liste des styles possible est d�finie au niveau du projet.</li>
	<li><b>readonly</b> : Passe le champs en mode editable ou non �ditable. Par d�faut cette propri�t� est h�rit�e des composants parents.</li>
	<li><b>css</b> : Style css du HTML du field. Le TagRenderer peut l'utiliser pour adapter le rendu.</li>
	<li><b>onChange</b> : Code javascript � lancer lors de la modification de la valeur de ce champs (uniquement si modifiable).</li>	
	<li><b>roles</b> : Liste des roles permettant l'utilisation de ce lien. Le lien est invisible pour les utilisateurs qui n'ont pas les droits suffisants.</li>
 </ul>
</div>
<div class="exemple">
<h2>Exemple :</h2>
<kasper:form other="enctype='multipart/form-data'">
   <kasper:error/>
   <kasper:objectpanel dtoid="DTO_TUTO_OBJECT" readonly="<%=!controller.isModeEdit()%>">
	 Label : 
	 <% if(controller.isModeEdit() && controller.isFileReady()) {%>
	  	<kasper:action name="DOWNLOAD" text="<%=controller.getFormattedValue(item,"LIBELLE")%>" style="link"/>
	  <%} else {%>
	 	<i>&lt;&lt; Commencer par charger un fichier &gt;&gt;</i>
	 <%}%>
	 <br/>
	 Fichier : 
	 <% if(controller.isModeEdit()) {%>
	 	<input type="file" name="<%=controller.FILE_INPUT_NAME%>"/>
	 <%} else {%>
	 	<kasper:action name="DOWNLOAD" text="<%=controller.getFormattedValue(item,"LIBELLE")%>" style="link"/>
	 <%}%>
	 <br/><br/>
  	</kasper:objectpanel>
  	<%if(controller.isModeEdit()) {%>
  		<kasper:action name="UPLOAD" text="Envoyer"/>
  		<kasper:action name="READ" text="Passer en mode lecture"/>
  	<%} else {%>  		
  		<kasper:action name="EDIT" text="Passer en mode �dition"/>  		
  	<%}%>
  </kasper:form>
 <br/>
 <h3>Code :</h3>
   <textarea readonly="true" rows="10">
&lt;kasper:form other="enctype='multipart/form-data'"&gt;
   &lt;kasper:error/&gt;
   &lt;kasper:objectpanel dtoid="DTO_TUTO_OBJECT" readonly="&lt;%=!controller.isModeEdit()%&gt;"&gt;
	 Label : &lt;kasper:action name="DOWNLOAD" text="&lt;%=controller.getFormattedValue(item,"LIBELLE")%&gt;" style="link"/&gt;
	 Fichier : &lt;input type="file" name="&lt;%=controller.FILE_INPUT_NAME%&gt;"/&gt;
	&lt;/kasper:objectpanel&gt;
  	&lt;kasper:action name="UPLOAD" text="Envoyer"/&gt;
  	&lt;kasper:action name="READ" text="Passer en mode lecture"/&gt;
  &lt;/kasper:form&gt;
</textarea>
</div>
<div class="astuce"><a href="http://wiki/index.php/Kasper_5_:_Tutoriel_Upload">Consulter les astuces</a></div>
</div>
</td></tr></table>

</kasper:page>
