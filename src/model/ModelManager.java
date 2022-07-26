package model;

import model.Device.Device;
import model.Device.DeviceList;
import model.Device.DeviceType;
import model.Loan.Loan;
import model.Loan.LoanList;
import model.Users.*;

import java.util.ArrayList;

public class ModelManager implements Model
{

  private UserList userList;
  private DeviceList deviceList;
  private LoanList loanList;

  public ModelManager()
  {
    //TODO - get lists from DB
    userList = new UserList();
    deviceList = new DeviceList();
    loanList = new LoanList();
  }

  @Override public void addDevice(String type, String serialNumber, String purchaseDate)
  {
    deviceList.addDevice(new Device(type, serialNumber, purchaseDate));
  }

  @Override public void addNewLoan(String userName, String userType,
      String secondUserStringValue, String deviceSerialNo, String deviceType,
      String purchaseDate)
  {
    User userToAdd = createDummyUser(userName, userType, secondUserStringValue);

    // todo set UserID from DB!

    //todo set deviceID from DB!

    Device dummyDevice = new Device(deviceType, deviceSerialNo, purchaseDate);
    if (!deviceList.contains(dummyDevice))
    {
      throw new IllegalArgumentException("Device not in list!");
    }

    loanList.addLoan(new Loan(userToAdd, dummyDevice));
  }

  @Override public void suspendLoan(int loanID)
  {
    Loan removedLoan = loanList.removeLoanById(loanID);

    if (!removedLoan.getUser().getUserType().equals(UserType.SET)
        || !removedLoan.getUser().getUserType().equals(UserType.ROOM))
    {
      userList.removeUser(removedLoan.getUser());
    }

  }

  @Override public UserList getUserList()
  {
    return userList;
  }

  @Override public ArrayList<User> getUsersByType(String userType)
  {
    return userList.getUsersByType(getUserTypeFromString(userType));
  }

  @Override public DeviceList getDeviceList()
  {
    return deviceList;
  }

  @Override public ArrayList<Device> getDevicesByType(DeviceType deviceType)
  {
    return deviceList.getDevicesByType(deviceType);
  }

  @Override public LoanList getLoanList()
  {
    return loanList;
  }

  private User createDummyUser(String userName, String userType,
      String secondUserStringValue)
  {
    User dummyUser;
    switch (getUserTypeFromString(userType))
    {
      case EMPLOYEE:
        dummyUser = new Employee(userName, secondUserStringValue);
        break;
      case STUDENT:
        dummyUser = new Student(userName, secondUserStringValue);
        break;
      case SET:
        dummyUser = new Set(userName);
        break;
      case ROOM:
        dummyUser = new Room(userName);
        break;
      default:
        throw new IllegalArgumentException("Something went wrong!");
    }

    try
    {
      userList.addUser(dummyUser);
      return dummyUser;
    }
    catch (IllegalArgumentException e)
    {
      System.out.println(e.getMessage());
      return userList.getUser(dummyUser.getName(), dummyUser.getUserType());
    }
  }

  private UserType getUserTypeFromString(String userType)
  {
    switch (userType.toLowerCase())
    {
      case "employee":
        return UserType.EMPLOYEE;
      case "student":
        return UserType.STUDENT;
      case "set":
        return UserType.SET;
      case "room":
        return UserType.ROOM;
      default:
        throw new IllegalArgumentException("UNKNOWN USER TYPE: " + userType);
    }
  }
}
