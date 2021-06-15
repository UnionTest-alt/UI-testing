package PuppiesAdoptionAutomation;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class VB_Utilities {

    WebDriver driver;

    public void adoptButtonClick() {
        WebElement adoptMeButton = driver.findElement(By.xpath("//div/input[@value='Adopt Me!']"));
        adoptMeButton.click();
    }

    public WebElement findDogInTheList(String dogName) {
        List<WebElement> namesPageOne = driver.findElements(By.xpath("//h3"));
        List<WebElement> detailsButton = driver.findElements(By.xpath("//input[@value='View Details']"));
        for (int i = 0; i < namesPageOne.size(); i++) {
            if (namesPageOne.get(i).getText().equals(dogName)) {
                return detailsButton.get(i);
            }
        }

        nextPage();

        List<WebElement> namesPageTwo = driver.findElements(By.xpath("//h3"));
        List<WebElement> detailsButtonPageTwo = driver.findElements(By.xpath("//input[@value='View Details']"));
        for (int i = 0; i < namesPageTwo.size(); i++) {
            if (namesPageTwo.get(i).getText().equals(dogName)) {
                return detailsButtonPageTwo.get(i);
            }
        }

        nextPage();

        List<WebElement> namesPageThree = driver.findElements(By.xpath("//h3"));
        List<WebElement> detailsButtonPageThree = driver.findElements(By.xpath("//input[@value='View Details']"));
        for (int i = 0; i < namesPageThree.size(); i++) {
            if (namesPageThree.get(i).getText().equals(dogName)) {
                return detailsButtonPageThree.get(i);
            }
        }
        return null;
    }

    public String getPuppyNameOnDescriptionPage() {
        String name = driver.findElement(By.xpath("//h2")).getText();
        return name;
    }


    public void nextPage() {
        WebElement nextButton = driver.findElement(By.xpath("//a[.='Next →']"));
        nextButton.click();
    }


    public String getBreed() {
        String breed = driver.findElement(By.xpath("//div//h3")).getText();
        return breed;
    }

    public String getDescription() {
        String descriptionOfPuppy = driver.findElement(By.xpath("(//div/p)[2]")).getText();
        return descriptionOfPuppy;
    }

    public String litterName() {
        String name = driver.findElement(By.xpath("(//div[@id='content']//table/tbody/tr/td/h2)[1]")).getText();
        return name;
    }

    public String litterBreed() {
        String breed = driver.findElement(By.xpath("(//div[@id='content']//table/tbody/tr/td/h2)[2]")).getText();
        return breed;
    }

    public void litterCheckboxes(int index) {
        switch(index) {
            case 1: driver.findElement(By.xpath("(//div[@id='content']//table//td//input)[1]")).click();
                break;
            case 2: driver.findElement(By.xpath("(//div[@id='content']//table//td//input)[2]")).click();
                break;
            case 3: driver.findElement(By.xpath("(//div[@id='content']//table//td//input)[3]")).click();
                break;
            case 4: driver.findElement(By.xpath("(//div[@id='content']//table//td//input)[4]")).click();
                break;
        }
    }

    public double getLitterProductsPrices(String item) {
        String price = "";
        switch(item) {
            case "Collar & Leash":
                price = driver.findElement(By.xpath("(//div[@id='content']//table//td//div)[1]")).getText().substring(1);
                break;
            case "Chew Toy":
                price = driver.findElement(By.xpath("(//div[@id='content']//table//td//div)[2]")).getText().substring(1);
                break;
            case "Travel Carrier":
                price = driver.findElement(By.xpath("(//div[@id='content']//table//td//div)[3]")).getText().substring(1);
                break;
            case "First Vet Visit":
                price = driver.findElement(By.xpath("(//div[@id='content']//table//td//div)[4]")).getText().substring(1);
                break;
        }
        return parseDouble(price);
    }

    public double getPuppyPrice() {
        double price =Double.parseDouble(driver.findElement(By.xpath("//td[@class='item_price']/h2")).getText().substring(1));
        return price;
    }

    public double totalBeforeAddingProducts() {
        String totalAmount = driver.findElement(By.xpath("//div[@id='content']//table//td[@class='total_cell']")).getText().substring(1);
        return parseDouble(totalAmount);
    }

    public void changeYourMindButton() {
        driver.findElement(By.xpath("//input[@value='Change your mind']")).click();
    }

    public void handleAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String cartEmptyMessage() {
        String message = driver.findElement(By.xpath("//p[.='Your car is currently empty']")).getText();
        return message;
    }

    public void completeAdoptionButton() {
        driver.findElement(By.xpath("//input[@value='Complete the Adoption']")).click();
    }

    public void formFillOut() {
        List<WebElement> formFields = driver.findElements(By.xpath("//div[@class='field']/input"));
        Faker fake = new Faker();
        for (int i = 0; i < formFields.size(); i++) {
            switch(i) {
                case 0: formFields.get(i).sendKeys(fake.name().fullName());
                break;
                case 1: formFields.get(i).sendKeys(fake.internet().emailAddress());
                break;
            }
        }
        WebElement address = driver.findElement(By.xpath("//textarea[@id='order_address']"));
        address.sendKeys(fake.address().fullAddress());
    }

    public void selectPaymentType(String payment) {
        WebElement payType = driver.findElement(By.xpath("//select[@id='order_pay_type']"));
        Select select = new Select(payType);
        select.selectByVisibleText(payment);
    }

    public void placeOrderButton() {
        driver.findElement(By.xpath("//input[@value='Place Order']")).click();
    }

    public String thanksForAdoptionMessage() {
        String message = driver.findElement(By.xpath("//p[@id='notice']")).getText();
        return message;
    }

    public void adoptAnotherPuppyButton() {
        driver.findElement(By.xpath("//input[@value='Adopt Another Puppy']")).click();
    }

    public WebElement homePagePuppyList() {
        WebElement list = driver.findElement(By.xpath("//h1[.='Puppy List']"));
        return list;
    }

    public double actualTotal() {
        double total = parseDouble(driver.findElement(By.xpath("(//tr[@class='total_line']//h2)[2]")).getText().substring(1));
        return total;
    }



}
