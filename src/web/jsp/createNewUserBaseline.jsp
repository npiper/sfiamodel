<%@ page contentType="text/html" %>

<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/sql.tld" prefix="sql" %>


<html:errors/>

<SCRIPT LANGUAGE="JavaScript">

<%

	 
	 java.util.Collection cats = new java.util.ArrayList();

	 java.sql.Connection c = null;
	 java.sql.Statement s = null;
	 java.sql.ResultSet rs = null;

	 /* Necessary to ensure that the oracle JDBC driver is loaded. */
	 try
	 {
	    Class.forName( "oracle.jdbc.driver.OracleDriver" );
	 }
	 catch( Throwable t )
	 {
	   ;
     }


	 try
	 {

        // TODO: Replace with Spring DB lookup	 
	    /* Try looking up the given invoice. */
	    c = java.sql.DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:ORCL", "scarab", "scarab" );
	    s = c.createStatement();

	    rs = s.executeQuery
			( "select skills.sequence,skills.category as category,skills.subcategory,skills.skill,skills.skill_id,skills.description as skillDesc," + 
"skill_level.LEVEL_NUMBER, skill_level.DESCRIPTION as levelDesc" +
" from skills, skill_level " 
+ "where skills.skill_id = skill_level.skill_id order by category,skills.skill,skill_level.LEVEL_NUMBER");

        // build up a javascript array
        
        // CATEGORY--> SKILL (SKILLL_ID,SKILL,SkillDesc)-->Level(Level_Number, levelDesc)
        
         out.println("var skillLevelsDB = new Object()");
     
         String currentCategory = null;
         int categoryCount = 0;
                    
         int skillArray = 0;
         int levelArray = 0;           
                    
         while (rs.next())
         {
            // presumes current category is sorted
            

                     
            if ( currentCategory == null || !(currentCategory.equals( rs.getString("category") ))  ) 
            {   
                //increment the category array           
                categoryCount++;
                
                // reset the skill, level arrays
                skillArray =  0;
                levelArray = 0;
                
                if (currentCategory != null)
                {
                   
                   cats.add( currentCategory );
                   out.print("];");
                   out.println();
                }

                currentCategory = rs.getString("category");  
                out.print("skillLevelsDB[\"" + currentCategory + "\"] = [");
  
                
            } 
            
                java.sql.Clob cc = rs.getClob("levelDesc");
                String desc = cc.getSubString(1L, 10000);

               
                if (skillArray != 0) { out.print(",\n"); }
                skillArray++;
                out.print( "{value:\"" + rs.getString("skill_id") + rs.getString("level_number") + "\", ");
                out.print("text:\"" +  rs.getString("skill") + " " + rs.getString("level_number") + "\", ");
                out.print("desc:\"" + desc + "\"" );
                out.print("}");

         
         }
     
     // end of loop
                        out.print("];");
                   out.println();
     
     }
	 catch( Exception e )
	 {
          out.println( "<h3 class='red'>Database error</h3>");
	 }




%>
</SCRIPT>

<SCRIPT language="Javascript">

function setCities(chooser) {
    var cityChooser = chooser.form.elements["city"];
    // empty previous settings
    cityChooser.options.length = 0;
    // get chosen value to act as index to regiondb hash table
    var choice = chooser.options[chooser.selectedIndex].value;
    var db = skillLevelsDB[choice];
    // insert default first item
    cityChooser.options[0] = new Option("Choose a Skill:", "", true, false);
    if (choice != "") {
        // loop through array of the hash table entry, and populate options
        for (var i = 0; i < db.length; i++) {
            cityChooser.options[i + 1] = new Option(db[i].text, db[i].value);
        }
    }
}

function setSkills(chooser)
{
   var skillText = chooser.form.elements["levelDesc"];

   // get the skill choice
   var choice = chooser.options[chooser.selectedIndex].value;
   
   
     // get the category
     var category = chooser.form.elements["continent"].value;

     var db = skillLevelsDB[category];
    
    if (choice != "") {
        // loop through array of the hash table entry, and populate options
        for (var i = 0; i < db.length; i++) {
        
            if ( db[i].value == choice )
            {
               var description = db[i].desc;
               
               var rowsRequired = Math.round( description.length / 60 ) + 2;
               
               skillText.rows = rowsRequired;
            
               skillText.value = db[i].desc;
            }   
        }
    }

}

function updateTable(chooser)
{

  var skillComboBox = chooser.form.elements["chosenSkills"];

  var skillValue = chooser.form.elements["city"].value;

  var skillText = chooser.form.elements["city"].options[ chooser.form.elements["city"].selectedIndex  ].text;

  var currentSize = skillComboBox.options.length;

  skillComboBox.options[currentSize] = new Option(  skillText, skillValue );

  skillComboBox.size = currentSize+1;

}

function removeSkill(skillChooser)
{
   // if there is no current skill, disable the box
   if ( skillChooser.form.elements["chosenSkills"].size == 0  ) 
   { 
     //skillChooser.form.elements["removeSkillLevelButton"]. 
     return;  
   }

    var Current = skillChooser.form.elements["chosenSkills"].selectedIndex;
    skillChooser.form.elements["chosenSkills"].options[Current] = null;
   
   
}

</SCRIPT>
<h2>New Skills Baseline:</h2>
<form name="dd" action="">
<table>

<tr>
  <td colspan="2">
    <h3>Baseline Name: <input type="text" style="background-color: #E7ECFD;" name="baselineName" /></h3>
  </td>
</tr>

<tr>
<td>
<h3>Category:</h3> <select name="continent" onchange="setCities(this)">
    <option value="" selected>Choose a Category:</option>
<%
    java.util.Iterator it = cats.iterator();
    
    while (it.hasNext())
    {
       String ss = (String)it.next();
       out.println( "<option value=\"" + ss + "\">" + ss + "</option>" );
    }

%>
</select>&nbsp;
<br/>
<br/>
<br/>
</td>
<td>
  <h6>Chosen Skill Levels:</h6>
  <!-- Inner table -- display selected items -->
  <select name="chosenSkills" size="1">
  </select>
  <br/>
  <input type="button" onClick="removeSkill(this)" name="removeSkillLevelButton" value="Remove.." />
  <br/>
  <input type="submit" name="nextStep" value="Next >>" />
</td>
</tr>
<tr>
<td colspan="2">
<h4>Skill and Level:</h4>
<select name="city" onChange="setSkills(this)">
    <option value="" selected>Choose a Skill:</option>
</select>
<input type="button" name="addButton" value="Add.." onClick="updateTable(this)"/>
</td>
</tr>
<tr>
<td colspan="2">
<h4>Description:</h4>
<textarea cols="80" rows="4" name="levelDesc"></textarea>
</td>
</tr>

</table>
</form>
