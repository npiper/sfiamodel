<%@ page contentType="text/html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>

<bean:define id="usbl" name="usbl" type="com.piperit.sfia.domain.UserSkillBaseline"/>

<h3>User Skill Baseline</h3>

<table border="1">
  <tr class="tablebg">
    <td><p class="bold">Name</p></td>
	<td><p class="bold">Creation Date</p></td>
	<td><p class="bold">User</p></td>
  </tr>
    <tr class="tablebg">
    <td><p class="bold"><bean:write name="usbl" property="baselineName"/></p></td>
	<td><p class="bold"><bean:write name="usbl" property="creationDate"/></p></td>
	<td><p class="bold"><bean:write name="usbl" property="user.userName"/></p></td>
  </tr>
</table>

<table border="1">
  <tr class="tablebg">
    <td><p class="bold">Skill Name</p></td>
	<td><p class="bold">Level Attained</p></td>
	<td>Description</td>
  </tr>
  <logic:iterate id="element" name="usbl" property="skillLevels">
     <tr>
       <td><p class="info"><bean:write name="element" property="skillID"/></p></td>
       <td><p class="info"><bean:write name="element" property="level"/></p></td>
       <td><p class="info"><bean:write name="element" property="description"/></p></td>
     </tr> 
  </logic:iterate>
  </table>

