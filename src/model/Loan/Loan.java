package model.Loan;

import model.Device.Device;
import model.Users.User;

public class Loan
{
  private User user;
  private Device device;
  private int loanID;

  public Loan(User user, Device device)
  {
    setUser(user);
    setDevice(device);
    loanID = -1;
  }

  public User getUser()
  {
    return user;
  }

  private void setUser(User user)
  {
    if (user == null)
    { throw new IllegalArgumentException("User cannot be null");}
    this.user = user;
  }

  public Device getDevice()
  {
    return device;
  }

  private void setDevice(Device device)
  {
    if (device == null)
    {
      throw new IllegalArgumentException("Device cannot be null");
    }
    this.device = device;
  }

  public void setLoanID(int loanID)
  {
    this.loanID = loanID;
  }

  public int getLoanID()
  {
    return loanID;
  }
}
