package tests;

import org.junit.Test;

public class ReturnToPage extends TestBase {

  @Test
  public void testReturnToPage() {
    app.getNavigationHelper().gotoApplication();
    app.getGroupHelper().closeApplication();



  }
}
