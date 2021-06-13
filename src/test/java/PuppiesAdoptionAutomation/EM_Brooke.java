package PuppiesAdoptionAutomation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vytrackUI.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;




public class EM_Brooke {
    WebDriver driver;




@BeforeClass
     public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://puppies.herokuapp.com/");
    }


    /** Scenario: Adopt Brooke, add a Chewy Toy and a Travel Carrier, pay with Check **/

    /**
     * Test case 1
     * Given: I’m on landing page
     * When: I locate Brook record and click on View Details
     * Then: I should be able to see dog’s description (name, breed, gender)
     * When: I click “Adopt me” button
     * Then: I should be able to see Your litter page
     * And: I check “Chew Toy ($8.99)” and “Travel Carrier ($39.99)” options
     * Then: I validate the Total price
     * And: I click on “Complete the Adoption” button
     * And: I fill the order details form
     * And: I select “Check” as a payment method and click on “Place order” button
     * Then: I should be redirected to landing page and see the conformation message
**/

@Test
    public void TestCase1() throws InterruptedException {
        SoftAssert softAssertion = new SoftAssert();
        String dogName = "Twinkie";

        WebElement dogViewDetailsButton = EM_Utilities.findDogViewDetailsButton(driver, dogName);
        Assert.assertTrue(dogViewDetailsButton.isEnabled(), "There isn't a dog with this name ");

        String dogInfoLandPage = EM_Utilities.getDogInfoLandPage(driver, dogName);
        dogViewDetailsButton.click();
        String dogInfoDogPage = EM_Utilities.getDogInfoDogPage(driver).getText();
        Assert.assertEquals(dogInfoLandPage, dogInfoDogPage, "Information on Land Page and Dog Page is different");

        WebElement adoptMeButton = driver.findElement(By.xpath("//input[@value='Adopt Me!']"));
        adoptMeButton.click();

        WebElement toyCheckBox = driver.findElement(By.id("toy"));
        toyCheckBox.click();
        WebElement carrierCheckBox = driver.findElement(By.id("carrier"));
        carrierCheckBox.click();

        double ActualTotalPrice = EM_Utilities.getActualTotalPrice(driver);
        double ExpectedTotalPrice = EM_Utilities.getExpectedTotalPrice(driver);
        softAssertion.assertEquals(EM_Utilities.getActualTotalPrice(driver), EM_Utilities.getExpectedTotalPrice(driver), "different Total Prices");

        WebElement completeTheAdoptionButton = driver.findElement(By.xpath("//input[@value='Complete the Adoption']"));
        completeTheAdoptionButton.click();

        EM_Utilities.fillOutOrderForm(driver, 1);

        WebElement placeOrderButton = driver.findElement(By.xpath("//input[@value='Place Order']"));
        placeOrderButton.click();

        softAssertion.assertEquals(driver.getTitle(), "Sally's Puppy Adoption Agency");
        softAssertion.assertEquals(driver.findElement(By.id("notice")).getText(), "Thank you for adopting a puppy!");


        softAssertion.assertAll();

    }

}
