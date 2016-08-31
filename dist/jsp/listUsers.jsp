<%@ page contentType="text/html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>


  <h3>Current Users</h3>

<html:errors/>

<bean:define id="users" name="users" type="java.util.Collection"/>
  <p class="caption"><%= users.size() %> matches found for this search.</p>


<table border="1">
  <tr class="tablebg">
    <td><p class="bold">Name</p></td>
	<td><p class="bold">Latest baseline</p></td>
	<td><p class="blod">Previous basleines</p></td>
  </tr>
  
  
  
  <logic:iterate id="element" name="users">
     <tr>
       <td><p class="body"><bean:write name="element" property="user.userName"/></p></td>
       <td><p class="body"><a href="showBaseline.do?user=<bean:write name="element" property="user.userName"/>&baseline=<bean:write name="element" property="baseline.baselineName"/>"/><bean:write name="element" property="baseline.baselineName"/></a></p></td>
     </tr> 
  </logic:iterate>
  </table>
