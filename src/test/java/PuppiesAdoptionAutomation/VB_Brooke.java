package PuppiesAdoptionAutomation;
/*
Scenario: Adopt Brooke, add a Chewy Toy and a Travel Carrier, pay with Check
 */



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vytrackUI.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class VB_Brooke {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
/*
     TC1: Given I am on a home page of Puppy Adoption Agency
          And I see Brook in the Puppy List
          When I click View Details button
          Then I am navigated to a page with Brook's short description
 */

    @Test(priority = 1)
    public void TC001() {
        driver.get("http://puppies.herokuapp.com/");
        WebElement viewDetailsButton = driver.findElement(By.xpath("//h3[.='Brook']/../..//div//input[@value='View Details']"));
        viewDetailsButton.click();
        String expectedPuppyName = "Brook";
        String expectedBreed = "Female Golden Retriever";
        String expectedDescription = "This young lady is trying to put her shelter eperience behind her." +
                " She's only about 7 months old, and as you can see from her picture, she loves her toys!! " +
                "Basically a blank slate as far as training, she'll fit into a new home very quickly.";

        String puppyName = driver.findElement(By.xpath("//div//h2")).getText();
        String breed = driver.findElement(By.xpath("//div//h3")).getText();
        String description = driver.findElement(By.xpath("(//div/p)[2]")).getText();

        Assert.assertEquals(puppyName, expectedPuppyName);
        Assert.assertEquals(breed, expectedBreed);
        Assert.assertEquals(description, expectedDescription);
    }

}
