package model.Users;

public class Student extends User
{
  private String studentClass;

  public Student(String name, String studentClass)
  {
    super(UserType.STUDENT, name, studentClass);
  }

  public Student(String name, String studentClass, int studentID)
  {
    super(UserType.STUDENT, name, studentID);
    setStudentClass(studentClass);
  }

  private void setStudentClass(String studentClass)
  {
    if (studentClass.isBlank())
    {
      throw new IllegalArgumentException("Student class should not be null!");
    }

    this.studentClass = studentClass;
  }

  public String getStudentClass()
  {
    return studentClass;
  }

  @Override public UserType getUserType()
  {
    return UserType.STUDENT;
  }

  @Override public String toString()
  {
    return super.toString() + " " + getStudentClass();
  }
}
