package com.piperit.sfia.domain.datatypes;

/** Represents an SFIA level marker (currently 1-7)
 * 
 * @author Piper
 *
 */
public interface Level {

	public void setTitle(String title);
	public String getTitle();
	
	public Integer getNumber();
	public void setNumber(Integer i);
	
}
