import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverTest {

    @Test
    public void webdriverTest(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://megatop.by/catalog/");
        driver.manage().window().maximize();
        WebElement menuElement = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/header/div/div/div[1]/div/ul/li[2]")));
        String buttonText=menuElement.getText().trim();
        Assertions.assertEquals(buttonText,"МУЖЧИНЫ");
        menuElement.click();
        WebElement checkboxItem =new WebDriverWait(driver,30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@for, 'arrFilter_118_1717685296')]")));
        String checkboxText=checkboxItem.getText().trim();
        Assertions.assertEquals(checkboxText,"150 - 200 BYN");
        checkboxItem.click();
        WebElement popupButton=new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div[3]/div[3]/div[2]/a")));
        String popupButtonText=popupButton.getText().trim();
        Assertions.assertEquals(popupButtonText,"ПОКАЗАТЬ");
        popupButton.click();
        driver.quit();
    }
}