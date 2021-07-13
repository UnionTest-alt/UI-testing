package guru99;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TS1_Login_Page {
    @Test

    public void setup() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("guruUrl"));

        WebElement userName = Driver.getDriver().findElement(By.name("uid"));
        Thread.sleep(3000);
        userName.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement password = Driver.getDriver().findElement(By.xpath("//*[@type='password']"));
        Thread.sleep(3000);
        password.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@name='btnLogin']"));
        loginBtn.click();

//        Alert alert = Driver.getDriver().switchTo().alert();
//        alert.accept();


        String expectedTitle = "Guru99 Bank Manager HomePage";
        Thread.sleep(3000);
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle, "Verification Passed!!!");

    }
}
