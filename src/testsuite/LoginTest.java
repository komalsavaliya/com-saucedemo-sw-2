package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * 2. Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValid Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on page
 */
public class LoginTest extends BaseTest {
    static String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter User Name to User Name field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // driver.findElement(By.xpath("//input[@ id = 'user-name']")).sendKeys("standard_user");

        //Enter Password in Password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //driver.findElement(By.xpath("//input[@ id = 'password']")).sendKeys("secret_sauce");

        //Click on Login Button
        driver.findElement(By.id("login-button")).click();
        //driver.findElement(By.xpath("//input[@ id = 'login-button']")).click();

        //Verify the Text "Products"
        String exceptedText = "Products";
        String actualText = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(exceptedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter User Name to User Name field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // driver.findElement(By.xpath("//input[@ id = 'user-name']")).sendKeys("standard_user");

        //Enter Password in Password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //driver.findElement(By.xpath("//input[@ id = 'password']")).sendKeys("secret_sauce");

        //Click on Login Button
        driver.findElement(By.id("login-button")).click();
        //driver.findElement(By.xpath("//input[@ id = 'login-button']")).click();

        //Verify six products are displayed on page
        List<WebElement> products = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        int excepted = 6;
        int actual = products.size();
        Assert.assertEquals(excepted, actual);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
