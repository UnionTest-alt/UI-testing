package vytrackUI.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {
    public static void main(String[] args) {


     WebDriverManager.chromedriver().setup();
    WebDriver driver =new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://google.com");
    }
}
