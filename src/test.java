import model.Model;
import model.ModelManager;
import model.Users.Student;
import model.Users.UserType;

import static model.Device.DeviceType.CHROMEBOOK;

public class test
{
  public static void main(String[] args)
  {
    Model model = new ModelManager();

    model.addDevice("Chromebook", "serial1", "2022-07");
    model.addDevice("Chromebook", "serial2", "2022-07");
    model.addDevice("BIB", "serial1", "2022-07");
    System.out.println(model.getDeviceList());

    model.addNewLoan("Christ", "Student", "2a", "serial1", "Chromebook", "2022-07");
   // model.addNewLoan("Christian", "Employee", "CHP", "serial2", "Chromebook", "2022-07");

    //model.getUserList().addUser(new Student("Christ", "2a", 1));
    System.out.println(model.getUserList().getUser("Christ", UserType.STUDENT).getUserID());

    System.out.println(CHROMEBOOK.toString());

  }
}
