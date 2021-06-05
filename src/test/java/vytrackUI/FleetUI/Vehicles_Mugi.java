package vytrackUI.FleetUI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vytrackUI.utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Vehicles_Mugi {

        WebDriver driver;

        @BeforeClass
        public void setupClass() {
            // 1.Open Chrome browser
            // 2.Go to http://practice.cybertekschool.com/dropdown
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("https://qa3.vytrack.com/user/login");

            //Enter user name
            WebElement user = driver.findElement(By.xpath("//input[@id='prependedInput']"));
            user.sendKeys("user13");

            //Enter password + click on login button
            WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
            password.sendKeys("UserUser123" + Keys.ENTER);
        }

        @Test
        public void homePage() throws InterruptedException {
            /** TS 1 - Truck Driver should be able to see all Vehicle information once navigate to “Vehicle” under “Fleet" module.
             Given I log in as Truck driver
             When I navigate to Fleet
             Then I should see Vehicles module
             When I click on Vehicles
             Then I should see all Vehicle information
             */

            Thread.sleep(3000);
            WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
            fleet.click();

            WebElement vehicle = driver.findElement(By.xpath("//span[@class='title title-level-2']"));
            Thread.sleep(3000);
            vehicle.click();

            Thread.sleep(3000);
            String expectedTitle1 = "Car - Entities - System - Car - Entities - System";
            String actualTitle1 = driver.getTitle();

            Assert.assertEquals(actualTitle1, expectedTitle1);

            /** TS 2 – When Truck Driver click on any car on the grid, system should display general information about the car and when user click Go back then user should be able to see all Vehicle information table
             Given I log in as Truck driver
             When I navigate to Fleet
             Then I click vehicle button
             Then I see Vehicles page
             And I click on any car information
             Then I should be able to see General information about selected car
             When I click Go back
             Then I should be able to see all Vehicle information table
             */

            WebElement cybertek123 = driver.findElement(By.xpath("//td[.='Cybertek123456']"));
            cybertek123.click();

            List<WebElement> generalInformation = driver.findElements(By.xpath("//div[contains(@class, 'control-group attribute-row')]"));
            for (WebElement each : generalInformation) {
                System.out.println(each.getText());
            }

            driver.navigate().back();

            String expectedTitle2 = "Car - Entities - System - Car - Entities - System";
            Thread.sleep(3000);
            String actualTitle2 = driver.getTitle();

            Assert.assertEquals(actualTitle2, expectedTitle2);

            /**TS 3 – TS 3 – When Truck Driver click on Export Grid, should be able to export all Vehicle information as a .CSV and .XLSX file
             Given I log in as Truck driver
             When I navigate to Fleet
             Then I click vehicle button
             Then I see Vehicles page
             When I click on “Export Grid”
             Then I should be able to see option that .CSV
             When I click on .CSV
             Then I should see alert “Export started successfully. You will receive email notification upon completion”.
             */

            WebElement exportGrid = driver.findElement(By.xpath("//div[@class='btn-group']"));
            exportGrid.click();

            WebElement csv = driver.findElement(By.xpath("(//ul[@class='dropdown-menu']//a)[7]"));
            Thread.sleep(3000);
            csv.click();

            WebElement message = driver.findElement(By.xpath("//div[@class='message']"));
            message.isDisplayed();

//        String actualMessage = message.getText();
//        String expectedMessage = "Export started successfully. You will receive email notification upon completion.";
//        Assert.assertEquals(actualMessage, expectedMessage);


    }
}
