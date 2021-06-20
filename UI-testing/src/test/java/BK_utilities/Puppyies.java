package BK_utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Puppyies {

    public static WebElement findDogViewDetailsButton(WebDriver driver, String dogName) {
        List<WebElement> DogsNamesOnTheFirstPage = driver.findElements(By.xpath("//h3"));
        List<WebElement> DogsViewDetailes = driver.findElements(By.xpath("//input[@value='View Details']"));

        for (int i = 0; i < DogsNamesOnTheFirstPage.size(); i++) {
            if (DogsNamesOnTheFirstPage.get(i).getText().equals(dogName)) {

                return DogsViewDetailes.get(i);
            }
        }

        WebElement nextButton = driver.findElement(By.xpath("//a[@class='next_page']"));
        nextButton.click();

        List<WebElement> DogsNamesOnTheSecondPage = driver.findElements(By.xpath("//h3"));
        List<WebElement> DogsViewDetailesSecondPage = driver.findElements(By.xpath("//input[@value='View Details']"));
        for (int i = 0; i < DogsNamesOnTheSecondPage.size(); i++) {
            if (DogsNamesOnTheSecondPage.get(i).getText().equals(dogName)) {
                return DogsViewDetailesSecondPage.get(i);
            }
        }
        WebElement nextButton2 = driver.findElement(By.xpath("//a[@class='next_page']"));
        nextButton2.click();

        List<WebElement> DogsNamesOnTheThirdPage = driver.findElements(By.xpath("//h3"));
        List<WebElement> DogsViewDetailesThirdPage = driver.findElements(By.xpath("//input[@value='View Details']"));
        for (int i = 0; i < DogsNamesOnTheThirdPage.size(); i++) {
            if (DogsNamesOnTheThirdPage.get(i).getText().equals(dogName)) {
                return DogsViewDetailesThirdPage.get(i);
            }
        }
        return null;
    }

    public static String getDogInfoLandPage(WebDriver driver, String dogName) {
        String breed = driver.findElement(By.xpath("((//h3[.='" + dogName + "']/../..//div)[3]//h4)[1]")).getText();
        String gender = driver.findElement(By.xpath("((//h3[.='" + dogName + "']/../..//div)[3]//h4)[2]")).getText();
        String DogInfoLandPage = gender + " " + breed;
        return DogInfoLandPage;

    }

    public static WebElement getDogInfoDogPage(WebDriver driver) {
        return driver.findElement(By.xpath("//h3"));
    }

    public static double getExpectedTotalPrice(WebDriver driver) {

        double expectedTotalPrice=Double.parseDouble(driver.findElement(By.xpath("//td[@class='item_price']/h2")).getText().substring(1));
        for (int i=1; i<driver.findElements(By.xpath("(//tbody//div)")).size()+1;i++) {
            try {
                expectedTotalPrice += Double.parseDouble(driver.findElement(By.xpath("(//tbody//div)["+i+"]")).getText().substring(1));

            } catch (Exception e) {

            }
        }
        return expectedTotalPrice;
    }

    public static double getActualTotalPrice(WebDriver driver) {
        double totalActualPrice = Double.parseDouble(driver.findElement(By.xpath("(//h2)[6]")).getText().substring(1));
        return totalActualPrice;
    }

    public static void fillOutOrderForm(WebDriver driver, int index){
        Faker faker=new Faker();

        WebElement nameField = driver.findElement(By.id("order_name"));
        nameField.sendKeys(faker.name().fullName());

        WebElement addressField = driver.findElement(By.id("order_address"));
        addressField.sendKeys(faker.address().fullAddress());

        WebElement eMail =  driver.findElement(By.id("order_email"));
        eMail.sendKeys(faker.name().lastName()+"@gmail");

//        //WebElement dropDown = driver.findElement(By.id("order_pay_type"));
//        Select select = new Select (driver.findElement(By.id("order_pay_type"));
//        select.selectByIndex(index);


    }


}



