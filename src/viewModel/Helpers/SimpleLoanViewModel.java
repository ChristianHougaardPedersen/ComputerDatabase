package viewModel.Helpers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Device.Device;
import model.Loan.Loan;
import model.Users.User;

public class SimpleLoanViewModel
{
  private ObjectProperty<User> userProperty;
  private ObjectProperty<Device> deviceProperty;
  private StringProperty deviceTypeProperty;
  private StringProperty deviceSerialNoProperty;
  private StringProperty devicePurchaseDateProperty;
  private StringProperty userNameProperty;
  private StringProperty userSecProperty;

  public SimpleLoanViewModel(Loan loan)
  {
    userProperty = new SimpleObjectProperty<>(loan.getUser());
    deviceProperty = new SimpleObjectProperty<>(loan.getDevice());
    deviceTypeProperty = new SimpleStringProperty(loan.getDevice().getDeviceTypeString());
    deviceSerialNoProperty = new SimpleStringProperty(loan.getDevice().getSerialNumber());
    devicePurchaseDateProperty = new SimpleStringProperty(loan.getDevice().getPurchaseDate());
    userNameProperty = new SimpleStringProperty(loan.getUser().getName());
    userSecProperty = new SimpleStringProperty(loan.getUser().getSecString());
  }

  public ObjectProperty<User> userProperty()
  {
    return userProperty;
  }

  public ObjectProperty<Device> deviceProperty()
  {
    return deviceProperty;
  }

  public StringProperty deviceTypeProperty()
  {
    return deviceTypeProperty;
  }

  public StringProperty deviceSerialNoProperty()
  {
    return deviceSerialNoProperty;
  }

  public StringProperty devicePurchaseDateProperty()
  {
    return devicePurchaseDateProperty;
  }

  public StringProperty userNameProperty()
  {
    return userNameProperty;
  }

  public StringProperty userSecProperty()
  {
    return userSecProperty;
  }
}
