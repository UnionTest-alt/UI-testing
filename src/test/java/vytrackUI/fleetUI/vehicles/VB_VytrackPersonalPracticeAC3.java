package vytrackUI.fleetUI.vehicles;

import vytrackUI.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VB_VytrackPersonalPracticeAC3 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa3.vytrack.com/user/login");
    }

    @Test
    public void fleet() throws InterruptedException {
        WebElement usernameBox = driver.findElement(By.xpath("//input[@name='_username']"));
        usernameBox.sendKeys("user13");
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='_password']"));
        passwordBox.sendKeys("UserUser123" + Keys.ENTER);

        Actions action = new Actions(driver);
        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        action.moveToElement(fleet).moveToElement(driver.findElement(By.xpath("(//span[@class='title title-level-2'])[1]"))).click().build().perform();

        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement exportGridButton = driver.findElement(By.xpath("//a[@title='With this button you will export the content of the grid as it appears to you, with filters and sorting applied. All pages will be exported.']"));
        exportGridButton.click();
        driver.findElement(By.xpath("//a[@title='CSV']")).click();

        //div[@class='flash-messages-frame']
        exportGridButton.click();
        driver.findElement(By.xpath("//a[@title='XLSX']")).click();
        WebElement message = driver.findElement(By.xpath("//div[.='Export started successfully. You will receive email notification upon completion.']"));
        Assert.assertTrue(message.isDisplayed());


    }
}
