package com.piperit.sfia.struts.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;



public class LoginForm extends ActionForm {

  private String username = null;

  private String password = null;



  public void setUsername(String un) {

    this.username = un;

  }



  public String getUsername( ) {

    return (this.username);

  }



  public String getPassword( ) {

    return (this.password);

  }



  public void setPassword(String password) {

    this.password = password;

  }



  /**

   * Validate the properties that have been sent from the HTTP request,

   * and return an ActionErrors object that encapsulates any

   * validation errors that have been found. If no errors are found, return

   * an empty ActionErrors object.

   */

  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

    ActionErrors errors = new ActionErrors( );



    if( getUsername() == null || getUsername().length( ) < 1 ) {

      errors.add("email", new ActionMessage("security.error.email.required"));

    }

    if( getPassword( ) == null || getPassword( ).length( ) < 1 ){

      errors.add("password", new ActionMessage("security.error.password.required"));

    }

    return errors;

  }



  public void reset(ActionMapping mapping, HttpServletRequest request) {

    /** Because this ActionForm should be request-scoped, do nothing here.

     *  The fields will be reset when a new instance is created. We could

     *  have just not overriden the parent reset( ) method, but we did so

     *  to provide an example of the reset( ) method signature.

     */

  }

}