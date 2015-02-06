<%@ page session="false" import="java.util.*, javax.servlet.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%!
	private String printException(Throwable t) throws Exception {
        int i;
        StringBuffer sw = new StringBuffer();
        StackTraceElement[] stack = t.getStackTrace();
        sw.append(t.getClass().getName());
        sw.append(": <h3>").append(t.getMessage()).append("</h3>");
        for (i = 0; i < stack.length; i++) {
            if (stack[i].getClassName().startsWith("javax.servlet.")) {
                sw.append("...");
                break;
            }
            sw.append("\n\t").append(stack[i]);
        }
        String res = sw.toString();
		for (i = 0; (i = res.indexOf('&', i)) >= 0; i++) res = res.substring(0, i) + "&amp;" + res.substring(i + 1);
	   	for (i = 0; (i = res.indexOf('\"', i)) >= 0;) res = res.substring(0, i) + "&quot;" + res.substring(i + 1);
    	for (i = 0; (i = res.indexOf('<', i)) >= 0;) res = res.substring(0, i) + "&lt;" + res.substring(i + 1);
    	for (i = 0; (i = res.indexOf('>', i)) >= 0;) res = res.substring(0, i) + "&gt;" + res.substring(i + 1);
    	for (i = 0; (i = res.indexOf('\t', i)) >= 0;) res = res.substring(0, i) + "&nbsp;&nbsp;" + res.substring(i + 1);
    	for (i = 0; (i = res.indexOf('\n', i)) >= 0; i++) res = res.substring(0, i + 1) + "<br/>" + res.substring(i + 1);
		for (i = 0; (i = res.indexOf("&lt;h3&gt;", i)) >= 0;) res = res.substring(0, i) + "<h3>" + res.substring(i + "&lt;h3&gt;".length());
    	for (i = 0; (i = res.indexOf("&lt;/h3&gt;", i)) >= 0; i++) res = res.substring(0, i) + "</h3>" + res.substring(i + "&lt;/h3&gt;".length());
		return res;
    }
%>

<%
		Throwable e = (Throwable) request.getAttribute("javax.servlet.error.exception"), t;
		String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
		Integer errorCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		//Throwable e = (Throwable)pageContext.getAttribute("ex"), t;
        List list = new ArrayList();
        String message = null;
        boolean sessionException = false;
        boolean contextException = false;
        boolean securityException = false;
        boolean noObjectFoundException = false;
       for (; e != null;) {
            list.add(e);
            if (e instanceof kasper.ui.exception.SessionException) sessionException = true;
            if (e instanceof kasper.ui.exception.ExpiredContextException) contextException = true;
            if (e instanceof kasper.ui.exception.KSecurityException) securityException = true;
            t = e.getCause();
            if (t == null && (e instanceof ServletException)) t = ((ServletException) e).getRootCause();
            if (t == null && (e instanceof java.sql.SQLException)) t = ((java.sql.SQLException) e).getNextException();
            if (t == null && (e instanceof vertigo.kernel.exception.VRuntimeException)) t = ((vertigo.kernel.exception.VRuntimeException) e).getCause();
            e = t;
        }
        Collections.reverse(list);
        String baseUrl = request.getRequestURL().substring(0, request.getRequestURL().indexOf(request.getServletPath()))+"/";
       
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	
	<base href="<%=baseUrl%>"></base>	
    <link href="static/css/error.css" type="text/css" rel="stylesheet"/>
	<title>TeleDO - Erreur</title>
</head>
<body>
<div class="errorPage">
<script>
	var isVisible = false;
	handleClick = function () {
		if (document.getElementById) {
			if(!isVisible)
				document.getElementById("errordetail").style.display = "block";
			else
		    	document.getElementById("errordetail").style.display = "none";
		    isVisible = !isVisible;
		  }
		  else {
		    document.write("Unrecognized Browser Detected");
		  }
		}
