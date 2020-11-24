import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebDriver {
    public static void main(String[] args) throws InterruptedException {
       System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver_win32/chromedriver.exe");

        ChromeDriver chromeDriver=new ChromeDriver();
        chromeDriver.get("http://seleniumhq.org");
        WebElement webElement=chromeDriver.findElement(By.id("q"));
        webElement.sendKeys("selenium java");
        WebElement searchBtn= chromeDriver.findElement(By.xpath("//*[@value='Go']"));
        chromeDriver.get("http://seleniumhq.org");
        searchBtn.click();
        Thread.sleep(2000);
        chromeDriver.quit();

    }
}
