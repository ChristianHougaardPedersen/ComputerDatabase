package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ComputerDatabase
{

  private static ComputerDatabase instance;
  private String postgreSQLpassword;

  private ComputerDatabase(String postgreSQLpassword)
  {
    try
    {
      DriverManager.registerDriver(new org.postgresql.Driver());
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    this.postgreSQLpassword = postgreSQLpassword;
  }

  public static ComputerDatabase getInstance(String postgreSQLpassword)
  {
    if (instance == null)
    {
      instance = new ComputerDatabase(postgreSQLpassword);
    }
    return instance;
  }

  private Connection getConnection()
  {
    try
    {
      return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=computers", "postgres", postgreSQLpassword);
    }
    catch (SQLException e)
    {
      System.out.println("CONNECTION ERROR");
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }


}
