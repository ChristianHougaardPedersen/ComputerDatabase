package model.Users;

public class Set extends User
{

  public Set(String name)
  {
    super(UserType.SET, name);
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
