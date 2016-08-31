<%@ taglib uri="/WEB-INF/lib/html_basic.tld" prefix="h" %>
<%@ taglib uri="/WEB-INF/lib/jsf_core.tld" prefix="f" %>


    <h:form id="skillform">
    
    <h:commandLink action="SkillsList">

       <h:outputText value="Skills List" />

    </h:commandLink>
  
  <h:panelGrid columns="4">
  
			<h:column>
				<f:facet name="Category">
					<h:outputText styleClass="body" value="Category" />
				</f:facet>
    			<h:outputText styleClass="bold" value="#{querySkills.currentSkill.category}" />
			</h:column>
  
  			<h:column>
				<f:facet name="Sub-Category">
					<h:outputText styleClass="body" value="Sub-Category" />
				</f:facet>
    			<h:outputText styleClass="bold" value="#{querySkills.currentSkill.subCategory}" />
			</h:column>

  			<h:column>
				<f:facet name="Skill">
					<h:outputText styleClass="body" value="Skill" />
				</f:facet>
    			<h:outputText styleClass="bold" value="#{querySkills.currentSkill.skill}" />
			</h:column>


  			<h:column>
				<f:facet name="Sub-Category">
					<h:outputText styleClass="body" value="Description" />
				</f:facet>
    			<h:outputText styleClass="small" value="#{querySkills.currentSkill.description}" />
			</h:column>
  
  </h:panelGrid>




    
    <h:panelGrid border="1" title="LEVELS:" columns="2">
    
      <h:dataTable value="#{querySkills.currentSkill.skillLevels}" var="x">
    
    
       			<h:column>

				<f:facet name="header">

					<h:outputText styleClass="body" value="Level #" />

				</f:facet>

    			<h:outputText styleClass="bold" value="#{x.level}"/>


			</h:column>
    
    
    			<h:column>

				<f:facet name="header">

					<h:outputText styleClass="body" value="Description" />

				</f:facet>

    			<h:outputText styleClass="small" value="#{x.description}"/>


			</h:column>
    
      </h:dataTable>
      
  
      
      </h:panelGrid>
       </h:form>
