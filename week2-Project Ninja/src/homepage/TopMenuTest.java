package homepage;

import browsertesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TopMenuTest extends BaseTest {
    String baseurl="http://tutorialsninja.com/demo/index.php";

        //this method should click on the menu
        public void selectMenu(String menu) {
            WebElement elements = driver.findElement(By.xpath(menu));
            elements.click();}

    @Before
    public void startTest(){
        openbrowser(baseurl);
    }




    @Test
            public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
                //Mouse hover on “Desktops” Tab and click
        Actions actions = new Actions(driver);
        WebElement desktops = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        actions.moveToElement(desktops).click().build().perform();

//   call selectMenu method and pass the menu = “Show All Desktops”
        Thread.sleep(1000);

        selectMenu("//ul[@class='nav navbar-nav']/li[1]/div/a");
//        1.3 Verify the text ‘Desktops’
        String actualResult = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();
        System.out.println(actualResult);
        String expectedResult = "Desktops";
        Assert.assertEquals(actualResult, expectedResult);}

            @Test
            public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
//    Mouse hover on “Laptops & Notebooks” Tab and click
                Actions actions = new Actions(driver);
                WebElement laptopsNotebooks = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
                actions.moveToElement(laptopsNotebooks).click().build().perform();

//   call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
                selectMenu("//ul[@class=\"nav navbar-nav\"]/li[2]/div/a");
//      Verify the text ‘Laptops & Notebooks
                String actualText2 =driver.findElement(By.tagName("h2")).getText();
                System.out.println(actualText2);
                String expectedResult2 = "Laptops & Notebooks";
                Assert.assertEquals(actualText2, expectedResult2);

            }
            @Test
            public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
                //  Mouse hover on “Components” Tab and click
                Actions action=new Actions(driver);
                WebElement components=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[3]/a"));
                action.moveToElement(components).click().build().perform();

//     call selectMenu method and pass the menu = “Show All Components”
               selectMenu("//ul[@class='nav navbar-nav']/li[3]/div[1]/a");

//     Verify the text ‘Components’
               String actualcomponent=driver.findElement(By.xpath("//h2")).getText();
                System.out.println(actualcomponent);
              String expectedcomponent="Components";
              Assert.assertEquals(actualcomponent,expectedcomponent);
            }
            @Test
            @After
            public void endTest() {
                   closebrowser();
            }
        }