import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    @Test
    public void task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driver.getTitle();
        Assert.assertEquals( driver.getTitle(),"Selenium Easy Demo - Simple " +
                "Form to Automate using Selenium");

Thread.sleep(4000);
        WebElement annoyingPopUp = driver.findElement(By.xpath("//a[contains(text(),'No, thanks!')]"));
        annoyingPopUp.click();

        WebElement enterMessage =driver.findElement(By.xpath("//*[@for='message']/following-sibling::input"));
        enterMessage.click();
        enterMessage.sendKeys("First Test Case");
        WebElement showMessage = driver.findElement(By.xpath("//button[@onclick='showInput();']"));
        showMessage.click();
        String expectedMessage = "First Test Case";
        WebElement actualShowMessage = driver.findElement(By.xpath("//label[text()='Your Message: ']/following-sibling::span"));
        String actualMessage = actualShowMessage.getText();

        Assert.assertEquals(expectedMessage, actualMessage);


    }
}
