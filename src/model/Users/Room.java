package model.Users;

public class Room extends User
{

  public Room(String name)
  {
    super(UserType.ROOM, name, null);
  }

  public Room(String name, int userID)
  {
    super(UserType.ROOM,name, userID);
  }

  @Override public UserType getUserType()
  {
    return UserType.ROOM;
  }

  @Override public String toString()
  {
    return "LOKALE " + super.toString();
  }
}
