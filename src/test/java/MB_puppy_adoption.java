import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vytrackUI.utilities.WebDriverFactory;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MB_puppy_adoption {

    WebDriver driver;

    @BeforeClass
    public void setupClass() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://puppies.herokuapp.com/");
    }

    @Test
    public void TS1_adopt_brook(){

        WebElement BrookViewDetailsButton = driver.findElement(By.xpath("(//input[@class='rounded_button'])[1]"));
        BrookViewDetailsButton.click();

        WebElement AdoptMeButton = driver.findElement(By.xpath("//input[@value='Adopt Me!']"));
        AdoptMeButton.click();

        WebElement chewToy = driver.findElement(By.xpath("//input[@id='toy']"));
        chewToy.click();

        WebElement travelCarrier = driver.findElement(By.xpath("//input[@id='carrier']"));
        travelCarrier.click();

        WebElement completeAdoptionButton = driver.findElement(By.xpath("//input[@value='Complete the Adoption']"));
        completeAdoptionButton.click();

        WebElement name = driver.findElement(By.xpath("//input[@id='order_name']"));
        name.sendKeys("Mugi");

        WebElement address = driver.findElement(By.xpath("//textarea[@id='order_address']"));
        address.sendKeys("2700 S River Sd Ste 402, Des Plaines, IL 60018");

        WebElement email = driver.findElement(By.xpath("//input[@id='order_email']"));
        email.sendKeys("cybertek1222@yahoo.com");

        Select payType = new Select(driver.findElement(By.xpath("//select[@id='order_pay_type']")));
        payType.selectByVisibleText("Check");

        WebElement placeOrderButton = driver.findElement(By.xpath("//input[@name='commit']"));
        placeOrderButton.click();

        WebElement message = driver.findElement(By.xpath("//p[@id='notice']"));
        String actualMessage = message.getText();
        String expectedMessage = "Thank you for adopting a puppy!";

        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void TS2_adopt_sparky(){
        WebElement nextPageButton = driver.findElement(By.xpath("//a[@class='next_page']"));
        nextPageButton.click();

        WebElement sparkyViewDetailsButton = driver.findElement(By.xpath("(//input[@type='submit'])[1]"));
        sparkyViewDetailsButton.click();

        WebElement AdoptMeButton = driver.findElement(By.xpath("//input[@value='Adopt Me!']"));
        AdoptMeButton.click();

        WebElement collarAndLeash = driver.findElement(By.xpath("//input[@id='collar']"));
        collarAndLeash.click();

        WebElement completeAdoptionButton = driver.findElement(By.xpath("//input[@value='Complete the Adoption']"));
        completeAdoptionButton.click();

        WebElement name = driver.findElement(By.xpath("//input[@id='order_name']"));
        name.sendKeys("Mugi");

        WebElement address = driver.findElement(By.xpath("//textarea[@id='order_address']"));
        address.sendKeys("2700 S River Sd Ste 402, Des Plaines, IL 60018");

        WebElement email = driver.findElement(By.xpath("//input[@id='order_email']"));
        email.sendKeys("cybertek1222@yahoo.com");

        Select payType = new Select(driver.findElement(By.xpath("//select[@id='order_pay_type']")));
        payType.selectByVisibleText("Credit card");

        WebElement placeOrderButton = driver.findElement(By.xpath("//input[@name='commit']"));
        placeOrderButton.click();

        WebElement message = driver.findElement(By.xpath("//p[@id='notice']"));
        String actualMessage = message.getText();
        String expectedMessage = "Thank you for adopting a puppy!";

        Assert.assertEquals(actualMessage, expectedMessage);


    }

    @Test
    public void TS3_Adopt_2RandomDogs(){

        WebElement HannaViewDetailsButton = driver.findElement(By.xpath("(//input[@class='rounded_button'])[2]"));
        HannaViewDetailsButton.click();

        WebElement AdoptMeButton = driver.findElement(By.xpath("//input[@value='Adopt Me!']"));
        AdoptMeButton.click();

        WebElement AdoptAnotherPuppyButton = driver.findElement(By.xpath("//input[@value='Adopt Another Puppy']"));
        AdoptAnotherPuppyButton.click();

        WebElement MaggieMaeViewDetailsButton = driver.findElement(By.xpath("(//input[@class='rounded_button'])[3]"));
        MaggieMaeViewDetailsButton.click();

        WebElement AdoptMeButton1 = driver.findElement(By.xpath("//input[@value='Adopt Me!']"));
        AdoptMeButton1.click();

        WebElement firstCollarAndLeash = driver.findElement(By.xpath("//input[@id='collar']"));
        firstCollarAndLeash.click();

        WebElement SecondCollarAndLeash = driver.findElement(By.xpath("(//input[@id='collar'])[2]"));
        SecondCollarAndLeash.click();

        WebElement completeAdoptionButton = driver.findElement(By.xpath("//input[@value='Complete the Adoption']"));
        completeAdoptionButton.click();

        WebElement name = driver.findElement(By.xpath("//input[@id='order_name']"));
        name.sendKeys("Mugi");

        WebElement address = driver.findElement(By.xpath("//textarea[@id='order_address']"));
        address.sendKeys("2700 S River Sd Ste 402, Des Plaines, IL 60018");

        WebElement email = driver.findElement(By.xpath("//input[@id='order_email']"));
        email.sendKeys("cybertek1222@yahoo.com");

        Select payType = new Select(driver.findElement(By.xpath("//select[@id='order_pay_type']")));
        payType.selectByVisibleText("Credit card");

        WebElement placeOrderButton = driver.findElement(By.xpath("//input[@name='commit']"));
        placeOrderButton.click();

        WebElement message = driver.findElement(By.xpath("//p[@id='notice']"));
        String actualMessage = message.getText();
        String expectedMessage = "Thank you for adopting a puppy!";

        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void TS4_Adopt_2RandomDogs(){

        WebElement nextPageButton = driver.findElement(By.xpath("//a[@class='next_page']"));
        nextPageButton.click();

        WebElement spudViewDetailsButton = driver.findElement(By.xpath("(//input[@class='rounded_button'])[2]"));
        spudViewDetailsButton.click();

        WebElement AdoptMeButton = driver.findElement(By.xpath("//input[@value='Adopt Me!']"));
        AdoptMeButton.click();

        WebElement AdoptAnotherPuppyButton = driver.findElement(By.xpath("//input[@value='Adopt Another Puppy']"));
        AdoptAnotherPuppyButton.click();

        WebElement nextPageButton1 = driver.findElement(By.xpath("//a[@class='next_page']"));
        nextPageButton1.click();

        WebElement TipsyViewDetailsButton = driver.findElement(By.xpath("(//input[@class='rounded_button'])[3]"));
        TipsyViewDetailsButton.click();

        WebElement AdoptMeButton1 = driver.findElement(By.xpath("//input[@value='Adopt Me!']"));
        AdoptMeButton1.click();

        WebElement firstDigCollarAndLeash = driver.findElement(By.xpath("//input[@id='collar']"));
        firstDigCollarAndLeash.click();

        WebElement secondDogChewToy = driver.findElement(By.xpath("(//input[@id='toy'])[2]"));
        secondDogChewToy.click();

        WebElement secondDogVet = driver.findElement(By.xpath("(//input[@id='vet'])[2]"));
        secondDogVet.click();

        WebElement completeAdoptionButton = driver.findElement(By.xpath("//input[@value='Complete the Adoption']"));
        completeAdoptionButton.click();

        WebElement name = driver.findElement(By.xpath("//input[@id='order_name']"));
        name.sendKeys("Mugi");

        WebElement address = driver.findElement(By.xpath("//textarea[@id='order_address']"));
        address.sendKeys("2700 S River Sd Ste 402, Des Plaines, IL 60018");

        WebElement email = driver.findElement(By.xpath("//input[@id='order_email']"));
        email.sendKeys("cybertek1222@yahoo.com");

        Select payType = new Select(driver.findElement(By.xpath("//select[@id='order_pay_type']")));
        payType.selectByVisibleText("Credit card");

        WebElement placeOrderButton = driver.findElement(By.xpath("//input[@name='commit']"));
        placeOrderButton.click();

        WebElement message = driver.findElement(By.xpath("//p[@id='notice']"));
        String actualMessage = message.getText();
        String expectedMessage = "Thank you for adopting a puppy!";

        Assert.assertEquals(actualMessage, expectedMessage);

    }



}
