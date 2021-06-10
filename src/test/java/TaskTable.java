import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vytrackUI.utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TaskTable {

    WebDriver driver;
@Test

    public void setupClass() throws InterruptedException {

        /**
         * Go to      https://rosettacode.org/wiki/Language_Comparison_Table
         *
         * T1
         * Locate table
         *
         * T2
         * Create a locator that returns all of the rows in this table and print out amount of rows
         *
         * T3
         * Create a locator that returns all of the rows inside the body and print out amount of these rows
         *
         * T4
         * Locate and print out table's headers
         *
         * T5
         * Create a locator that returns all of the cells inside of all of the rows on tbody and print out amount
         *
         * T6
         * Create a locator that returns all of the cells inside only "Java" row and print out them
         *
         * T7
         * Create a locator that returns all of the programming languages names
         *
         * T8
         * Print out languages names that have Garbage collection
         *
         * T9
         * Print out   Paradigm (see table headers) of Fortran and Object Pascal (Delphi)    languages
         *
         * T10
         * Locate "Pascal" language  and  by using preceding-folowing sibling found abd print out Python , Ruby, Visual Basic , Java, Fortran, C++, Algol 68
         *
         * T11
         * Create a locator that returns Type strength of  C# but by using Groovy text
         */
        driver = WebDriverFactory.getDriver("chrome");
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rosettacode.org/wiki/Language_Comparison_Table");


        driver.findElements(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']"));
        List < WebElement>  rows = driver.findElements(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr"));

        System.out.println("Amount of rows "+ rows.size());

        List <WebElement> header = driver.findElements(By.xpath("//body//thead"));
        for (WebElement headerText : header) {
        System.out.println("Text of the Header ---> "+ headerText.getText());

    }
        List <WebElement> allCells = driver.findElements(By.xpath("//table[@class='wikitable sortable " +
               "jquery-tablesorter']/tbody/tr/td"));
        System.out.println("ALL CELL IN THE TABLE --> "+ allCells.size());


        List <WebElement >javaCells = driver.findElements(By.xpath("(//body//table)[2]//tr[44]"));

        for (WebElement javaCellEach : javaCells) {
        System.out.println("Java Cells ---> "+javaCellEach.getText()+",");
    }
        List< WebElement > languages = driver.findElements(By.xpath("(//body//table)[2]//th//span"));
        for (WebElement EachLanguage : languages) {
        System.out.println("All Programming Languages ---> "+EachLanguage.getText());
    }
        List <WebElement> gc = driver.findElements(By.xpath("(//body//table)[2]//th//*[.='Garbage collection']"));
        System.out.println("How many GC names ----> "+ gc.size());

        System.out.println(" Print Fortran 2nd Cell ---> " + driver.findElement(By.xpath("(((//body//table)[2]//th)[45]//span//a//..//..//..//a//..)[3]")).getText());
        System.out.println("Print Object Pascal (Delphi)---> "+ driver.findElement(By.xpath("(//*[text()='object-oriented'])[30]")).getText());



        }

    }





