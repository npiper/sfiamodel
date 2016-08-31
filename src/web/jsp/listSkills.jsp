<%@ page contentType="text/html" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>


  <h3>Current Skills</h3>

<html:errors/>

<%

      org.springframework.core.io.ClassPathResource cpr = new org.springframework.core.io.ClassPathResource("context.xml");

	    org.springframework.beans.factory.xml.XmlBeanFactory beanFactory = new org.springframework.beans.factory.xml.XmlBeanFactory(cpr);
	
        com.piperit.sfia.domain.dao.SkillDAO sdao = (com.piperit.sfia.domain.dao.SkillDAO) beanFactory.getBean("skillDAO");
      
        java.util.Collection skillCollection = sdao.getAllActiveSkills();
            
	    request.setAttribute("skills", skillCollection);
%>


  <p class="caption"><%= skillCollection.size() %> matches found for this search.</p>
<table border="1">
  <tr class="tablebg">
    <th><p class="tableheadertext">Category</p></th>
	<th><p class="tableheadertext">Sub-Category</p></th>
    <th><p class="tableheadertext">Skill-Code</p></th>
	<th><p class="tableheadertext">Title</p></th>
  </tr>
  
<%
  
      java.util.HashMap hm = new java.util.HashMap();      
      hm.put(new String("Service provision"),new String("#993300"));
      hm.put(new String("Procurement & management support"),new String("#008080"));
      hm.put(new String("Ancillary skills"),new String("#008000")); 
      hm.put(new String("Business change"),new String("#FFFF00"));   
      hm.put(new String("Development"),new String("#993366"));      
      hm.put(new String("Development"),new String("#993366"));  
      hm.put(new String("Strategy & planning"),new String("#FF0000"));
                  
      java.util.Iterator it =  skillCollection.iterator();
      
    
      
      while (it.hasNext())
      {
        com.piperit.sfia.domain.Skill sk = (com.piperit.sfia.domain.Skill)it.next();
        
        String bgcolor = "#000000";
        
        if (hm.containsKey( sk.getCategory().toString() ) )
        {
           bgcolor = (String)hm.get( sk.getCategory().toString() );
        }    
    %>
     
     <tr>
       <td bgcolor="<%= bgcolor %>"><p class="body"><%= sk.getCategory().toString() %></p></td>
       <td><p class="body"><%= sk.getSubCategory().toString() %></p></td>
       <td><p class="body"><%= sk.getSkillID()%></p></td>
       <td><p class="body"><a href="showSkill.do?id=<%= sk.getSkillID()%>"/><%= sk.getSkill()%></a></p></td>
     </tr>      
    <%    
      
      }        // end while   
                    
  %>

  </table>

