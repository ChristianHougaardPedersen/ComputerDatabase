import model.Model;
import model.ModelManager;

public class test
{
  public static void main(String[] args)
  {
    Model model = new ModelManager();

    model.addDevice("Chromebook", "serial1", "2022-07");
    model.addDevice("Chromebook", "serial2", "2022-07");
    model.addDevice("BIB", "serial1", "2022-07");
    System.out.println(model.getDeviceList());

    model.addNewLoan("Christian", "Employee", "CHP", "serial1", "Chromebook", "2022-07");
    model.addNewLoan("Christian", "Employee", "CHP", "serial2", "Chromebook", "2022-07");



  }
}
