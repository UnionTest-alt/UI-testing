package vytrackUI.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {
    public static void main(String[] args) {


        getDriver("chrome").get("http://www.google.com");

    }

    public static WebDriver getDriver(String browserType) {
        WebDriver driver =null;
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return  new ChromeDriver();

        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();


        }
        return driver;
    }
}
