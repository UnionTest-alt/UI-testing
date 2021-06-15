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
import org.testng.asserts.SoftAssert;
import vytrackUI.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static java.lang.Double.parseDouble;

public class VB_Brooke extends VB_Utilities {


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://puppies.herokuapp.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    /*
          TC001: Given: I am on a home page
                 When: I find Brook in the list and click View Details button
                 Then: I should be redirected to the page with dog's description
                 When: I click Adopt Me button
                 Then: I am redirected to Your Litter page
                 When: I choose Chew Toy and Travel Carrier
                 Then: I validate the total amount
                 When: I click Complete the Adoption button
                 And: I fill out the details form
                 And: I select check as a payment method and click the Place Order button
                 Then: I am redirected to the home page and see the confirmation message

     */

    @Test
    public void TC001() {
        SoftAssert softAssertion = new SoftAssert();
        String expectedDogInTheList = "Brook";
        Assert.assertTrue(findDogInTheList(expectedDogInTheList).isEnabled());
        findDogInTheList(expectedDogInTheList).click();
        String expectedPuppyName = "Brook";
        String expectedBreed = "Female Golden Retriever";
        String expectedDescription = "This young lady is trying to put her shelter eperience behind her." +
                " She's only about 7 months old, and as you can see from her picture, she loves her toys!! " +
                "Basically a blank slate as far as training, she'll fit into a new home very quickly.";

        String puppyName = getPuppyNameOnDescriptionPage();
        String breed = getBreed();
        String description = getDescription();

        Assert.assertEquals(puppyName, expectedPuppyName);
        Assert.assertEquals(breed, expectedBreed);
        Assert.assertEquals(description, expectedDescription);

        adoptButtonClick();
        double priceForBrook = getPuppyPrice();

        litterCheckboxes(2);
        litterCheckboxes(3);
        double chewyPrice = getLitterProductsPrices("Chew Toy");
        double travelCarrierPrice = getLitterProductsPrices("Travel Carrier");

        double expectedGrandTotal = priceForBrook + chewyPrice + travelCarrierPrice;
        double actualTotal = actualTotal();

        softAssertion.assertEquals(actualTotal,expectedGrandTotal);
        System.out.println(actualTotal);    // BUG

        completeAdoptionButton();
        formFillOut();
        selectPaymentType("Check");
        placeOrderButton();

        Assert.assertTrue(homePagePuppyList().isDisplayed());

        String expectedMessage = "Thank you for adopting a puppy!";
        String actualMessage = thanksForAdoptionMessage();

        Assert.assertEquals(actualMessage, expectedMessage);

        softAssertion.assertAll();
    }

}


