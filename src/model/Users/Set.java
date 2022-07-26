package model.Users;

public class Set extends User
{

  public Set(String name)
  {
    super(UserType.SET, name, null);
  }

  public Set(String name, int userID)
  {
    super(UserType.SET, name, userID);
  }

  @Override public UserType getUserType()
  {
    return UserType.SET;
  }

  @Override public String toString()
  {
    return "SÆT " + super.toString();
  }
}
