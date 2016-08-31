<html>

<%@ taglib uri="/WEB-INF/lib/html_basic.tld" prefix="h" %>
<%@ taglib uri="/WEB-INF/lib/jsf_core.tld" prefix="f" %>
<head>

<!-- bcprt Copyright (c) 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002 Unigraphics Solutions Inc.
		 All rights reserved. EDS and SDRC are registered trademarks and the EDS logo is a trademark of
		 Electronic Data Systems Corporation or its subsidiaries. ecprt -->
<!-- $Id: index2.jsp,v 1.2 2007/06/12 08:22:55 Piper Exp $ $Source: G:/REPOSITORY/REPOSITORY/SFIAModel/src/web/jsf/index2.jsp,v $ -->
<link rel="stylesheet" type="text/css" href="/SFIA/styles/styles01.css" media="screen" title="PIPERIT (screen)" />
  <title>Login</title>
</head>

  <body>
  <h1>TITLE</h1>
  <h3>sub-title</h1>
  <f:view>
     <h:form id="form">

    <h:panelGrid border="1" title="Errors:" columns="2">
		<hr width="60%" height="1" />
		<h:dataTable value="#{querySkills.activeSkillsList}" var="x">

			<h:column>

				<f:facet name="header">

					<h:outputText styleClass="body" value="Category" />

				</f:facet>

    			<h:outputText styleClass="red" value="#{x.category}"/>


			</h:column>
			
			<h:column>

				<f:facet name="header">

					<h:outputText styleClass="body" value="Sub-Category" />

				</f:facet>

				<h:outputText styleClass="body" value="#{x.subCategory}" />

			</h:column>
			

			<h:column>

				<f:facet name="header">

					<h:outputText styleClass="body" value="Skill Code" />

				</f:facet>

				<h:outputText styleClass="body" value="#{x.skillID}" />

			</h:column>


			<h:column>

				<f:facet name="header">

					<h:outputText styleClass="body" value="Skill Title" />

				</f:facet>

				  <h:commandLink action="#{querySkills.viewSkill}" immediate="true" >

                  <h:outputText value="#{x.skill}" title="#{x.description}" />

                 </h:commandLink>

			</h:column>
            


		</h:dataTable>
	</h:panelGrid>
    </h:form>
   </f:view>

	


  </body>

</html>