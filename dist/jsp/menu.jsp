<%@ page contentType="text/html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>

<!-- BEGIN SIDE MENU -->
<html:form action="signin">
     

     <table>
            <tr>
         <td>
             &nbsp;      
         </td>
       </tr>
     
       <tr>
         <td>
           <html:link action="listUsers">
               <html:img srcKey="image.user" altKey="image.user.alt" border="0"/>
               <bean:message key="label.users"/>
            </html:link>           
         </td>
       </tr>
       <tr>
         <td>
             <html:link action="listRoles">
               <html:img srcKey="image.role" altKey="image.role.alt" border="0"/>
               <bean:message key="label.roles"/>
            </html:link>
         </td>
       </tr>
       <tr>
         <td>
           <html:link action="listActiveSkills">
               <html:img srcKey="image.skill" altKey="image.skill.alt" border="0"/>
               <bean:message key="label.skills"/>
            </html:link>
         </td>
       </tr>       
       
     </table>
</html:form>     
<!-- END SIDE MENU -->