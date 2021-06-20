package vytrackUI.fleetUI.vehicles;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vytrackUI.utilities.WebDriverFactory;

public class VB_VyTrackPersonalPracticeAC1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa3.vytrack.com/user/login");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
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
    }
}
