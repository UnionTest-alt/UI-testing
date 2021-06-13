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
     TC001: Given I am on a home page of Puppy Adoption Agency
          And I see Brook in the Puppy List
          When I click View Details button
          Then I am navigated to a page with Brook's short description
 */

    @Test(priority = 1)
    public void TC001() {
        viewDetailsClick(1);
        String expectedPuppyName = "Brook";
        String expectedBreed = "Female Golden Retriever";
        String expectedDescription = "This young lady is trying to put her shelter eperience behind her." +
                " She's only about 7 months old, and as you can see from her picture, she loves her toys!! " +
                "Basically a blank slate as far as training, she'll fit into a new home very quickly.";

        String puppyName = getPuppyName();
        String breed = getBreed();
        String description = getDescription();

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
        viewDetailsClick(1);
        adoptButtonClick();

        String actualName = litterName();
        String expName = "Brook:";

        String actualBreed = litterBreed();
        String expBreed = "Female - Golden Retriever";

        Assert.assertEquals(actualName, expName);
        Assert.assertEquals(actualBreed, expBreed);

    }

    /*
         TC003: Given I am on a home page
                And I see Brook in the Puppy List
                And I click View Details button
                And I am on Brook's description page
                And I click Adopt me! button
                And I am on the Brook's My Litter page
                When I choose to add a Chewy Toy and a Travel Carrier
                Then the total amount should be updated and correct
     */

    @Test(priority = 3)
    public void TC003() throws InterruptedException {
        viewDetailsClick(1);
        adoptButtonClick();
        double priceForBrook = getPuppyPrice("Brook");
        double totalAmount = totalBeforeAddingProducts();

        Assert.assertEquals(priceForBrook, totalAmount);

        litterCheckboxes(2);
        litterCheckboxes(3);
        double chewyPrice = getLitterProductsPrices("Chew Toy");
        double travelCarrierPrice = getLitterProductsPrices("Travel Carrier");

        double grandTotal = priceForBrook + chewyPrice + travelCarrierPrice;
        double expectedGrandTotal = 83.93;

        Assert.assertTrue(totalAmount != grandTotal);
        Assert.assertTrue(grandTotal == expectedGrandTotal);
        System.out.println(grandTotal);    // BUG - shows as $132.91 manually, automation shows expected total

    }

    /*
         TC004: Given I am on a home page
                And I see Brook in the Puppy List
                And I click View Details button
                And I am on Brook's description page
                And I click Adopt me! button
                And I am on the Brook's My Litter page
                When I choose to add a Chewy Toy and a Travel Carrier
                And the total amount is updated and correct
                And when I click Change your mind button
                Then I see an alert pop up
     */

    @Test(priority = 4)
    public void TC004() {
        viewDetailsClick(1);
        adoptButtonClick();

        litterCheckboxes(2);
        litterCheckboxes(3);

        changeYourMindButton();
        handleAlert();
        handleAlert();   // BUG - pops up twice
    }


    /*
         TC005: Given I am on a home page
                And I see Brook in the Puppy List
                And I click View Details button
                And I am on Brook's description page
                And I click Adopt me! button
                And I am on the Brook's My Litter page
                When I choose to add a Chewy Toy and a Travel Carrier
                And the total amount is updated and correct
                And when I click Change your mind button
                And I see an alert pop up
                And I accept I click OK
                Then I am redirected to the home page and message "Your cart is empty" is displayed

     */

    @Test(priority = 5)
    public void TC005() {
        viewDetailsClick(1);
        adoptButtonClick();

        litterCheckboxes(2);
        litterCheckboxes(3);

        changeYourMindButton();
        handleAlert();
        handleAlert();

        String expMessage = "Your cart is currently empty";
        String actualMessage = cartEmptyMessage();
        Assert.assertEquals(actualMessage, expMessage); // SYNTAX ERROR
    }

    /*
         TC006: Given I am on a home page
                And I see Brook in the Puppy List
                And I click View Details button
                And I am on Brook's description page
                And I click Adopt me! button
                And I am on the Brook's My Litter page
                When I choose to add a Chewy Toy and a Travel Carrier
                And the total amount is updated and correct
                And when I click Complete the Adoption
                Then I am redirected to the payment page
     */

    @Test(priority = 6)
    public void TC006() {
        viewDetailsClick(1);
        adoptButtonClick();

        litterCheckboxes(2);
        litterCheckboxes(3);

        completeAdoptionButton();
    }

    /*
         TC007: Given I am on a home page
                And I see Brook in the Puppy List
                And I click View Details button
                And I am on Brook's description page
                And I click Adopt me! button
                And I am on the Brook's My Litter page
                When I choose to add a Chewy Toy and a Travel Carrier
                And the total amount is updated and correct
                And when I click Complete the Adoption
                And I am redirected to the payment page
                And I put in my information
                And click Place Order
                Then I am redirected to the home page and Thank you for adopting a puppy! message is displayed
     */

    @Test(priority = 7)
    public void TC007() {
        viewDetailsClick(1);
        adoptButtonClick();

        litterCheckboxes(2);
        litterCheckboxes(3);

        completeAdoptionButton();
        formFillOut();
        selectPaymentType("Check");
        placeOrderButton();

        Assert.assertTrue(homePagePuppyList().isDisplayed());

        String expectedMessage = "Thank you for adopting a puppy!";
        String actualMessage = thanksForAdoptionMessage();

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    /*
         TC008: Given I am on a home page
                And I see Brook in the Puppy List
                And I click View Details button
                And I am on Brook's description page
                And I click Adopt me! button
                And I am on the Brook's My Litter page
                When I choose to add a Chewy Toy and a Travel Carrier
                And the total amount is updated and correct
                And when I click Adopt Another Puppy Button
                And I am redirected to the payment page
                And I put in my information
                And click Place Order
                Then I am redirected to the home page and Thank you for adopting a puppy! message is displayed
     */

    @Test(priority = 8)
    public void TC008() {
        viewDetailsClick(1);
        adoptButtonClick();
        litterCheckboxes(2);
        litterCheckboxes(3);
        adoptButtonClick();
        Assert.assertTrue(homePagePuppyList().isDisplayed());
    }
}


