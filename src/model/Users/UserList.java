package model.Users;

import java.util.ArrayList;

public class UserList
{
  private ArrayList<User> userList;

  public UserList()
  {
    userList = new ArrayList<>();
  }

  public void addUser(User user)
  {
    if (contains(user))
    {
      throw new IllegalArgumentException(
          "User: " + user.getName() + " already added!");
    }
    userList.add(user);
  }

  public void removeUser(User user)
  {
    if (!contains(user))
    {
      throw new IllegalArgumentException(
          "User: " + user.getName() + " not found");
    }
    userList.remove(user);
  }

  public boolean contains(User user)
  {
    for (User u : userList)
    {
      if (u.getName().equals(user.getName()))
      {
        if (u.getUserType().equals(user.getUserType()))
        {
          return true;
        }
      }
    }
    return false;
  }

  public ArrayList<User> getAllUsers()
  {
    return userList;
  }

  public ArrayList<User> getUsersByType(UserType userType)
  {
    ArrayList<User> usersByType = new ArrayList<>();

    for (User u : userList)
    {
      if (u.getUserType().equals(userType))
      {
        usersByType.add(u);
      }
    }

    return usersByType;
  }

  public User getUser(String userName, UserType userType)
  {
    for (User u : userList)
    {
      if (u.getName().equals(userName) && u.getUserType().equals(userType))
      {
        return u;
      }
    }

    return null;
  }
}
