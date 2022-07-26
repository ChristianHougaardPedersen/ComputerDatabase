package model.Users;

public abstract class User
{
  private String name;
  private String secString;
  private UserType userType;
  private int userID;

  public User(UserType userType, String name, String secString)
  {
    setName(name);
    setUserType(userType);
    this.secString = secString;
    userID = -1;
  }

  public User(UserType userType, String name, int userID)
  {
    setName(name);
    setUserType(userType);
    setUserID(userID);
  }

  private void setUserType(UserType userType)
  {
    if (userType == null)
    {
      throw new NullPointerException("Usertype should not be null!");
    }

    this.userType = userType;

  }

  public void setName(String name)
  {
    if (name.isBlank())
    {
      throw new IllegalArgumentException("User name should not be null");
    }

    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public String getSecString()
  {
    return secString;
  }

  public String toString()
  {
    return getName();
  }

  public abstract UserType getUserType();

  public void setUserID(int userID)
  {
    this.userID = userID;
  }

  public int getUserID()
  {
    return userID;
  }

}
