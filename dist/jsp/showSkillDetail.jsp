<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>

      <bean:define id="skill" name="skill" type="com.piperit.sfia.domain.Skill"/>
      
      <table width="80%" border="0" bgcolor="#ffffff" cellspacing="0" cellpadding="0">
              <tr  class="tableheaderbg"> 
                <th class="title" style="color:#ffffff">&nbsp;</th>
                <th colspan="2"><bean:write name="skill" property="skillID"/></th>
				<th class="title" style="color:#ffffff">&nbsp;</th>
              </tr>
              <tr  class="tableheaderbg"> 
                <td class="title" style="color:#ffffff">&nbsp;</td>
                <td colspan="2"><h3><bean:write name="skill" property="skill"/></h3></td>
				<td class="title" style="color:#ffffff">&nbsp;</td>
              </tr>
              <tr> 
                <td height="18" colspan="4"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr> 
                      <td width="15%">&nbsp;</td>
                      <td width="70%"><br/>
                        <p class="tableheadertext">
                         Description:
                        <br/>
                        </p>
                        <p class="small"><bean:write name="skill" property="description"/></p>
                      </td>
                      <td width="15%"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            
      <table width="80%" border="0" bgcolor="#ffffff" cellspacing="0" cellpadding="0">
        <tr>
          <th>Skill Level</th>
          <th>Description</th>
        </tr>
        <logic:iterate id="element" name="skill" property="skillLevels">
        <tr>
          <td><bean:write name="element" property="level"/></td>
          <td class="small"><bean:write name="element" property="description"/></td>
        </tr>
        </logic:iterate>
      </table>
      
      <%@ include file="usersWithSkill.jspf" %>

      

         