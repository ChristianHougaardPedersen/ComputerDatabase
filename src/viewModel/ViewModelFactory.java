package viewModel;

import model.Model;

public class ViewModelFactory
{
  private LoanOverviewViewModel loanOverviewViewModel;

  public ViewModelFactory(Model model)
  {
    this.loanOverviewViewModel = new LoanOverviewViewModel(model);
  }

  public LoanOverviewViewModel getLoanOverviewViewModel()
  {
    return loanOverviewViewModel;
  }
}
