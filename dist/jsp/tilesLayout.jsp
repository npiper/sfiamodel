<%@ taglib uri="/WEB-INF/lib/html_basic.tld" prefix="h" %>
<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>

<html>

<head>

<link rel="stylesheet" type="text/css" href="/SFIA/styles/styles02.css" media="screen" title="PIPERIT (screen)" />
  <title>Login</title>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<tiles:importAttribute scope="request"/>

<table>

<tr><td colspan="2">

   
      <tiles:insert attribute="header" flush="false"/>
      

</td></tr>  

<tr><td colspan="2">

   
      <tiles:insert attribute="headerMenuBar" flush="false"/>
      

</td></tr>  

<tr><td width=20%" valign="top">

         <tiles:insert attribute="menu" flush="false"/>

</td>

<td width="80%">

        <tiles:insert attribute="content" flush="false"/>

</td></tr>
</table>

</body>

</html>