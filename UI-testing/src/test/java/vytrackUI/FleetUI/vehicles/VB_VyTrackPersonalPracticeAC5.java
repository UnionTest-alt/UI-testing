package vytrackUI.fleetUI.vehicles;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vytrackUI.utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VB_VyTrackPersonalPracticeAC5 {
    /**
     * Scenario: user is able to change value of views per page to 10, 25, 50 and 100
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa3.vytrack.com/user/login");
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.close();
//    }

    @Test(priority = 1)
    public void tenViewsPerPage(){
        WebElement usernameBox = driver.findElement(By.xpath("//input[@name='_username']"));
        usernameBox.sendKeys("user13");
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='_password']"));
        passwordBox.sendKeys("UserUser123" + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        action.moveToElement(fleet).moveToElement(driver.findElement(By.xpath("(//span[@class='title title-level-2'])[1]"))).click().build().perform();

        WebElement viewsPerPageButton = driver.findElement(By.xpath("//button[@class='btn dropdown-toggle ']"));
        viewsPerPageButton.click();
        WebElement views10perPage = driver.findElement(By.xpath("(//ul[@class='dropdown-menu pull-right'])[2]/li[1]"));
        views10perPage.click();

        List<WebElement> carRows = driver.findElements(By.xpath("//tr[@class='grid-row']"));
        Assert.assertTrue(carRows.size() == 10);

    }

    @Test(priority = 2)
    public void twentyFiveViewsPerPage() {
        WebElement usernameBox = driver.findElement(By.xpath("//input[@name='_username']"));
        usernameBox.sendKeys("user13");
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='_password']"));
        passwordBox.sendKeys("UserUser123" + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        action.moveToElement(fleet).moveToElement(driver.findElement(By.xpath("(//span[@class='title title-level-2'])[1]"))).click().build().perform();
        WebElement viewsPerPageButton = driver.findElement(By.xpath("//button[@class='btn dropdown-toggle ']"));
        viewsPerPageButton.click();
        WebElement views25perPage = driver.findElement(By.xpath("(//ul[@class='dropdown-menu pull-right'])[2]/li[2]"));
        views25perPage.click();

        List<WebElement> carRows = driver.findElements(By.xpath("//tr[@class='grid-row']"));
        Assert.assertTrue(carRows.size() == 25);

    }
}
