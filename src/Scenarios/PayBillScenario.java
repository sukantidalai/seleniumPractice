package Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class PayBillScenario {
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://birdbank.pythonanywhere.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        driver.findElement(By.name("username")).sendKeys("testuser1");
        driver.findElement(By.name("password")).sendKeys("testpassword");
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        //click on PayBill tab
        driver.findElement(By.xpath("//a[text()='PAY BILLS']")).click();
        //click on Add new biller
        driver.findElement(By.id("add_payee")).click();

        //move to frame
       // WebElement frames = driver.findElement(By.xpath("//p[text()='Bill Payment']"));
        String mainId = driver.getWindowHandle();
        Set<String> allId = driver.getWindowHandles();
        for(String id : allId)
        {
            if(!mainId.equals(id))
            {
                driver.switchTo().window(id);
            }
        }
       // driver.switchTo().window(f8916d6be4630644113636353b3d04bf);

        //Eneter biller name
        driver.findElement(By.xpath("//input[@placeholder='Enter Biller Name']")).sendKeys("Rani");
        //Enter Registration number
       driver.findElement(By.xpath("//input[@placeholder='Enter Registration Number']")).sendKeys("2345678");
        //click on Auto pay radio button
        driver.findElement(By.id("yes")).click();
        //Enter Auto pay limit
        driver.findElement(By.xpath("//input[@placeholder='Enter Pay Limit']")).sendKeys("4000");

        //select autopay frequency
        WebElement Listfrequency = driver.findElement(By.xpath("//select[@id='frequency']"));
        Select frequency = new Select(Listfrequency);
        frequency.selectByValue("//option[@value='AUD']");

        //select autopay start date
        WebElement startDates = driver.findElement(By.xpath("//input[@id='start_date']"));
        //select date
        driver.findElement(By.xpath("//a[text()='13']")).click();

        //select autopay end date
        WebElement enddates = driver.findElement(By.xpath("//input[@id='end_date']"));
        //select date
        driver.findElement(By.xpath("//a[text()='22']")).click();

        //click on save button
        driver.findElement(By.xpath("//button[@id='save']")).click();

        //get confirmation message
        String message = driver.findElement(By.xpath("//span[@id='confirmationMessage']")).getText();
        if(!message.equals(message))
        {
            System.out.println("Not successful");
        }

        

    }
}
