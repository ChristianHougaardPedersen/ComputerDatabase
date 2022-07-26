package model;

import model.Device.Device;
import model.Device.DeviceList;
import model.Device.DeviceType;
import model.Loan.LoanList;
import model.Users.User;
import model.Users.UserList;
import model.Users.UserType;

import java.util.ArrayList;

public interface Model
{
  void addDevice(String type, String serialNumber, String purchaseDate);
  void addNewLoan(String userName, String userType,
      String secondUserStringValue, String deviceSerialNo, String deviceType, String purchaseDate);
  void suspendLoan(int loanID);
  UserList getUserList();

  //todo - maybe delete this??
  ArrayList<User> getUsersByType(String userType);
  DeviceList getDeviceList();

  //todo - maybe delete this??
  ArrayList<Device> getDevicesByType(DeviceType deviceType);
  LoanList getLoanList();
  LoanList getLoansByUserType(UserType userType);
}
