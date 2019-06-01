package appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
  protected WebDriver wd;
  private boolean acceptNextAlert = true;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingTest = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingTest)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public String closeAlertAndGetItsText() {
    try {
      Alert alert = wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  public void waitVisibility(By locator) {
    waitVisibility(locator, 3000);
  }

  public void waitVisibility(By locator, int time) {
    WebDriverWait wait = new WebDriverWait(wd, time);
    wait.until(ExpectedConditions.visibilityOf(wd.findElement(locator)));
  }

//  public void waitVisibility(WebElement element, int time) {
//    WebDriverWait wait = new WebDriverWait(wd, time);
//    wait.until(ExpectedConditions.visibilityOf(element));
//  }
//
//  public void waitVisibility(WebElement element) {
//    waitVisibility(element, 3);
//  }
}
