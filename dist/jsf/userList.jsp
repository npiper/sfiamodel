<%@ taglib uri="/WEB-INF/lib/html_basic.tld" prefix="h" %>
<%@ taglib uri="/WEB-INF/lib/jsf_core.tld" prefix="f" %>

   
     <h:form id="userform">
  <h:panelGrid border="1" title="LEVELS:" columns="2">
    
      <h:dataTable value="#{queryUserSkills.userBaselines}" var="x">

        <h:column>

				<f:facet name="header">

					<h:outputText styleClass="body" value="Name" />

				</f:facet>

    			<h:outputText styleClass="small" value="#{x.user.username}"/>

			</h:column>


        <h:column>

				<f:facet name="header">

					<h:outputText styleClass="body" value="Latest Skill Baseline" />

				</f:facet>
				
             
             <h:commandLink action="#{queryUserSkills.showBaseline}">
               <h:outputText value="#{x.baseline.baselineName}" />
            </h:commandLink>

			</h:column>


		</h:dataTable>
      
  
      
      </h:panelGrid>
			</h:form>