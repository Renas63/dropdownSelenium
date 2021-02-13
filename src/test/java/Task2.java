import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

    @Test
    public void task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driver.getTitle();

        Thread.sleep(3000);
        WebElement annoyingPopUp = driver.findElement(By.xpath("//a[contains(text(),'No, thanks!')]"));
        annoyingPopUp.click();

        WebElement enter12= driver.findElement(By.id("sum1"));
        enter12.sendKeys("12");

        WebElement enter17= driver.findElement(By.id("sum2"));

        enter17.sendKeys("17");
        WebElement getTotal= driver.findElement(By.xpath("//*[@onclick='return total()']"));
        getTotal.click();
        WebElement message= driver.findElement(By.xpath("//*[@style='height: 50px; width: 100%;']"));
        String expectedMessage= "Total a + b = 29";

        Assert.assertEquals(expectedMessage,message.getText());
    }
}