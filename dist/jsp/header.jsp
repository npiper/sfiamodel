<%@ page contentType="text/html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>

<bean:define id="curruser" name="currentuser" property="userName" type="java.lang.String"/>

<!-- BEGIN HEADER -->
<table border="0" cellpadding="1" cellspacing="10" width="100%">
<tbody>
  <tr>
    <td valign="top" width="10%">
      <img src="/SFIA/images/SFIALogo.jpg" alt="SKILLETTO Skills management" title="Skilletto Skills management">
    </td>
    
    <td valign="top" class="header-text" align="right" background="../images/topSpacer.gif" width="100%">
        <h1>SKILLETTO</h1>
    </td>
    
    <td valign="top" width="70%">
      <img src="/SFIA/images/clear.gif" alt="EDS" title="EDS" height="38" width="72">
      <h4><%= curruser %></h4>
    </td>

    <td valign="top" width="10%">
     <html:form action="signin">
        <html:button property="logout" value="Logout" />
      </html:form>
    </td>
    
    <td valign="top" width="10%">
       
    </td>
    
  </tr>
</tbody>
</table>
<!-- END HEADER -->