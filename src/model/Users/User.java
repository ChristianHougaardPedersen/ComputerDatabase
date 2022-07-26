package model.Users;

public abstract class User
{
  private String name;
  private UserType userType;
  private int userID;

  public User(UserType userType, String name)
  {
    setName(name);
    setUserType(userType);
    userID = -1;
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
