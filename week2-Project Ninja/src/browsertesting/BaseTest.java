package browsertesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
 public  static  WebDriver driver;
  public static void openbrowser(String baseurl){
      driver=new ChromeDriver();
      driver.get(baseurl);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
  }
  public void closebrowser(){
      driver.quit();
  }
}
