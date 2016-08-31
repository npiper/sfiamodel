package com.piperit.sfia.spring.domain;

import com.piperit.sfia.domain.datatypes.Category;
import com.piperit.sfia.domain.datatypes.SubCategory;

public class SpringSubCategory implements SubCategory {

	private Category cc;
	private String subCategory;
	
	public SpringSubCategory( Category c, String subCat)
	{
		this.cc = c;
		this.subCategory = subCat;
	}
	
	public Category getCategory() {
		// TODO Auto-generated method stub
		return cc;
	}

	public String getSubCategory() {
		// TODO Auto-generated method stub
		return subCategory;
	}

	public void setCategory(Category c) {
		// TODO Auto-generated method stub
        this.cc = c;
	}

	public void setSubCategory(String subcat) {
		// TODO Auto-generated method stub
        this.subCategory = subcat;
	}
	
	public String toString()
	{
		return this.subCategory;
	}

}
