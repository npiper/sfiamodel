<%@ page contentType="text/html" %>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>



<tiles:insert page="tilesLayout.jsp">

  <tiles:put name="header" value="header.html" />

  <tiles:put name="menu" value="menu.html" />

  <tiles:put name="body" value="body1.html" />

</tiles:insert>