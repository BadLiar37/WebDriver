import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WebDriverTest {

    @Test
    void webdriverTest(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://megatop.by/catalog/");
        driver.manage().window().maximize();
        WebElement searchField = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/header/div/div/div[1]/div/ul/li[2]")));
        String strbutton=new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/header/div/div/div[1]/div/ul/li[2]"))).getText().trim();
        assertEquals(strbutton,"МУЖЧИНЫ");
        searchField.click();
        new WebDriverWait(driver,30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@for, 'arrFilter_118_1717685296')]"))).click();
        String strcheckbox=new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@for, 'arrFilter_118_1717685296')]"))).getText().trim();
        assertEquals(strcheckbox,"150 - 200 BYN");
        String strpopupbutton=new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div[3]/div[3]/div[2]/a/span"))).getText().trim();
        assertEquals(strpopupbutton,"ПОКАЗАТЬ");
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div[3]/div[3]/div[2]/a"))).click();
        driver.quit();
    }
}