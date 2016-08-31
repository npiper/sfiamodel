<%@ page contentType="text/html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/sql.tld" prefix="sql" %>

<sql:query var="rs" dataSource="jdbc/SfiaDb">
select ROLE.ROLENAME, ROLE_LEVEL.ROLE_LEVEL, ROLE_LEVEL.MIN_SALARY, ROLE_LEVEL.MAX_SALARY, ROLE_LEVEL.DESCRIPTION
FROM ROLE, ROLE_LEVEL
WHERE ROLE.ROLENAME = ROLE_LEVEL.ROLENAME AND ROLE.ACTIVE = 'true' ORDER BY ROLE_LEVEL.ROLENAME, ROLE_LEVEL.ROLE_LEVEL
</sql:query>

<TABLE border="1">
<TR><TD COLSPAN="3"><h3>Active Roles</h3></TD></TR>
<TR><TD></TD><TD>Role Name</TD><TD>Level</TD><TD>Min Salary</TD><TD>Max Salary</TD><TD>Description</TD></TR>
<c:forEach var="row" items="${rs.rows}">

<%
          //  java.sql.Clob cc = rs.getClob("description");
          //  java.lang.String desc = cc.getSubString(1L, 10000);
          
%>

  <TR><TD><img src="/SFIA/images/ico_user.gif"/></TD><TD>${row.ROLENAME}</TD><TD>${row.ROLE_LEVEL}</TD><TD>${row.MIN_SALARY}</TD><TD>${row.MAX_SALARY}</TD><TD></TD></TR>
</c:forEach>
</TABLE>