  <%@ page contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<!-- BEGIN SIDE MENU -->
<h:form id="sideMenu">
     

     <table>
            <tr>
         <td>
             <h:outputText styleClass="header" value="Side Menu" />       
         </td>
       </tr>
     
       <tr>
         <td>
           <h:commandLink action="showRoles">
               <h:graphicImage value="/images/role.png" />
               <h:outputText styleClass="bold" value="Roles" />
            </h:commandLink>           
         </td>
       </tr>
       <tr>
         <td>
             <h:commandLink action="#{queryUserSkills.showUsers}">
               <h:graphicImage value="/images/user.png" />
               <h:outputText styleClass="bold" value="People" />
            </h:commandLink>
         </td>
       </tr>
       
       
     </table>
</h:form>     
<!-- END SIDE MENU -->