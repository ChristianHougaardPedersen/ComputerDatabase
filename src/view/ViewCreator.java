package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.util.HashMap;
import java.util.Map;

public abstract class ViewCreator
{
  private Map<View, ViewController> controllers;

  public ViewCreator()
  {
    controllers = new HashMap<>();
  }

  public ViewController getViewController(View id)
  {
    ViewController controller = controllers.get(id);
    if (controller == null)
    {
      controller = loadFromFXML(id);
      controllers.put(id, controller);
    }

    else
    {
      controller.reset();
    }

    return controller;
  }

  private ViewController loadFromFXML(View id)
  {
    ViewController controller = null;
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(getLocation(id)));
      Region root = loader.load();
      controller = loader.getController();
      initViewController(controller, root);

      if (controller == null)
      {
        throw new Exception("Controller is null???");
      }
    }

    catch (Exception e)
    {
      e.printStackTrace();
    }

    return controller;
  }



  private String getLocation(View id)
  {
    switch (id)
    {
      case LOAN_OVERVIEW: return "LoanOverview.fxml";
      default: throw new IllegalArgumentException("ID NOT FOUND!");
    }
  }

  protected abstract void initViewController(ViewController controller, Region root);
}
