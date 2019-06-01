package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import utils.ConfigProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ApplicationManager {
  protected WebDriver wd;
  private String browser;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private String baseUrl;

  private StringBuffer verificationErrors = new StringBuffer();
  public static Properties properties = ConfigProperties.getInstance().getProperties();

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {

    switch (browser) {
      case BrowserType.FIREFOX:
        wd = new FirefoxDriver();
        break;
      case BrowserType.CHROME:
        wd = new ChromeDriver();
        break;
      case BrowserType.IE:
        wd = new InternetExplorerDriver();
        break;
    }
    switch (properties.getProperty("browser")){
      case "firefox":
        System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.wd"));
        wd = new FirefoxDriver();
        break;
      case "chrome":
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.wd"));
        wd = new ChromeDriver();
        break;
      default:
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.wd"));
        wd = new ChromeDriver();
    }
//    System.setProperty("webdriver.gecko.driver", "C:\\Tools\\geckodriver.exe");
//    System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");


//    if (browser.equals(BrowserType.FIREFOX)) {
//      wd = new FirefoxDriver();
//    } else if (browser.equals(BrowserType.CHROME)) {
//      wd = new ChromeDriver();
//    } else if (browser.equals(BrowserType.IE)) {
//      wd = new InternetExplorerDriver();
//    }

    baseUrl = properties.getProperty("app.url");
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.manage().window().maximize();
    wd.get(baseUrl);
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);

  }

  public void stop() {
    wd.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }


  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
