<%@ taglib uri="/WEB-INF/lib/html_basic.tld" prefix="h" %>
<%@ taglib uri="/WEB-INF/lib/jsf_core.tld" prefix="f" %>

   
     <h:form id="userform">
    
    <H1> User Skill Baseline for <h:outputText value="#{queryUserSkills.userName}" /></H1>
     
     <h3>Baseline Name: <h:outputText value="#{queryUserSkills.baselineName}" /></H3>

     
  <h:panelGrid border="1" title="LEVELS:" columns="3">
    
      <h:dataTable value="#{queryUserSkills.skillLevels}" var="x">

        <h:column>

				<f:facet name="header">

					<h:outputText styleClass="body" value="Skill ID" />

				</f:facet>

    			<h:outputText styleClass="small" value="#{x.skillID}"/>

			</h:column>


        <h:column>

				<f:facet name="header">

					<h:outputText styleClass="body" value="Level Attained" />

				</f:facet>
				

               <h:outputText value="#{x.level}" />


			</h:column>

        <h:column>

				<f:facet name="header">

					<h:outputText styleClass="body" value="Description" />

				</f:facet>
				

               <h:outputText value="#{x.description}" />


			</h:column>


		</h:dataTable>
      
  
      
      </h:panelGrid>
</h:form>