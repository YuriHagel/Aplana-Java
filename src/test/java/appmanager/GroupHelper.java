package appmanager;

import model.GroupContact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void submit() {
    click(By.id("button-m"));
  }

  public void sendApp() {
    click(By.xpath("//*[contains(@class, 'btn btn-default text-uppercase')]"));
  }

  public void comment(String text) {
    type(By.name("Comment"), text);
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Комментарии'])[1]/following::input[1]"));
  }

  public void contactDate() {
    click(locator("ContactDate"));
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Вс'])[1]/following::td[33]"));
  }

  public void choiceRegion(Boolean input) {


    click(locator("Region"));
    if (input) {
      new Select(wd.findElement(locator("Region"))).selectByVisibleText("Москва");
      click(locator("Region"));
    } else {
      Assert.assertFalse(isElementPresent(By.name("Region")));
    }


  }

  public void fillFormContact(GroupContact groupContact) {
    type(By.name("LastName"), groupContact.getLastName());
    type(By.name("FirstName"), groupContact.getFirstName());
    type(By.name("MiddleName"), groupContact.getMiddleName());
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[4]/following::input[1]"));
    type(By.name("Email"), groupContact.getEmail());
  }

  private By locator(String text) {
    return By.name(text);
  }

  public void closeApplication() {
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Активировать карту ДМС'])[1]/following::button[1]"));
  }
}
