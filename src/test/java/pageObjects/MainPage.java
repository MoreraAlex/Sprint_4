package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    public  MainPage (WebDriver driver)
    {
        this.driver = driver;
    }
    public void scrollToAccordionMenu()
    {
        Duration duration = Duration.ofSeconds(5);
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("accordion__heading-0"))));
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitForAccoardeonPannelToBeClickable(int i){
        Duration duration = Duration.ofMinutes(1);
        new WebDriverWait(driver, duration)
                .until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-"+i)));
    }
    public String getAccordeonText (int i)
    {
        Duration duration = Duration.ofSeconds(5);
        driver.findElement(By.id("accordion__heading-"+i)).click();
        new WebDriverWait(driver, duration);
        return driver.findElement(By.xpath(".//div[@id='accordion__panel-"+i+"']/p")).getText();
    }





}