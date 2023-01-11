import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task4 {
    public void reloadPage() {
        WebDriver driver = getDriver();
        By by = By.id("button id");
        WebElement button = driver.findElement(by);
        button.click();
        new WebDriverWait(driver, 5)
                .withMessage("The page was not unloaded")
                .until(ExpectedConditions.stalenessOf(button));
    }

    //todo move driver instance creation to a separate class and fix implementation
    public static WebDriver getDriver() {
        return new ChromeDriver();
    }
}
