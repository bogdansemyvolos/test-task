import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task1 {

    public void clickElement(By by) {
        new WebDriverWait(getDriver(), 5)
                .ignoring(StaleElementReferenceException.class)
                .until(d -> {
                    d.findElement(by).click();
                    return true;
                });
    }

    //todo move driver instance creation to a separate class and fix implementation
    public static WebDriver getDriver() {
        return new ChromeDriver();
    }
}
