import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {
@Test
    public void task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.getTitle();

        Thread.sleep(3000);
            WebElement checkBox= driver.findElement(By.id("isAgeSelected"));
            checkBox.click();
            WebElement validateSuccess= driver.findElement(By.id("txtAge"));
           String expectedResult= "Success - Check box is checked";
   Assert.assertEquals(expectedResult,validateSuccess.getText());

    }
}