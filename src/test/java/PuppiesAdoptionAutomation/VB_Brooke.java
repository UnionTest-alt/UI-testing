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
     TC001: Given I am on a home page of Puppy Adoption Agency
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

    /*
         TC002: Given I am on a home page
                And I see Brook in the Puppy List
                And I click View Details button
                And I am on Brook's description page
                When I click Adopt me! button
                Then I am navigated to Brook's My Litter page
     */


    @Test(priority = 2)
    public void TC002() {
        driver.get("http://puppies.herokuapp.com/");
        WebElement viewDetailsButton = driver.findElement(By.xpath("//h3[.='Brook']/../..//div//input[@value='View Details']"));
        viewDetailsButton.click();

        WebElement adoptMeButton = driver.findElement(By.xpath("//div/input[@value='Adopt Me!']"));
        adoptMeButton.click();

        WebElement verifyName = driver.findElement(By.xpath("(//div[@id='content']//table/tbody/tr/td/h2)[1]"));
        String expName = "Brook:";

        WebElement verifyBreed = driver.findElement(By.xpath("(//div[@id='content']//table/tbody/tr/td/h2)[2]"));
        String expBreed = "Female - Golden Retriever";

        Assert.assertEquals(verifyName.getText(), expName);
        Assert.assertEquals(verifyBreed.getText(), expBreed);

    }

    /*
         TC003: Given I am on a home page
                And I see Brook in the Puppy List
                And I click View Details button
                And I am on Brook's description page
                And I click Adopt me! button
                And I am on the Brook's My Litter page
                When I choose to add a Chewy Toy and a Travel Carrier
                Then I should be able to see their prices pop up on the right side
     */

    @Test(priority = 3)
    public void TC003() {
        driver.get("http://puppies.herokuapp.com/");
        WebElement viewDetailsButton = driver.findElement(By.xpath("//h3[.='Brook']/../..//div//input[@value='View Details']"));
        viewDetailsButton.click();

        WebElement adoptMeButton = driver.findElement(By.xpath("//div/input[@value='Adopt Me!']"));
        adoptMeButton.click();

//        WebElement priceForBrook = driver.findElement(By.xpath("//div[@id='content']//table//td[@class='item_price']"));
//        WebElement totalAmount = driver.findElement(By.xpath("//div[@id='content']//table//td[@class='total_cell']"));
//
//        Assert.assertEquals(priceForBrook, totalAmount);

        WebElement chewyCheckBox = driver.findElement(By.xpath("//div[@id='content']//table//td//input[@id='toy']"));
        WebElement chewyPrice = driver.findElement(By.xpath("//div[@id='content']//table//td//div[@class='toy-amount']"));

        if (!chewyCheckBox.isSelected()) {
            Assert.assertTrue(!chewyPrice.isDisplayed());
        } else {
            System.out.println("BUG: price should not be visible");
        }

        WebElement travelCarrierBox = driver.findElement(By.xpath("//div[@id='content']//table//td//input[@id='carrier']"));
        WebElement carrierPrice = driver.findElement(By.xpath("//div[@id='content']//table//td//div[@class='carrier-amount']"));

        if (!travelCarrierBox.isSelected()) {
            Assert.assertTrue(!carrierPrice.isDisplayed());
        } else {
            System.out.println("BUG: price should not be visible");
        }

        chewyCheckBox.click();
        travelCarrierBox.click();

        if (chewyCheckBox.isSelected()) {
            Assert.assertTrue(chewyPrice.isDisplayed());
        } else {
            System.out.println("BUG: price should be visible");
        }

        if (travelCarrierBox.isSelected()) {
            Assert.assertTrue(carrierPrice.isDisplayed());
        } else {
            System.out.println("BUG: price should be visible");
        }

    }

}
