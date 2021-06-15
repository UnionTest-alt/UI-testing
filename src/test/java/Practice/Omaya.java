package Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vytrackUI.utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Omaya {
    WebDriver driver;

    @Test
    public void SetupClass() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        //   driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://omayo.blogspot.com/");

        WebElement multiSelect= driver.findElement(By.xpath("//*[@id='multiselect1']"));
        Select select = new Select (multiSelect);
        select.selectByVisibleText("Audi");

        Select olderNews = new Select(driver.findElement(By.xpath("//*[@id='drop1']")));
        olderNews.selectByValue("jkl");

        WebElement write = driver.findElement(By.xpath("//*[@id='ta1']"));
        write.sendKeys("Today I  bought new house ");


        WebElement write1 = driver.findElement(By.xpath("(//div[@class='widget-content'])[4]/textarea"));
        write1.sendKeys("Finally");

        WebElement btn = driver.findElement(By.xpath("//*[@id='but2']"));
        System.out.println("btn.isEnabled() = " + btn.isEnabled());


        WebElement table = driver.findElement(By.xpath("(//table[@id='table1']//tr)[5]/td/following-sibling::td[2]"));
        table.getText();

        WebElement userName = driver.findElement(By.xpath("((//div[@class='widget-content'])[6]//input)[1]"));
        userName.sendKeys("kainazarov");

        WebElement userPassword = driver.findElement(By.xpath("((//div[@class='widget-content'])[6]//input)[2]"));
        userPassword.sendKeys("123456789");

        WebElement loginBtn = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        loginBtn.click();
        loginBtn.isEnabled();

        driver.findElement(By.xpath("(//button[@name='samename'])[3]")).click();



        WebElement clickAfter = driver.findElement(By.xpath("//input[@id='alert2']"));
        clickAfter.click();
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);

        WebElement iframeClick = driver.findElement(By.xpath("(//iframe)[3]"));
        System.out.println("iframeClick.isDisplayed() = " + iframeClick.isDisplayed());
        iframeClick.click();

        Thread.sleep(3000);
        driver.switchTo().frame(2);

        WebElement chapter1 = driver.findElement(By.xpath("//*[text()='Chapter1']"));
        chapter1.click();

        driver.findElement(By.xpath("//input[@id='radiobutton']")).click();
        driver.findElement(By.xpath("//input[@name='selected(1234)']")).click();

        Select select1 = new Select(driver.findElement(By.xpath("//*[@id='selecttype']")));
        select1.selectByVisibleText("Selenium Grid");
        Thread.sleep(3000);

        System.out.println(driver.findElement(By.xpath("//input[@id='verifybutton']")).isEnabled());
        Thread.sleep(3000);

        WebElement write2 = driver.findElement(By.xpath("//div[@id='html5div']"));
        write2.sendKeys("I have been added some TEXT");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='secondajaxbutton']")).click();
        Thread.sleep(3000);

        driver.switchTo().defaultContent();

        WebElement username1= driver.findElement(By.xpath("//input[@name='userid']"));
        username1.sendKeys("kainazar");

        WebElement usernpass1= driver.findElement(By.xpath("//input[@name='pswrd']"));
        usernpass1.sendKeys("1234567");

        driver.findElement(By.xpath("//input[@onclick='check(this.form)']")).click();


        System.out.println("Thank you !");


        }

        }


