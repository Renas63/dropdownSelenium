import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task7 {
    @Test
    public void task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        driver.getTitle();
        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='panel-body'] //input[@value='Male']"));
        elements.get(1).click();
        Thread.sleep(5000);
        Assert.assertTrue( elements.get(1).isSelected());
        List<WebElement> elements1 = driver.findElements(By.xpath("//div[@class='panel-body'] //input[@value='Female']"));
        Assert.assertFalse(elements1.get(1).isSelected());

        WebElement age15To50= driver.findElement(By.xpath("//*[@value='15 - 50']"));
        age15To50.click();
        WebElement getValues= driver.findElement(By.xpath("//*[@onclick='getValues();']"));
        getValues.click();
        WebElement validationMessage= driver.findElement(By.xpath("//*[@class='groupradiobutton']"));
        String expectedResult= "Sex : Male\n" +
                "Age group: 15 - 50";
        Assert.assertEquals(expectedResult,validationMessage.getText());
    }
}