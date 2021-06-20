package PuppiesAdoptionAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import BK_utilities.Puppyies;
import vytrackUI.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class BK_puppyies {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://puppies.herokuapp.com/");
    }
    @Test
    public void testCase1() throws InterruptedException {
        SoftAssert softAssertion = new SoftAssert();
        String dogName = "Twinkie";

        WebElement dogViewDetailsButton = Puppyies.findDogViewDetailsButton(driver, dogName);
        Thread.sleep(3000);
        //Assert.assertEquals(dogViewDetailsButton.isEnabled(), "There isn't a dog with this name");

        String dogInfoLandPage = Puppyies.getDogInfoLandPage(driver, dogName);
        dogViewDetailsButton.click();

        String dogInfoDogPage = Puppyies.getDogInfoDogPage(driver).getText();
        Assert.assertEquals(dogInfoLandPage, dogInfoDogPage, "Information on Land Page and Dog Page is different");

        WebElement adoptMeButton = driver.findElement(By.xpath("//input[@value='Adopt Me!']"));
        adoptMeButton.click();
        WebElement toyCheckBox = driver.findElement(By.id("toy"));
        toyCheckBox.click();
        WebElement carrierCheckBox = driver.findElement(By.id("carrier"));
        carrierCheckBox.click();

        double ActualTotalPrice = Puppyies.getActualTotalPrice(driver);
        double ExpectedTotalPrice = Puppyies.getExpectedTotalPrice(driver);
        softAssertion.assertEquals(Puppyies.getActualTotalPrice(driver), Puppyies.getExpectedTotalPrice(driver), "different Total Prices");

        WebElement completeTheAdoptionButton = driver.findElement(By.xpath("//input[@value='Complete the Adoption']"));
        completeTheAdoptionButton.click();

        Puppyies.fillOutOrderForm(driver, 1);

        WebElement placeOrderButton = driver.findElement(By.xpath("//input[@value='Place Order']"));
        placeOrderButton.click();

        softAssertion.assertEquals(driver.getTitle(), "Sally's Puppy Adoption Agency");
        softAssertion.assertEquals(driver.findElement(By.id("notice")).getText(), "Thank you for adopting a puppy!");


        softAssertion.assertAll();

    }

}




