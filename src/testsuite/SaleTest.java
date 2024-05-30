package testsuite;

import browserfactory.Base_Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * 5.Write down the following test into ‘SaleTest’ class
 * 1. verifyTheTotalItemsDisplayedOnTheWomens
 * JacketsPage()
 * * Click on ‘Sale’ Menu tab
 * * Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
 * * Verify the text ‘Jackets’ is displayed
 * * Count the Total Item Displayed on Page
 * and print the name of all items into
 * console.
 * * Verify total 12 Items displayed on page.
 */
public class SaleTest extends Base_Test {
    //BaseUrl
    String baseUrl = "https://magento.softwaretestingboard.com/";

    //calling openBrowser method from parentclass BaseTest
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemDisplayedOnTheWomensJacketsPage(){
       // * * Click on ‘Sale’ Menu tab
        driver.findElement(By.xpath("//span[contains(text(),'Sale')]")).click();

        // * * Click on ‘Jackets’ link on left side
        driver.findElement(By.xpath("//a[contains(text(),'Jackets')]")).click();

        //* * Verify the text ‘Jackets’ is displayed
        String expectedText = "Jackets";
        String actualText = driver.findElement(By.xpath("//span[@class ='base']")).getText();
        Assert.assertEquals("Text is not displayed", expectedText, actualText);

        //* * Count the Total Item Displayed on Page
        // * and print the name of all items into
        // * console.
        // * * Verify total 12 Items displayed on page.

        //Count the Total Item Displayed on Page and print the name of all items into console
        List<WebElement> list = driver.findElements(By.xpath("//img[@class='product-image-photo']"));
        // System.out.println("Items displayed on the page are: " + list.size());
        List<WebElement> names = driver.findElements(By.xpath("//strong[@class='product name product-item-name']"));
        //iterate webElements and print it
        for (WebElement name : names) {
            System.out.println(name.getText());
        }
        //Verify total 12 Items displayed on page.
        List<WebElement> list1 = driver.findElements(By.xpath("//img[@class='product-image-photo']"));
        int actualNo = list1.size();
        int exceptedNo = 12;
        Assert.assertEquals("Product not displayed correctly", exceptedNo, actualNo);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
    }

