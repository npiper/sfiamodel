package com.piperit.sfia.struts.controller;

import javax.servlet.ServletException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.struts.action.ActionServlet;

public class SFIAActionServlet extends ActionServlet {

	
	 public void init()

	  {

	     // Initialise the Logging service

	     try{

	      super.init();

	        String prefix =  getServletContext().getRealPath("/");

	        String file = getInitParameter("log4j-init-file");

	        // if the log4j-init-file is not set, then no point in trying

	       if(file != null) {

	 		      PropertyConfigurator.configure(prefix + file);
	         }

	         else {
	           System.err.println("Log4j configuration file improperly set..");
	         }

	     }

	     catch (ServletException se)

	     {
	        System.err.println("Log4j config Exception: " + se.getMessage() );
	     }

	  

	  }
	
}
