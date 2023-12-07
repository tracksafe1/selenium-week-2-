package desktops;

import browsertesting.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DesktopsTest extends BaseTest {
    String baseurl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void start() {
        openbrowser(baseurl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
//  1.1  Mouse hover on Desktops Tab.and click
        Actions actions = new Actions(driver);
        WebElement desktop = driver.findElement(By.xpath("//a[text()='Desktops']"));
        actions.moveToElement(desktop).click().build().perform();


//    1.2 Click on “Show All Desktops”
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/div/a")).click();

//    1.3 Select Sort By position "Name: Z to A"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (Z - A)");
//1.4 Verify the Product will arrange in Descending order.
        List<WebElement> productElements = driver.findElements(By.xpath("//div[@id=\"content\"]/div[4]/div"));
// Extract product names and store them in a list
        List<String> productNames = new ArrayList<>();
        for (WebElement productElement : productElements) {
            productNames.add(productElement.getText());
        }
// Check if product names are in alphabetical order
        boolean isAlphabeticalOrder = true;
        for (int i = 1; i < productNames.size(); i++) {
            if (productNames.get(i - 1).compareToIgnoreCase(productNames.get(i)) > 0) {
                isAlphabeticalOrder = false;
                break;
            }
        }

        if (isAlphabeticalOrder) {
            System.out.println("Products are arranged in alphabetical order A-Z. ");
        } else {
            System.out.println("Products are arranged in alphabetical order Z-A.");
        }
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
//    2.1 Mouse hover on Desktops Tab. and click
        Actions actions = new Actions(driver);
        WebElement desktop = driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul[1]/li[1]/a"));
        actions.moveToElement(desktop).click().build().perform();

//    2.2 Click on “Show All Desktops”
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/div/a")).click();
//    2.3 Select Sort By position "Name: A to Z"
        WebElement dropdown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
//    2.4 Select product “HP LP3065”
        driver.findElement(By.xpath("//div[@id='content']/div[4]/div[3]/div/div[2]/div[1]/h4/a")).click();

//    2.5 Verify the Text "HP LP3065"
        String actualText = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/h1")).getText();
        System.out.println(actualText);
        String ecpextedText = "HP LP3065";
        Assert.assertEquals(actualText, ecpextedText);

//   2.6 Select DeliveryDate= "2022-11-30"
        driver.findElement(By.id("input-option225")).clear();
        driver.findElement(By.id("input-option225")).sendKeys("2022-11-30");

//    2.7.Enter Qty "1” using Select class.(We cannot use as there is no dropdown)
        driver.findElement(By.id("input-quantity")).clear();
        driver.findElement(By.id("input-quantity")).sendKeys("1");
//        2.8 Click on “Add to Cart” button
        driver.findElement(By.id("button-cart")).click();

//        2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Thread.sleep(1000);
        String actualresult = driver.findElement(By.xpath(" //div[@class=\"alert alert-success alert-dismissible\"]")).getText();

        System.out.println(actualresult);
        Thread.sleep(1000);
        String expectedResult = "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×";
        Assert.assertEquals(expectedResult, actualresult);
//        2.10 Click on link “shopping cart” display into success message

        driver.findElement(By.linkText("shopping cart")).click();
//
//        2.11 Verify the text "Shopping Cart"
        Thread.sleep(1000);
        String actual = driver.findElement(By.xpath("//div[@id='checkout-cart']/div[1]/div[1]/h1")).getText();
        System.out.println(actual);
        String expected = "Shopping Cart  (1.00kg)";
        Assert.assertEquals(actual, expected);
//        2.12 Verify the Product name "HP LP3065"
        Thread.sleep(1000);
        String actualProductname = driver.findElement(By.xpath("//div[@id='content']/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a")).getAccessibleName();
       System.out.println(actualProductname);
     String expectedProductName="HP LP3065";
       Thread.sleep(1000);
      Assert.assertEquals(actualProductname,expectedProductName);

////        2.13 Verify the Delivery Date "2022-11-30"
        String actualDelieverydate=driver.findElement(By.xpath("//div[@id='content']/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/small[1]")).getText();
        Thread.sleep(1000);


        String expectedDelieveryDate="Delivery Date:2022-11-30";
        Thread.sleep(1000);
        Assert.assertEquals(actualDelieverydate,expectedDelieveryDate);


////        2.14 Verify the Model "Product21"
        String actualModel=driver.findElement(By.xpath("//div[@id='content']/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")).getText();
        Thread.sleep(1000);
        System.out.println(actualModel);

        String expectedModel="Product 21";

        Assert.assertEquals(actualModel,expectedModel);
//
////        2.15 Verify the Todat "£74.73"

        String actualTotal=driver.findElement(By.xpath("//div[@id='content']/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")).getText();


        String expectedTotal="$122.00";
        Thread.sleep(1000);
        Assert.assertEquals(actualTotal,expectedTotal);


    }

    @After
    public void closeTest() {
    closebrowser();
    }
}
