package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
  Creating the private constructor so this class' object
  is not reachable from outside
  */
    private Driver(){}

    /*
    Making our 'driver' instance private so that it is not reachable from outside of the class.
    We make it static, because we want it to run before everything else, and also we will use it in a static method
     */
    private static WebDriver driver;

    /** Creating re-useable utility method that will return same "driver"
     * instance everytime we call it
     *
     */

    public static  WebDriver getDriver(){
        if (driver == null) {


            /**
             * We read our browser type from configuration.properties file using.getProperty method
             * we creating in ConfigurationReader class
             */
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){

                // Depending on the Browser type our switch statement will determine to open specific type oof browser/driver
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driver;

    }

    public static void closeDriver(){
        if (driver!= null) {
            driver.quit();
            driver=null;

        }
    }


}
