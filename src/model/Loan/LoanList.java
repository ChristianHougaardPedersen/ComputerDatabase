package model.Loan;

import model.Device.Device;
import model.Users.User;
import model.Users.UserType;

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

    if (loan.getUser().getUserType() == UserType.EMPLOYEE || loan.getUser().getUserType() == UserType.STUDENT)
    {
      if (containsUser(loan.getUser()))
      {
        throw new IllegalArgumentException(loan.getUser() + " already has a current loan");
      }
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
    // todo - uncomment
    /*
    for (Loan l : loanList)
    {
      if (l.getUser().getUserID() == user.getUserID())
      {
        return true;
      }
    }


     */
    return false;
  }

  public boolean containsDevice(Device device)
  {
    // todo uncomment!
    /*
    for (Loan l : loanList)
    {
      if (l.getDevice().getDeviceID() == device.getDeviceID())
      {
        return true;
      }
    }

     */

    return false;
  }

  public Loan get(int index)
  {
    return loanList.get(index);
  }

  public LoanList getLoansByUserType(UserType userType)
  {
    LoanList filteredLoansList = new LoanList();
    for (Loan l : loanList)
    {
     if (l.getUser().getUserType().equals(userType))
     {
       filteredLoansList.addLoan(l);
     }
    }

    return filteredLoansList;
  }
}
