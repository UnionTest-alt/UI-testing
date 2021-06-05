package vytrackUI.FleetUI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import vytrackUI.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class VehiclesUI {
    WebDriver driver;

    /**
     * US -> As a truck driver user I should be able to access Vehicle under Fleet module.
     **/


    @BeforeMethod
    public void SetupClass() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");
    }

    /**
     * Scenario: User can export all Vehicle information as a CSV file
     */

    @Test
    public void exportCsv() throws InterruptedException {


        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("user13");

        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123" + Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        WebElement fleetButton = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetButton.click();

        WebElement vehiclesButton = driver.findElement(By.xpath("//span[.='Vehicles']"));
        vehiclesButton.click();


        WebElement exportGridButton = driver.findElement(By.xpath("(//i[@class='fa-upload'])[1]"));
        exportGridButton.click();

        WebElement exportCsvButton = driver.findElement(By.xpath("(//i[@class='fa-upload'])[2]"));
        exportCsvButton.click();


        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement exportCsvPopUp = driver.findElement(By.xpath("//div[@class='alert alert-success fade in top-messages ']"));

        String expectedExportCsvPopUpText = "×\n" + "Export started successfully. You will receive email notification upon completion.";
        String actualExportCsvPopUpText = exportCsvPopUp.getText();
        Assert.assertEquals(actualExportCsvPopUpText, expectedExportCsvPopUpText);

        driver.close();


    }

    /**
     * Scenario: User can export all Vehicle information as a XLSX file
     */
    @Test
    public void exportXlsx() throws InterruptedException {


        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("user13");

        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123" + Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        WebElement fleetButton = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetButton.click();

        WebElement vehiclesButton = driver.findElement(By.xpath("//span[.='Vehicles']"));
        vehiclesButton.click();

        WebElement exportGridButton = driver.findElement(By.xpath("(//i[@class='fa-upload'])[1]"));
        exportGridButton.click();

        WebElement exportXlsxButton = driver.findElement(By.xpath("(//i[@class='fa-upload'])[3]"));
        exportXlsxButton.click();


        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement exportXlsxPopUp = driver.findElement(By.xpath("//div[@class='alert alert-success fade in top-messages ']"));

        String expectedExportXlsxPopUpText = "×\n" + "Export started successfully. You will receive email notification upon completion.";
        String actualExportXlsxPopUpText = exportXlsxPopUp.getText();
        Assert.assertEquals(actualExportXlsxPopUpText, expectedExportXlsxPopUpText);

        driver.close();

        /**
         Scenario: Truck driver user can see vehicle information on the Vehicle page
         Scenario: Truck driver user can access general information on personal car page

         Scenario: User can be able to hide fields of vehicle table in Grid Settings and to show them back by using Grid Settings button
         Scenario: User can be able to hide fields of vehicle table in Grid Settings and set back all default fields by using Reset button
         Scenario: User can be able to change value of views per page to 10, 25, 50 and 100
         Scenario: User can be able to click to next page
         */
    }
}