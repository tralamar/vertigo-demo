<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div id="utilisateur">
	<div><s:property value="nomPrenom"/></div>			
	<hr/>
	<div><s:property value="profilFonction"/> - <s:property value="profilLieuExercice"/></div>
	<hr/>
	<div><s:a action="ListeProfils" cssClass="change-profil">Changer de profil</s:a><s:a action="logoutBienvenue" cssClass="logout">Se déconnecter</s:a></div>
</div>