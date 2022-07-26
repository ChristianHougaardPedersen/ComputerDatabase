package model.Loan;

import model.Device.Device;
import model.Users.User;

import java.util.ArrayList;

public class LoanList
{
  private ArrayList<Loan> loanList;

  public LoanList()
  {
    loanList = new ArrayList<>();
  }

  public void addLoan(Loan loan)
  {
    if (containsDevice(loan.getDevice()))
    {
    throw new IllegalArgumentException("Device already on loan!");
    }
    loanList.add(loan);
  }

  public Loan removeLoanById(int id)
  {
    Loan toRemove = getLoanByID(id);
    loanList.remove(toRemove);
    return toRemove;
  }

  public ArrayList<Loan> getAllLoans()
  {
    return loanList;
  }

  public Loan getLoanByID(int id)
  {
    for (Loan l : loanList)
    {
      if (l.getLoanID() == id)
      {
        return l;
      }
    }

    throw new IllegalArgumentException("Loan with ID: " + id + " not found!");
  }

  public boolean containsUser(User user)
  {
    for (Loan l : loanList)
    {
      if (l.getUser().getUserID() == user.getUserID())
      {
        return true;
      }
    }

    return false;
  }

  public boolean containsDevice(Device device)
  {
    for (Loan l : loanList)
    {
      if (l.getDevice().getDeviceID() == device.getDeviceID())
      {
        return true;
      }
    }

    return false;
  }
}
