package tests;

import model.Generate;
import model.GroupContact;
import org.junit.Test;

public class InsuranceTest extends TestBase {


  @Test
  public void testBase() {
    app.getNavigationHelper().gotoApplication();
    app.getGroupHelper().fillFormContact(new GroupContact(Generate.generateLastName(), Generate.generateFirstName(), Generate.generateMiddleName(), "4rrr", "erferg"));

    app.getGroupHelper().choiceRegion(true);
    app.getGroupHelper().contactDate();
    app.getGroupHelper().comment(null);
    app.getGroupHelper().submit();
  }

}
