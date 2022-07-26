package model.Users;

public class Employee extends User
{
  private String initials;

  public Employee(String name, String initials)
  {
    super(UserType.EMPLOYEE, name);
    setInitials(initials);
  }

  private void setInitials(String initials)
  {
    if (initials.isBlank())
    {
      throw new IllegalArgumentException("Initials should not be empty");
    }
  }

  public String getInitials()
  {
    return initials;
  }

  @Override public UserType getUserType()
  {
    return UserType.EMPLOYEE;
  }

  @Override public String toString()
  {
    return super.toString() + " (" + getInitials() + ")";
  }
}
