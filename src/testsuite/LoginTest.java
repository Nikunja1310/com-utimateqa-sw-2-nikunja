package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully
 * * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email
 * or password.’
 */
public class LoginTest extends BaseTest {

    String baseURL = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseURL);
    }


    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Click on sign in
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();

        //Text verify
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();     //Actual
        String expectedText = "Welcome Back!";                                          //Expected
        Assert.assertEquals("Matches, no error", expectedText, actualText);       //Compare
    }


    @Test
    public void verifyTheErrorMessage() {
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        //Enter invalid username
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("nikki@gmail");
        //Enter invalid password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("nikkkkk");
        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        //Verify the error message ‘Invalid email or password.’
        String actualMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        String expectedMessage = "Invalid email or password.";
        Assert.assertEquals("Error Message displayed correctly", expectedMessage, actualMessage);
    }


    @After
    public void tearDown() {
        closeBrowser();

    }
}