package view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Users.UserType;
import viewModel.Helpers.SimpleLoanViewModel;
import viewModel.LoanOverviewViewModel;

public class LoanOverViewController extends ViewController
{

  @FXML private TableView<SimpleLoanViewModel> deviceTable;
  @FXML private TableColumn<SimpleLoanViewModel, String> deviceTypeColumn;
  @FXML private TableColumn<SimpleLoanViewModel, String> deviceSerialNumberColumn;
  @FXML private TableColumn<SimpleLoanViewModel, String> userNameColumn;
  @FXML private TableColumn<SimpleLoanViewModel, String> userExtraInfoColumn;
  @FXML private ComboBox<String> sortByUserChoiceBox;
  @FXML private ComboBox<String> sortByDeviceChoiceBox;
  @FXML private Button removeLoanButton;
  @FXML private Button showLoanDetailsButton;
  @FXML private Button newLoanButton;
  @FXML private Button showAllUsersButton;
  @FXML private Button showAllDevicesButton;
  @FXML private Button closeButton;

  private LoanOverviewViewModel viewModel;

  @Override protected void init()
  {
    viewModel = getViewModelFactory().getLoanOverviewViewModel();

    deviceTypeColumn.setCellValueFactory(cellData -> cellData.getValue().deviceTypeProperty());
    deviceSerialNumberColumn.setCellValueFactory(cellData -> cellData.getValue().deviceSerialNoProperty());
    userNameColumn.setCellValueFactory(cellData -> cellData.getValue().userNameProperty());
    userExtraInfoColumn.setCellValueFactory(cellData -> cellData.getValue().userSecProperty());

    deviceTable.setItems(viewModel.getLoans());
    deviceTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
      viewModel.setSelected(newVal);
    });

    sortByUserChoiceBox.getItems().addAll("Alle", "Elever", "Ansatte", "Lokale", "Sæt");
    sortByUserChoiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
      filterByUserType(newVal);
    });

    sortByDeviceChoiceBox.getItems().addAll("Alle", "Chromebook", "BIB", "Type 3", "Type 4");


    reset();
  }

  private void filterByUserType(String selection)
  {
    switch (selection)
    {
      case "Alle": viewModel.updateLoans(); break;
      case "Elever": viewModel.filterLoansByUserType(UserType.STUDENT); break;
      case "Ansatte": viewModel.filterLoansByUserType(UserType.EMPLOYEE); break;
      case "Lokale": viewModel.filterLoansByUserType(UserType.ROOM); break;
      default: viewModel.filterLoansByUserType(UserType.SET); break;
    }
  }

  @Override public void reset()
  {
    sortByDeviceChoiceBox.getSelectionModel().selectFirst();
    sortByUserChoiceBox.getSelectionModel().selectFirst();
    viewModel.reset();
  }

  @FXML private void removeLoanButtonPressed(ActionEvent actionEvent)
  {
  }

  @FXML private void showLoanDetailsButtonPressed(ActionEvent actionEvent)
  {
  }

  @FXML private void newLoanButtonClicked(ActionEvent actionEvent)
  {
  }

  @FXML private void showAllUsersButtonClicked(ActionEvent actionEvent)
  {
  }

  @FXML private void showAllDevicesButtonClicked(ActionEvent actionEvent)
  {
  }

  @FXML private void closeButtonClicked()
  {
    Platform.exit();
  }


}
