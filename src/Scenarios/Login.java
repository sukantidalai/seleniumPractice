package Scenarios;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://birdbank.pythonanywhere.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.id("id_username")).sendKeys("testuser1");
        driver.findElement(By.id("id_password")).sendKeys("testpassword");
        driver.findElement(By.id("signin")).click();


    }
}
