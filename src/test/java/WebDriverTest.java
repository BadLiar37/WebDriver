import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;

public class WebDriverTest {

    @Test
    public void webdriverTest(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://megatop.by/catalog/");
        driver.manage().window().maximize();
        WebElement searchField = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/header/div/div/div[1]/div/ul/li[2]")));
        String buttonText=new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/header/div/div/div[1]/div/ul/li[2]"))).getText().trim();
        Assertions.assertEquals(buttonText,"МУЖЧИНЫ");
        searchField.click();
        new WebDriverWait(driver,30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@for, 'arrFilter_118_1717685296')]"))).click();
        String checkboxText=new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@for, 'arrFilter_118_1717685296')]"))).getText().trim();
        Assertions.assertEquals(checkboxText,"150 - 200 BYN");
        String popupButtonText=new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div[3]/div[3]/div[2]/a/span"))).getText().trim();
        Assertions.assertEquals(popupButtonText,"ПОКАЗАТЬ");
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div[3]/div[3]/div[2]/a"))).click();
        driver.quit();
    }
}