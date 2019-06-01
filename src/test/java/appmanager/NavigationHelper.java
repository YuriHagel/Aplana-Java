package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationHelper extends HelperBase{


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoApplication() {
//    Wait<WebDriver> wait = new WebDriverWait(wd, 5, 1000);
    wd.get("https://www.rgs.ru/");
    click(By.linkText("Страхование"));
    click(By.linkText("ДМС"));
//    waitVisibility(By.linkText("Отправить заявку"));
    click(By.xpath("//*[contains(@class, 'btn btn-default text-uppercase')]"));
  }
}
