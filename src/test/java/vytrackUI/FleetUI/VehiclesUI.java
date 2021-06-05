package vytrackUI.FleetUI;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vytrackUI.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class VehiclesUI {
    WebDriver driver;

    /**
     US -> As a truck driver user I should be able to access Vehicle under Fleet module.

**/


    @BeforeClass
    public void SetupClass() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

        /**
 Scenario: User can export all Vehicle information as a CSV file
 */

    @Test
            public void exportCsv(){
        driver.get("https://qa3.vytrack.com/user/login");

    }

    /**
     Scenario: Truck driver user can see vehicle information on the Vehicle page
     Scenario: Truck driver user can access general information on personal car page
     Scenario: User can export all Vehicle information as a XLSX file
     Scenario: User can be able to hide fields of vehicle table in Grid Settings and to show them back by using Grid Settings button
     Scenario: User can be able to hide fields of vehicle table in Grid Settings and set back all default fields by using Reset button
     Scenario: User can be able to change value of views per page to 10, 25, 50 and 100
     Scenario: User can be able to click to next page
     */
}
