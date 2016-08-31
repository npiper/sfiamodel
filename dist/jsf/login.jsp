<%@ page contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<html>

  <head>

    <title>Login</title>

<link rel="stylesheet" type="text/css" href="/SFIA/styles/styles02.css" media="screen" title="PIPERIT (screen)" />
 

  </head>

  <body bgcolor="white">
<table>
 <tr>
   <td><img src="/SFIA/images/SFIALogo.jpg" align="left"/><h1 class="textright">SKILLETTO</h1></td>
 </tr>
</table>
    <h3>Please Login</h3>
    <h3>The page you requested is only available to registered users. Please enter your username and password and click Login.</h3>

      <h:messages errorStyle="color: red" />

 <h:form>

<h:inputHidden value="#{loginHandler.origURL}" />

      <table class="center">

        <tr>

          <td align="right" class="body">Username:</td>

          <td><h:inputText value="#{loginHandler.username}" 
          size="10" /></td>

        </tr>

        <tr>

          <td class="body" align="right">Password:</td>

          <td><h:inputSecret value="#{loginHandler.password}" 
          size="10" redisplay="true" /></td>

        </tr>

      </table>

      <h:commandButton  value="Enter" 
          action="#{loginHandler.authenticate}" />


      </h:form>
  </body>

</html>
</f:view>

