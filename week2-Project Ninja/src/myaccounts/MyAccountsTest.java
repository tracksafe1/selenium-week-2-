package myaccounts;

import browsertesting.BaseTest;
import com.google.common.base.Verify;
import dev.failsafe.Call;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MyAccountsTest extends BaseTest {
    String baseurl="https://tutorialsninja.com/demo/index.php";
    public void clicking(String path) throws InterruptedException {
        WebElement click1 = driver.findElement(By.xpath(path));
        click1.click();}
    @Before
    public void starttest() {
        openbrowser(baseurl);
    }



//    Create the class MyAccountsTest
//1.1 create method with name "selectMyAccountOptions" it has one parameter name
//"option" of type string
    public void selectMyAccountOptions(String option) throws InterruptedException {
//        1.2 This method should click on the options whatever name is passed as parameter.
//            (Hint: Handle List of Element and Select options)


        List<WebElement> name = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li[1]"));
        for (WebElement name1 : name) {
            System.out.println(name1);
            String text1 = name1.getText();


            if (name1.getText().equalsIgnoreCase(option)) {
                Thread.sleep(1000);
                name1.click();
                break;
            }
        }
    }


    @Test
            public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
//                1.1 Clickr on My Account Link.
                driver.findElement(By.xpath("//div[@class='container']/div[2]/ul/li[2]/a")).click();
//                1.2 Call the method “selectMyAccountOptions” method and pass the parameter
                selectMyAccountOptions("Register");
//                1.3 Verify the text “Register Account”.
                Thread.sleep(1000);
                String actualtextAccount=driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText();
        System.out.println(actualtextAccount);
               String expectedtextAccount="Register Account";
            Assert.assertEquals(actualtextAccount,expectedtextAccount);

            }
            @Test
            public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
//                2.1 Clickr on My Account Link.
               driver.findElement(By.xpath("//div[@class='container']/div[2]/ul/li[2]/a")).click();

//               2.2 Call the method “selectMyAccountOptions” method and pass the parameter
driver.findElement(By.xpath("//div[@class='container']/div[2]/ul/li[2]/ul/li[2]")).click();
//               selectMyAccountOptions("Login");
//                2.3 Verify the text “Returning Customer”.


                String actualText = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/h2")).getText();
                String expectedText = "Returning Customer";
                Assert.assertEquals(actualText, expectedText);


            }
            @Test
            public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
//        3.1 Clickr on My Account Link.
                driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]/ul[1]/li[1]")).click();
//                3.3 Enter First Name

                driver.findElement(By.xpath("//fieldset[@id='account']/div[2]/div[1]/input")).sendKeys("bhavini");
//                3.4 Enter Last Name
                driver.findElement(By.xpath("//fieldset[@id='account']/div[3]/div/input")).sendKeys("Patel");
//                3.5 Enter Email
                driver.findElement(By.xpath("//fieldset[@id='account']/div[4]/div/input")).sendKeys("patel22514066@gmail.com");
//                3.6 Enter Telephone
                driver.findElement(By.xpath("//fieldset[@id='account']/div[5]/div/input")).sendKeys("123456789");
//                3.7 Enter Password
                driver.findElement(By.xpath("//div[@id='content']/form/fieldset[2]/div[1]/div[1]/input")).sendKeys("1234567");
//                3.8 Enter Password Confirm
                driver.findElement(By.xpath("//div[@id='content']/form/fieldset[2]/div[2]/div[1]/input")).sendKeys("1234567");
//                3.9 Select Subscribe Yes radio button
                   clicking("//div[@id='account-register']/div[1]/div[1]/form/fieldset[3]/div[1]/div[1]/label[1]/input[1]");
//                3.10 Click on Privacy Policy check box
                clicking("//div[@id='account-register']/div[1]/div[1]/form/div[1]/div[1]/input[1]");
//                3.11 Click on Continue button
                clicking("//div[@id='account-register']/div[1]/div[1]/form/div[1]/div[1]/input[2]");
////                3.12 Verify the message “Your Account Has Been Created!”
                Thread.sleep(1000);
                String actualText1=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
                String expectedText1 = "Your Account Has Been Created!";
                Assert.assertEquals(actualText1, expectedText1);
                ////                3.13 Click on Continue button
            driver.findElement(By.xpath("//div[@id='content']/div[1]/div[1]/a")).click();
////                3.14 Clickr on My Account Link.
                driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]")).click();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//nav[@id='top']/div[1]/div[2]/ul/li[2]/ul/li[5]")).click();
//////
//                3.16 Verify the text “Account Logout”
                String actualtextlogout=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
                System.out.println(actualtextlogout);
                String expectedtextlogout="Account Logout";
                Assert.assertEquals(actualtextlogout,expectedtextlogout);
//                3.17 Click on Continue button
                driver.findElement(By.xpath("//div[@id='content']/div/div[1]")).click();

            }

            @After
            public void endtest(){
//                closebrowser();
            }

        }
