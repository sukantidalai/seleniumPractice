package OtherScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavBar {
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://bs-navbar.vercel.app/index.html");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[text()=\"Login\"]")).click();

        //1 way to scroll
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,100)", "");
        WebElement forgotKey = driver.findElement(By.linkText("forgot password?"));
        forgotKey.click();
        //2 way to scroll window
        //JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("arguments[0].scrollIntoView();", forgotKey);


        String message = driver.findElement(By.className("text-center")).getText();
        System.out.println(message);
        if(message.equals("You have requested to reset your password"))
        {
            System.out.println("Successfull");
        }

        driver.findElement(By.className("btn-success")).click();

        driver.findElement(By.className("btn-success")).click();

        driver.findElement(By.className("btn-success")).click();
    }
}
