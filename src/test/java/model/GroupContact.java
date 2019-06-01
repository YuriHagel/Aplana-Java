package model;

public class GroupContact {
  private final String lastName;
  private final String firstName;
  private final String middleName;
  private final String email;
//  private String group;

  public GroupContact(String lastName, String LastName, String FirstName, String MiddleName, String email) {
    this.lastName = LastName;
    firstName = FirstName;
    middleName = MiddleName;
    this.email = email;
//    this.group = group;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getEmail() {
    return email;
  }

//  public String getGroup() {
//    return group;
//  }
}