</script>
	<div id="bandeau"></div>
	<div id="content">
	<% 
	   StringBuilder sbHome = new StringBuilder("");
	   sbHome.append("<a class=\"lien\" href=\"Accueil.do\">");
	   sbHome.append("l'�cran d'accueil");
	   sbHome.append("</a>");
	   
	   StringBuilder sbPrevious = new StringBuilder("");
	   sbPrevious.append("<a class=\"lien\" href=\"javascript:history.back();\">");
	   sbPrevious.append("l'�cran pr�c�dent");
	   sbPrevious.append("</a>");
	   
	   StringBuilder sbReconnect = new StringBuilder("");
	   sbReconnect.append("<a class=\"lien\" href=\"Login.do\">");
	   sbReconnect.append("reconnecter");
	   sbReconnect.append("</a>");
	   
	   StringBuilder sbReconnectAccent = new StringBuilder("");
	   sbReconnectAccent.append("<a class=\"lien\" href=\"Login.do\">");
	   sbReconnectAccent.append("reconnect�");
	   sbReconnectAccent.append("</a>");
  	%>
	
	<% if (sessionException) { %>
		<h1>Votre session a expir�</h1>
		<p>
		Vous n'avez pas utilis� l'application pendant un certain temps, pour des raisons de s�curit� l'application vous a donc d�connect�.<br/>
		Vous pourrez reprendre votre travail apr�s vous �tre <%=sbReconnectAccent.toString()%>.
		</p>
	<% } else if (contextException) { %>
		<h1>Le contexte de cet �cran n'est plus disponible</h1>
		<p>
		L'action que vous avez demand�e ne peut se poursuivre car le contexte de cet �cran n'est plus disponible.<br/>
		Vous pouvez continuer votre travail � partir de <%=sbPrevious.toString()%> ou <%=sbHome.toString()%>.<br/>
		Ce cas de figure peut se produire si vous avez cliqu� un trop grand nombre de fois de suite sur la fl�che "retour arri�re" de votre navigateur, ou si vous avez attendu trop longtemps avant de cliquer sur une action.
		</p>
	<% } else if (securityException) { %>
		<h1>Vous n'�tes pas habilit� � effectuer cette action</h1>
		<p>
		L'action que vous avez demand�e ne peut se poursuivre car vous n'avez pas les habilitations suffisantes.<br/>
		Vous pouvez continuer votre travail � partir de <%=sbPrevious.toString()%> ou <%=sbHome.toString()%>.<br/>
		Vous pouvez �galement vous <%=sbReconnect.toString()%>.
		</p>
	<% } else if (noObjectFoundException) { %>
		<h1>L'�l�ment demand� n'existe pas </h1>
		<p>
		L'�l�ment demand� n'existe pas, il vient probablement d'�tre supprim� par un autre utilisateur.<br/>
		Vous pouvez continuer votre travail � partir de <%=sbPrevious.toString()%> ou <%=sbHome.toString()%>.<br/>
		</p>
	<% } else { %>
		<h1>Erreur de l'application</h1>
<p>Cet �cran signifie qu'une erreur syst�me inattendue s'est produite pendant le traitement de l'action demand�e.<br/>
Un enregistrement a �t� cr�� dans le fichier de log de l'application.</p>
<p>De telles erreurs peuvent se produire en cas d'indisponibilit� temporaire d'un composant syst�me, dans ce cas,<br/>
vous pouvez revenir � <%=sbPrevious.toString()%> puis essayer � nouveau.</p>
<p>Il peut aussi s'agir d'une anomalie de l'application, dans ce cas, veuillez contacter le support technique et leur<br/>
communiquer l'heure � laquelle s'est produite l'erreur ainsi que les informations ci dessous.</p>
		
		<a href="#" onclick="handleClick();return false;" id="showerrorlink">Voir le message d'erreur</a>
		<div id="errordetail" style="display:none;">
		<h2><%="HTTP (" + errorCode + ") : " + errorMessage %></h2>
		<% for (int i = 0; i < list.size(); i++) { %>
			<% t = (Throwable)list.get(i); %>
			<h2><%= i > 0 ? "Cons�quence (" + i + ")" : "Cause racine" %></h2>
			<div class="code">
				<%= printException(t)%>
			</div>
		<% } %>
		</div>
	<% } %>
	</div>
</div>
</body>
</html>