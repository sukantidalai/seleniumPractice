package Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TransferAmount {
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://birdbank.pythonanywhere.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.id("id_username")).sendKeys("testuser1");
        driver.findElement(By.id("id_password")).sendKeys("testpassword");
        driver.findElement(By.id("signin")).click();

        driver.findElement(By.linkText("TRANSFER")).click();

        driver.findElement(By.id("ownacc")).click();

        driver.findElement(By.id("9999000453354533")).click();

        WebElement fromAccounts = driver.findElement(By.id("fromaccount"));
        Select oneAccount = new Select(fromAccounts);
        oneAccount.selectByIndex(0);

        WebElement toAccount = driver.findElement(By.id("toaccount"));
        if(toAccount.isEnabled())
        {
            System.out.println("error");
        }

        driver.findElement(By.id("amount")).sendKeys("300");

        driver.findElement(By.xpath("//button[text()='Confirm']")).click();

        String message = driver.findElement(By.id("confirmationMessage")).getText();
        System.out.println(message);
        if(!message.equals("Transaction Successful"))
        {
            System.out.println("Not successful");
        }

    }
}
