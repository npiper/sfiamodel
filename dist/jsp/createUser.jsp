<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>

<html:form action="createUser" focus="username">


      <table class="center">

        <tr>

          <td align="right" class="body"><bean:message key="label.username"/><//td>

          <td><html:text property="username"/></td>

        </tr>

        <tr>

          <td class="body" align="right">&nbsp;</td>

          <td><html:submit styleClass="fieldlabel" value="Create User"/></td>

        </tr>


      </table>

</html:form>