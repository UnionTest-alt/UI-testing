package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vytrackUI.utilities.WebDriverFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandle {

        WebDriver driver;

        @BeforeMethod
        public void setUpMethod() {
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://www.goibibo.com/flights/");
        }

        @Test
        public void windowHandleTest() {

            String parentWindow = driver.getWindowHandle();

            driver.findElement(By.xpath("//img[@src='https://gos3.ibcdn.com/img-1623846067.jpg']")).click();
            driver.switchTo().window(parentWindow);

            driver.findElement(By.xpath("//img[@src='https://gos3.ibcdn.com/img-1623671803.png']")).click();
            driver.switchTo().window(parentWindow);

            Set<String> allHandles = driver.getWindowHandles();

            for (String each : allHandles) {
                driver.switchTo().window(each);
                if (driver.getTitle().contains("IndiGo")) {
                    driver.switchTo().window(each);
                    break;
                }
            }

            driver.findElement(By.xpath("//button[@id='submitSearchButton']")).click();
        }
    }



