import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverTest {
    private ChromeDriver driver;

    @BeforeEach
    public  void browserSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void webdriverTest(){
        driver.get("https://megatop.by/catalog/");
        WebElement menuElement = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/header/div/div/div[1]/div/ul/li[2]")));
        String menuElementText=menuElement.getText().trim();
        menuElement.click();
        WebElement checkboxItem =new WebDriverWait(driver,30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@for, 'arrFilter_118_1717685296')]")));
        String checkboxItemText=checkboxItem.getText().trim();
        checkboxItem.click();
        WebElement popupButton=new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div[3]/div[3]/div[2]/a")));
        String popupButtonText=popupButton.getText().trim();
        popupButton.click();
        Assertions.assertEquals(menuElementText,"МУЖЧИНЫ");
        Assertions.assertEquals(checkboxItemText,"150 - 200 BYN");
        Assertions.assertEquals(popupButtonText,"ПОКАЗАТЬ");
    }

    @AfterEach
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }

}