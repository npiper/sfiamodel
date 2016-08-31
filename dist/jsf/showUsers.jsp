	<%@ taglib uri="/WEB-INF/lib/html_basic.tld" prefix="h" %>
	<%@ taglib uri="/WEB-INF/lib/jsf_core.tld" prefix="f" %>
	<%@ taglib uri="/WEB-INF/lib/struts-tiles.tld" prefix="tiles" %>
	
	<f:view>
	
	
			<tiles:insert definition="loader" flush="false">
				<tiles:put name="content" value="userList.jsp"/>
			</tiles:insert>

		
	</f:view>