import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task6 {
    @Test
    public void task() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='panel-body'] //input[@value='Male']"));
        elements.get(0).click();
        Thread.sleep(5000);
        Assert.assertTrue( elements.get(0).isSelected());

        List<WebElement> elements1 = driver.findElements(By.xpath("//div[@class='panel-body'] //input[@value='Female']"));
        Assert.assertFalse(elements1.get(1).isSelected());
        WebElement getCheckedValue= driver.findElement(By.id("buttoncheck"));
        getCheckedValue.click();
        WebElement success= driver.findElement(By.xpath("//*[@class='radiobutton']"));
        String expectedResult="Radio button 'Male' is checked";
       Assert.assertEquals(expectedResult,success.getText());
    }
}
