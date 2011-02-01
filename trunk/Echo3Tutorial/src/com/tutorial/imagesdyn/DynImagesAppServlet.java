package com.tutorial.imagesdyn;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.webcontainer.WebContainerServlet;

/**
 * @author Demián Gutierrez
 * <br> Created on Jun 24, 2008
 */
public class DynImagesAppServlet extends WebContainerServlet {

  public ApplicationInstance newInstance() {
    return new DynImagesApp();
  }

  @Override
  public ApplicationInstance newApplicationInstance() {
    return new DynImagesApp();
  }
}
