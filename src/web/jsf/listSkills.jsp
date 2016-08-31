<%@ taglib uri="/WEB-INF/lib/html_basic.tld" prefix="h" %>
<%@ taglib uri="/WEB-INF/lib/jsf_core.tld" prefix="f" %>
  <h1>TITLE</h1>
  <h3>sub-title</h3>

     <h:form id="form">

   		<hr width="60%" height="1" />
		<p class="bold">Current Skill:<h:outputText styleClass="body" value="#{querySkills.currentSkill.skill}"/></p>

    <h:panelGrid border="1" title="SKILLS:" columns="2">
      <h:dataTable value="#{querySkills.skillsModel}" var="x">

			<h:column>

				<f:facet name="header">

					<h:outputText styleClass="body" value="Category" />

				</f:facet>

    			<h:outputText styleClass="bold" value="#{x.category}"/>


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

