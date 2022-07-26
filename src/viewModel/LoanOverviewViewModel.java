package viewModel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Loan.LoanList;
import model.Model;
import model.Users.UserType;
import viewModel.Helpers.SimpleLoanViewModel;

public class LoanOverviewViewModel
{
  private Model model;
  private ObservableList<SimpleLoanViewModel> loans;

  private ObjectProperty<SimpleLoanViewModel> selectedLoan;


  public LoanOverviewViewModel(Model model)
  {
    this.model = model;
    this.loans = FXCollections.observableArrayList();
    this.selectedLoan = new SimpleObjectProperty<>();

    reset();
  }

  public ObservableList<SimpleLoanViewModel> getLoans()
  {
    return loans;
  }

  public SimpleLoanViewModel getSelectedLoan()
  {
    return selectedLoan.get();
  }

  public void setSelected(SimpleLoanViewModel selectedLoan)
  {
    try
    {
      this.selectedLoan.set(selectedLoan);

      System.out.println("SELECTION CHANGED");
    }
    catch (NullPointerException ignored)
    {
      // do nothing
    }
  }

  public void reset()
  {
    setSelected(null);
    updateLoans();
  }

  public void updateLoans()
  {
    loans.clear();
    LoanList allLoans = model.getLoanList();
    for (int i = 0; i < allLoans.getAllLoans().size(); i++)
    {
      loans.add(new SimpleLoanViewModel(allLoans.get(i)));
    }

    System.out.println("LOANS UPDATED!");
  }

  public void filterLoansByUserType(UserType userType)
  {
    loans.clear();
    LoanList filteredLoanListByUserType = model.getLoansByUserType(userType);
    for (int i = 0; i < filteredLoanListByUserType.getAllLoans().size(); i++)
    {
      loans.add(new SimpleLoanViewModel(filteredLoanListByUserType.get(i)));
    }
  }
}
