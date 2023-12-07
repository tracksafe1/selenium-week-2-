package laptopsandnotebooks;

import browsertesting.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;

import java.awt.*;

public class LaptopsAndNotebooksTest extends BaseTest {
    String baseurl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void starttest() {
        openbrowser(baseurl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
//        1.1 Mouse hover on Laptops & Notebooks Tab.and click
        driver.findElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[2]/a")).click();
//        1.2 Click on “Show All Laptops & Notebooks”
        driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul/li[2]/div[1]/a")).click();
//        1.3 Select Sort By "Price (High > Low)"
        WebElement sort = driver.findElement(By.id("input-sort"));
        Select selects = new Select(sort);
        selects.selectByIndex(4);

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
//        2.1 Mouse hover on Laptops & Notebooks Tab and click
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a")).click();
//        2.2 Click on “Show All Laptops & Notebooks”
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/div[1]/a")).click();
//        2.3 Select Sort By "Price (High > Low)"
        WebElement sort = driver.findElement(By.id("input-sort"));
        Select selects = new Select(sort);
        selects.selectByIndex(4);

//        2.4 Select Product “MacBook”
        driver.findElement(By.xpath("//div[@id='content']/div[4]/div[4]/div[1]/div[2]/div[1]/h4/a")).click();

//        2.5 Verify the text “MacBook”
        Thread.sleep(1000);
        String actualtext = driver.findElement(By.xpath("//div[@id='product-product']/div/div/div/div[2]/h1")).getText();
        String expectedText = "MacBook";
        Assert.assertEquals(actualtext, expectedText);

//        2.6 Click on ‘Add To Cart’ button
        driver.findElement(By.xpath("//div[@id='product-product']/div/div/div[1]/div[2]/div[2]/div/button")).click();
//        2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Thread.sleep(1000);
        String actualmessage = driver.findElement(By.xpath("//div[@id='product-product']/div[1]")).getText();
        String expectedmessage = "Success: You have added MacBook to your shopping cart!\n" +
                "×";
        Assert.assertEquals(actualmessage, expectedmessage);
//        2.8 Click on link “shopping cart” display into success message
        driver.findElement(By.linkText("shopping cart")).click();
//        2.9 Verify the text "Shopping Cart"
        Thread.sleep(1000);
        String actualtext1 = driver.findElement(By.xpath("//ul[@class='breadcrumb']/li[2]/a")).getText();
        String expectedtext1 = "Shopping Cart";
        Assert.assertEquals(actualtext1, expectedtext1);
//        2.10 Verify the Product name
        Thread.sleep(1000);
        String actualproductname = driver.findElement(By.xpath("//div[@class='table-responsive']/table[1]/tbody/tr/td[2]/a")).getText();
        String expectedproductname = "MacBook";
        Assert.assertEquals(expectedproductname, actualproductname);
//        2.11 Change Quantity "2"
        WebElement quantity = driver.findElement(By.xpath("//div[@class='table-responsive']/table[1]/tbody/tr/td[4]/div[1]/input[1]"));
        quantity.clear();
        quantity.sendKeys("2");
//        2.12 Click on “Update” Tab
        driver.findElement(By.xpath("//div[@class='input-group btn-block']/span[1]/button[1]")).click();

//        2.13 Verify the message “Success: You have modified your shopping cart!”
        Thread.sleep(1000);
        String actualmessage1 = driver.findElement(By.xpath("//div[@id='checkout-cart']/div[1]")).getText();

        String expectedmessage1 = "Success: You have modified your shopping cart!\n" +
                "×";

        Assert.assertEquals(actualmessage1, expectedmessage1);

//        2.14 Verify the Total £737.45
        Thread.sleep(1000);
        String actualTotal = driver.findElement(By.xpath("//div[@id='content']/div[2]/div/table/tbody/tr[4]/td[2]")).getText();
        String expectedTotal = "$1,204.00";
        Assert.assertEquals(expectedTotal, actualTotal);

//        2.15 Click on “Checkout” button
        driver.findElement(By.xpath("//div[@id='content']/div[3]/div[2]/a")).click();
//        2.16 Verify the text “Checkout”
        String actualcheckouttext = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expectedcheckoutbox = "Checkout";
        Assert.assertEquals(expectedcheckoutbox, actualcheckouttext);
//        2.17 Verify the Text “New Customer”
        Thread.sleep(1000);
        String actualnewcustomerText = driver.findElement(By.xpath("//div[@id='content']/div[1]/div[1]/div[2]/div/div/div[1]/h2")).getText();
        String expectednewCustomerText = "New Customer";
        Assert.assertEquals(actualnewcustomerText, expectednewCustomerText);
//        2.18 Click on “Guest Checkout” radio button
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label/input")).click();

//       2.19 Click on “Continue” tab

        driver.findElement(By.xpath("//input[@id='button-account']")).click();
//        2.20 Fill the mandatory fields
        //for firstname
        driver.findElement(By.xpath("//div[@id='content']/div[1]/div[2]/div[2]/div/div[1]/div[1]/fieldset/div[2]/input")).sendKeys("shikha");
        //for lastname
        driver.findElement(By.xpath("//div[@id='content']/div[1]/div[2]/div[2]/div/div[1]/div[1]/fieldset/div[3]/input")).sendKeys("kapur");
        // for Email
        driver.findElement(By.xpath("//div[@id='content']/div[1]/div[2]/div[2]/div/div[1]/div[1]/fieldset/div[4]/input")).sendKeys("sh1i@gmail.com");
        //for telephone
        driver.findElement(By.xpath("//div[@id='content']/div[1]/div[2]/div[2]/div/div[1]/div[1]/fieldset/div[5]/input")).sendKeys("123456789");
//        for address
        driver.findElement(By.xpath("//div[@id='content']/div[1]/div[2]/div[2]/div/div[1]/div[2]/fieldset/div[2]/input")).sendKeys("4,borehamholt");
//        for city
        driver.findElement(By.xpath("//div[@id='content']/div[1]/div[2]/div[2]/div/div[1]/div[2]/fieldset/div[4]/input")).sendKeys("London");
//        postcode
        driver.findElement(By.xpath("//div[@id='content']/div[1]/div[2]/div[2]/div/div[1]/div[2]/fieldset/div[5]/input")).sendKeys("WD63QJ");
//        country
        driver.findElement(By.xpath("//div[@id='content']/div[1]/div[2]/div[2]/div/div[1]/div[2]/fieldset/div[6]/select")).sendKeys("UnitedKingdom");
//        state
        driver.findElement(By.xpath("//div[@id='content']/div[1]/div[2]/div[2]/div/div[1]/div[2]/fieldset/div[7]/select")).sendKeys("Hertfordshire");
//        selecting dropdown
        Thread.sleep(1000);
        WebElement dropdown = driver.findElement(By.xpath("//div[@id='content']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/fieldset/div[7]/select"));
        Select select1 =new Select(dropdown);
        select1.selectByIndex(29);

////        2.21 Click on “Continue”Button

        driver.findElement(By.xpath("//input[@id=\"button-guest\"]")).click();
        Thread.sleep(1000);
//        2.22 Add Comments About your order into text area
//        String actualTextorder = driver.findElement(By.xpath("//div[@id='content']/div[1]/div[3]/div[2]/div[1]/div[1]")).getText();
//        String expectedTextorder = "Warning: No Payment options are available. Please contact us for assistance!";
//        Assert.assertEquals(actualTextorder,expectedTextorder);
// Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='content']/div[1]/div[3]/div[2]/div[1]/p[2]/textarea")).sendKeys("please write Fragile");
//       2.23 Check the Terms & Conditions check box
        driver.findElement(By.xpath("//div[@id='content']/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]")).click();
//      2.24 Click on “Continue” button
        driver.findElement(By.xpath("//div[@id='content']/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[2]")).click();
//        2.25 Verify the message “Warning: Payment method required!”
        Thread.sleep(1000);
       String actualText25 = driver.findElement(By.xpath("//div[@id='content']/div[1]/div[3]/div[2]/div[1]/div[1]")).getText();
      String expectedText25 = "Warning: Payment method required!\n" + "×";
       Assert.assertEquals(actualText25, expectedText25);

    }


    @After
    public void endtest() {
        closebrowser();
    }

}
