package com.piperit.sfia.spring.domain;

import com.piperit.sfia.domain.datatypes.Category;

public class SpringCategory implements Category {

	private String category;
	
	public SpringCategory(String cat)
	{
	   this.category = cat;	
	}
	
	public String getCategory() {
		// TODO Auto-generated method stub
		return category;
	}

	public void setCategory(String categoryName) {
		// TODO Auto-generated method stub
        this.category = categoryName;
	}

	public String toString()
	{
		return category;
	}
	
}
