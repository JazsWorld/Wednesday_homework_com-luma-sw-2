package testsuite;

import browserfactory.Base_Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * 3. Write down the following test into ‘RegisterTest’
 * class
 * 1. verifyThatSignInPageDisplay
 * * click on the ‘Create an Account’ link
 * * Verify the text ‘Create New Customer Account’
 * 2. userSholdRegisterAccountSuccessfully
 * * click on the ‘Create an Account’ link
 * * Enter First name
 * * Enter Last name
 * * Click on checkbox Sign Up for Newsletter
 * * Enter Email
 * * Enter Password
 * * Enter Confirm Password
 * * Click on Create an Account button
 * * Verify the text 'Thank you for
 * registering with Main Website Store.’
 * * Click on down aero neare Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out’
 */
public class RegisterTest extends Base_Test{
    //BaseUrl
    String baseUrl = "https://magento.softwaretestingboard.com/";

    //calling openBrowser method from parentclass BaseTest
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    //1. verifyThatSignInPageDisplay
    //* click on the ‘Create an Account’ link
    //* Verify the text ‘Create New Customer Account’

    @Test
    public void verifyThatSignInPageDisplay(){
        //* * click on the ‘Create an Account’ link
        driver.findElement(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']")).click();

        //* Verify the text ‘Create New Customer Account’
        String expectedresult = "Create New Customer Account";
        String actualresult = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals("The user is unable to redirect to create an account page: ", expectedresult,actualresult);
    }

    //2. userSholdRegisterAccountSuccessfully
    //* click on the ‘Create an Account’ link
    //* Enter First name
    //* Enter Last name
    //* Click on checkbox Sign Up for Newsletter
    //* Enter Email
    //* Enter Password
    //* Enter Confirm Password
    //* Click on Create an Account button
    //* Verify the text 'Thank you for registering with Main Website Store.’
    //* Click on down aero neare Welcome
    //* Click on Sign Out link
    //* Verify the text ‘You are signed out’

    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //* click on the ‘Create an Account’ link
        driver.findElement(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']")).click();

        //* Enter First name
        driver.findElement(By.xpath("(//input[@id = 'firstname'])")).sendKeys("Jagruit");

        //* Enter Last name
        driver.findElement(By.xpath("(//input[@id = 'lastname'])")).sendKeys("Jadeja");

        //* Enter Email
        driver.findElement(By.xpath("//input[starts-with(@id,'email')]")).sendKeys("jagruti1717@gmail.com");

        //* Enter Password
        driver.findElement(By.xpath("//input[@id='password' or @name ='password']")).sendKeys("12345@abc");

        //* Enter Confirm Password
        driver.findElement(By.id("password-confirmation")).sendKeys("12345@abc");

        //* Click on Create an Account button
        driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();

        //* Verify the text 'Thank you for
        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[text() ='Thank you for registering with Main Website Store.']")).getText();
        Assert.assertEquals("Error Message",expectedText,actualText);

        //* Click on down aero neare Welcome
        driver.findElement(By.xpath("//button[@type ='button']")).click();
        //Click on Sign Out link
        // driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
        driver.findElement(By.xpath("//a[@href = 'https://magento.softwaretestingboard.com/customer/account/logout/']")).click();

        //Verify the text ‘You are signed out’
        String actualText1 = "You are signed out";
        String expectedText1 = driver.findElement(By.xpath("//span[text()='You are signed out']")).getText();
        Assert.assertEquals("Error Message",actualText1,expectedText1);
    }
//    @After
//    public void tearDown(){
//        closeBrowser();


    }


