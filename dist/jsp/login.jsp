<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<html:html>


<head>

<title><bean:message key="title.login"/></title>

<link rel="stylesheet" type="text/css" href="/SFIA/styles/styles02.css" media="screen" title="PIPERIT (screen)" />
 
</head>

<body>

<table>
 <tr>
   <td><html:img srcKey="image.logo" altKey="image.logo.alt" border="0"/>
<h1 class="textright">SKILLETTO</h1></td>
 </tr>
</table>
    <h3>Please Login</h3>
    <h3><bean:message key="label.logininstruction"/></h3>

<html:form action="signin" focus="username">


      <table class="center">

        <tr>

          <td align="right" class="body"><bean:message key="label.username"/><//td>

          <td><html:text property="username"/></td>

        </tr>

        <tr>

          <td class="body" align="right"><bean:message key="label.password"/></td>

          <td><html:password property="password" size="10" maxlength="30"/></td>

        </tr>




        <tr>

          <td class="body" align="right">&nbsp;</td>

          <td><html:submit styleClass="fieldlabel" value="Login"/></td>

        </tr>


      </table>

</html:form>


</body>

</html:html>
