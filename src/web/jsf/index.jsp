<html>

<%@ taglib uri="/WEB-INF/lib/html_basic.tld" prefix="h" %>
<%@ taglib uri="/WEB-INF/lib/jsf_core.tld" prefix="f" %>

<head>

<!-- bcprt Copyright (c) 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002 Unigraphics Solutions Inc.
		 All rights reserved. EDS and SDRC are registered trademarks and the EDS logo is a trademark of
		 Electronic Data Systems Corporation or its subsidiaries. ecprt -->
<!-- $Id: index.jsp,v 1.1 2007/06/04 23:52:06 piper Exp $ $Source: G:/REPOSITORY/REPOSITORY/SFIAModel/src/web/jsf/index.jsp,v $ -->

  <title>Login</title>
</head>

  <body>
    
	
<%

com.piperit.sfia.view.handlers.QuerySkillsHandler qsh = new com.piperit.sfia.view.handlers.QuerySkillsHandler();

java.util.Collection ct = qsh.getActiveSkillsList();

if (ct == null) { out.println("Null Skills list"); }
else
{

  out.println( "got skills list" );   

  java.util.Iterator it = ct.iterator();

  while (it.hasNext())

    {
      com.piperit.sfia.domain.Skill ss = (com.piperit.sfia.domain.Skill)it.next();
  
      out.println( "Skill: " + ss.getSkillID() + " " + ss.getSkill() );
   
    }
}
%>

  </body>

</html>