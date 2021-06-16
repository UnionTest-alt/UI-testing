package PuppiesAdoptionAutomation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vytrackUI.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class VB_TS3 extends VB_Utilities{

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
                 When: I find Ruby Sue in the list and click View Details button
                 Then: I should be redirected to the page with dog's description
                 When: I click Adopt Me button
                 Then: I am redirected to Your Litter page
                 When: I choose Collar & Leash
                 Then: I validate the total amount
                 When: I click Adopt Another Puppy
                 Then: I am redirected to the home page
                 When: I find Spud on the list and click View Details button
                 And: I click Adopt Me button
                 And: I choose Collar & Leash
                 Then: I validate the total amount
                 When: I click Complete the Adoption button
                 And: I fill out the details form
                 And: I select credit card as a payment method and click the Place Order button
                 Then: I am redirected to the home page and see the confirmation message

     */

    @Test
    public void TC002() {
        SoftAssert softAssertion = new SoftAssert();
        String expectedDogInTheList = "Ruby Sue";
        Assert.assertTrue(findDogInTheList(expectedDogInTheList).isEnabled());
        findDogInTheList(expectedDogInTheList).click();
        String expectedPuppyName = "Ruby Sue";
        String expectedBreed = "Female Pit Bull Terrier";
        String expectedDescription = "Cute, fun, and ready to play!! Meet Ruby Sue. She is a 4 month old leggy little red nose pit bull. " +
                "She is 20 lbs. of playful pup. She loves tug of war, fetch walks, runs, and anything you're up for. " +
                "On her softer side she also enjoys long belly rubs on her adorable piglet belly.";

        String puppyName = getPuppyNameOnDescriptionPage();
        String breed = getBreed();
        String description = getDescription();

        Assert.assertEquals(puppyName, expectedPuppyName);
        Assert.assertEquals(breed, expectedBreed);
        Assert.assertEquals(description, expectedDescription);

        adoptButtonClick();
        double priceForRubySue = getPuppyPrice();

        litterCheckboxes(1);

        double collarPrice = getLitterProductsPrices("Collar & Leash");

        double expectedGrandTotal = priceForRubySue + collarPrice;
        double actualTotal = actualTotal();

        softAssertion.assertEquals(actualTotal,expectedGrandTotal);
        System.out.println(actualTotal);// BUG

        adoptAnotherPuppyButton();

        String expectedDogInTheList2 = "Spud";
        Assert.assertTrue(findDogInTheList(expectedDogInTheList2).isEnabled());
        findDogInTheList(expectedDogInTheList).click();
        String expectedSecondPuppyName = "Spud";
        String expectedBreedSecondDog = "Male Beagle/Hound Mix";
        String expectedDescriptionSpud = "This 2 year old handsome boy is housetrained, and loves riding in the car. " +
                "He is playful and friendly and would make a great addition to your family.";

        String secondPuppyName = getPuppyNameOnDescriptionPage();
        String secondPuppyBreed = getBreed();
        String descriptionOfSecondPuppy = getDescription();

        Assert.assertEquals(secondPuppyName, expectedSecondPuppyName);
        Assert.assertEquals(secondPuppyBreed, expectedBreedSecondDog);
        Assert.assertEquals(descriptionOfSecondPuppy, expectedDescriptionSpud);

        adoptButtonClick();
        double priceForSpud = getPuppyPrice();

        litterCheckboxes(1);

        double collarPrice2 = getLitterProductsPrices("Collar & Leash");

//        double expectedGrandTotal = priceForRubySue + collarPrice;
//        double actualTotal = actualTotal();

        softAssertion.assertEquals(actualTotal,expectedGrandTotal);
        System.out.println(actualTotal);


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
