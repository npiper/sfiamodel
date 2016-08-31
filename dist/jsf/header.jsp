<%@ taglib uri="/WEB-INF/lib/html_basic.tld" prefix="h" %>
<%@ taglib uri="/WEB-INF/lib/jsf_core.tld" prefix="f" %>

  <div id="banner">
<!-- BEGIN HEADER -->
<table border="0" cellpadding="1" cellspacing="10" width="100%">
<tbody>
  <tr>
    <td width="10%">
      <img src="/SFIA/images/SFIALogo.jpg" alt="SKILLETTO Skills management" title="Skilletto Skills management">
    </td>
    
    <td class="header-text" align="right" background="../images/topSpacer.gif" width="100%">
        <h1>SKILLETTO</h1>
    </td>
    
    <td width="80%">
      <img src="/SFIA/images/clear.gif" alt="EDS" title="EDS" height="38" width="72">
      
    </td>

    <td width="10%">
     <h:form id="logoutForm">
        <h:commandButton value="Logout" action="logout" />
      </h:form>
    </td>
    
  </tr>
</tbody>
</table>
</div> <!-- end banner -->
<!-- END HEADER -->
